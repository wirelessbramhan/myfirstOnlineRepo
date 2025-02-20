public class Main
{
    //making the deck
    public static  Card[] deckOfCards = new Card[52];

    public static void main(String[] args)
    {
        MakeTypeCards(13, 40);
        //CheckFacing();
    }

    public static void CheckFacing()
    {
        //Check if facing and print, this is a FOR EACH loop.
        //Default in Python. No indexer. No order, a bit slower.

        for (Card deckOfCard : deckOfCards) {
            if (deckOfCard.GetFacing()) {
                deckOfCard.PrintNumber();
            }
        }
    }

    public static void MakeTypeCards(int setNumber, int randomNumber)
    {
        int counter = 0;
        Card newCard = new Card();

        for (int i = 0; i < deckOfCards.length; i++)
        {
            if (i % setNumber == 0)
            {
                counter++;
                LogMsg(String.valueOf(counter));
            }

            switch (counter)
            {
                case 1 :
                    newCard = new HeartCard(i);
                    break;
                case 2 :
                    newCard = new SpadeCard(i);
                case 3 :
                    newCard = new DiamondCard(i);
                case 4 :
                    newCard = new ClubCard(i);
            }

            //Randomly turn Cards up
            if (i == randomNumber && i > 0)
            {
                newCard.SetFacing(true);
            }

            //Assign Card
            deckOfCards[i] = newCard;
            //LogMsg(newCard.GetCardData());
        }
    }

    public static void LogMsg(String msg)
    {
        if (!msg.isEmpty())
        {
            System.out.println(msg);
        }
    }
}