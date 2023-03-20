
public class Bored {

    static int factorialum;

    public static void main(String[] args)
    {
        //System.out.println(factorialRecursing(10));
        //System.out.println(fibonacci(8));
        //System.out.println(reverseString("null is a fun one!"));
        System.out.println( slowerCalcPi(0, 6000, false));
        System.out.println(3 + calcPi(0, 6000, false));
        System.out.println( asFarIntoPI());
        //System.out.println(power(3, 17));
    }

    public static int power(int a, int b)
    {
        if(b == 1)
        {
            return a;
        }
        else
        {
            int ab = power(a, b/2);
            if(b % 2 == 1)
            {
                return ab * ab * a;
            }
            else
            {
                return ab * ab;
            }
        }
    }

    public static double asFarIntoPI()
    {
        return Math.sqrt(6d * (plzCalcPi(1, 10000) 
        + plzCalcPi(10001, 20000)  
        + plzCalcPi(20001, 30000) 
        + plzCalcPi(30001, 40000) 
        + plzCalcPi(40001, 50000)
        + plzCalcPi(50001, 60000)));
    }

    public static double plzCalcPi(int distIn, int distTo)
    {
        if(distIn < distTo)
        {

            return (1d/(distIn * distIn)) + plzCalcPi(++distIn, distTo);
        }
        //System.out.println("last one");
        return 1d/(distIn * distIn);

    }

    public static double slowerCalcPi(int distIn, int distTo, boolean inverter)
    {
        if(distIn < distTo)
        {

            if(inverter)
            {
                //System.out.println("add next");
                return (4d/((distIn * 2) + 1)) + slowerCalcPi(++distIn, distTo, false);
            }
            else
            {
                //System.out.println("subtract next");
                return (4d/((distIn * 2) + 1)) - slowerCalcPi(++distIn, distTo, true);
            }
        }
        //System.out.println("last one");
        return 4d/((distIn * 2) + 1);

    }

    public static double calcPi(int distIn, int distTo, boolean inverter)
    {
        if(distIn < distTo)
        {

            if(inverter)
            {
                //System.out.println("add next");
                return (4d/(((distIn * 2) + 2)*((distIn * 2) + 3)*((distIn * 2) + 4))) + calcPi(++distIn, distTo, false);
            }
            else
            {
                //System.out.println("subtract next");
                return (4d/(((distIn * 2) + 2)*((distIn * 2) + 3)*((distIn * 2) + 4))) - calcPi(++distIn, distTo, true);
            }
        }
        //System.out.println("last one");
        return 4d/(((distIn * 2) + 2)*((distIn * 2) + 3)*((distIn * 2) + 4));

    }

    public static String reverseString(String input)
    {
        if(input.length() == 1)
            return input;
            
        String head = input.substring(0, 1);
        String tail = input.substring(1);
        return reverseString(tail) + head;
    }


    public static int fibonacci(int n) 
    {
        //bad recursion
        if(n == 1)
            return 1;
        if(n == 0)
            return 0;
        
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }

        return result;
    }

    public static int factorialRecursing(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorialRecursing(n - 1);
    }
}