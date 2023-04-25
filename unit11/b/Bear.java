package unit11.b;

// let's explore inheritance!
public class Bear {
    private Zoo place;
    private String name;

    public Bear(String name)
    {
        this.name = name;
    }

    public Bear()
    {
        this.name = "Bear";
    }
}

// https://wwf.panda.org/wwf_news/?163461/Is-the-giant-panda-a-bear
class Panda extends Bear {

    public Panda(String name)
    {
        super(name);
    }

    public Panda()
    {
        super();
    }
}

// https://en.wikipedia.org/wiki/List_of_giant_pandas
class Zoo {

}

// Zookeeper, Visitor, etc.
