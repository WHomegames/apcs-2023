import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    private SpellingBee( char[] letters, char mustUse)
    {
        this.letters = letters;
        this.mustUse = mustUse;
    }

    public boolean checkWord(String word) 
    {
        boolean hasSpecial = false;
        for(int i = 0; i < word.length(); i++)
        {
            char a = word.charAt(i);
            if(letters[i] != a)
            {
                return false;
            }
            else if(a == mustUse)
                hasSpecial = true;
        }

        if(hasSpecial)
            return true;
        return false;
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename)
    {
        String contents = "";
        Path path = Paths.get(filename);
        try
        {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
            
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args)
    {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");
        // TODO solve me!
         SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');

         ArrayList<String> goodWords = new ArrayList<String>();

         for (String word : words)
         {
           if(bee.checkWord(word))
           goodWords.add(word);
            
         }

         

        // TODO sort words!

        // TODO what position in the sorted list is the word "search" ?

    }
}
