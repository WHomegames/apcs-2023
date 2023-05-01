package unit11;

public class Scuffed
{
    public static void main(String[] args)
    {
        String a = "132456";
        String b = "jhkl";
        String c = "oops";
        String d = "dsklafjasdfjl;";
        String e = "Hellow darkness my old friend";
        String f = "lol";
        String g = "wqert";
        String h = "qwerty keyboard layout";


        String yeah = a.concat(b).concat(c).concat(d).concat(e).concat(f).concat(g).concat(h);

        System.out.println(yeah);

        yeah = a + b + c + d + e + f + g + h;

        System.out.println(yeah);
    }
}
