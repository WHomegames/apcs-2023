package unit11.DiceGame_DoubleTrouble;

public class Player
{
    private int currentScore;

    public Player(int currentScore)
    {
        this.currentScore = currentScore;
    }

    public void setScore(int i)
    {
        currentScore = i;
    }

    public int getScore()
    {
        return currentScore;
    }

    public void RoleDice()
    {
        int d1 = (int)(Math.random() * 6) + 1;
        int d2 = (int)(Math.random() * 6) + 1;

        int diceNum = d1 + d2;

        if(d1 == d2)
        {
            currentScore -= 5;
        }
        else if(diceNum == 7)
        {
            currentScore += 3;
        }
        else if(diceNum % 2 != 0)
        {
            currentScore++;
        }
    }

    public boolean checkIfLost()
    {
        if(currentScore <= 0)
        {
            return true;
        }
        return false;
    }
}