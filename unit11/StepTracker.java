package unit11;

// 2019 FRQ #2
// https://apcentral.collegeboard.org/media/pdf/ap19-frq-computer-science-a.pdf#page=7
public class StepTracker {

    // TODO implement me!

    int minStepsToConsiderActive;
    int activeDays;
    int days;
    int steps;

    public StepTracker(int minStepsToConsiderActive)
    {
        this.minStepsToConsiderActive = minStepsToConsiderActive;
        activeDays = days = steps = 0;
    }

    public int activeDays()
    {
        return activeDays;
    }

    public double averageSteps()
    {
        if(steps == 0)
            return 0;
        return ((double)steps)/days;
    }

    public void addDailySteps(int s)
    {
        activeDays += ((s > minStepsToConsiderActive) ? 1 : 0) + (days += ((steps += s) % 1) + 1) % 1;
    }

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("bad panda");
    }

    public static void main(String[] args) {
        // uncomment the following lines to test your code
        StepTracker tr = new StepTracker(10000);
        check(tr.activeDays() == 0);
        check(tr.averageSteps() == 0.0);
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        check(tr.activeDays() == 0);
        check(tr.averageSteps() == 7000.0);
        tr.addDailySteps(13000);
        check(tr.activeDays() == 1);
        check(tr.averageSteps() == 9000.0);
        tr.addDailySteps(23000);
        tr.addDailySteps(1111);
        check(tr.activeDays() == 2);
        check(tr.averageSteps() == 10222.2);
        System.out.println("Happy Panda! \uD83D\uDC3C");
    }
}
