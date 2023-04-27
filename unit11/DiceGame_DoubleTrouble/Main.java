package unit11.DiceGame_DoubleTrouble;

public class Main
{
    public static void main(String[] args)
    {
        playFancyRound();
        //averageRounds();
        
    }

    public static void playFancyRound()
    {
        System.out.println("---------------------------------");
        System.out.println("    Welcome To Double Trouble    ");

        Player p1 = new Player(10);
        Player p2 = new Player(10);

        boolean roundInPlay = true;
        int rounds = 0;
        while(roundInPlay)
        {
            rounds++;
            p1.RoleDice();
            if(p1.checkIfLost())
                roundInPlay = false;
            p2.RoleDice();
            if(p2.checkIfLost())
                roundInPlay = false;

            //System.out.println(p1.getScore());
            //System.out.println(p2.getScore());
        }
        System.out.println("---------------------------------");
        System.out.println("The number of played rounds: " + rounds);
        System.out.println("Player one's score: " + p1.getScore());
        System.out.println("Player twos's score: " + p2.getScore());
        System.out.println("---------------------------------");
        
    }

    public static void averageRounds()
    {
        System.out.println("---------------------------------");
        System.out.println("    Welcome To Double Trouble    ");
        System.out.println("---------------------------------");

        Player p1 = new Player(10);
        Player p2 = new Player(10);

        double averageRoundLength = 0;
        for(int i = 0; i < 1000000; i++)
        {
            p1.setScore(10);
            p2.setScore(10);

            boolean roundInPlay = true;
            int rounds = 0;

            while(roundInPlay)
            {
                rounds++;
                p1.RoleDice();
                if(p1.checkIfLost())
                    roundInPlay = false;
                p2.RoleDice();
                if(p2.checkIfLost())
                    roundInPlay = false;

                //System.out.println(p1.getScore());
                //System.out.println(p2.getScore());
            }

            averageRoundLength += rounds;
        }
        averageRoundLength /= 1000000;


        System.out.println("The Average number of played rounds: " + averageRoundLength);
        System.out.println("---------------------------------");
        
        
    }
}
