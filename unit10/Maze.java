package unit10;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.awt.Point;

public class Maze {
    private boolean solution;
    private char[][] maze;

    /**
     * Instantiates a Maze instance based on the provided arguments
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @param line the values to be placed in the maze.
     */
    public Maze(int rows, int cols, String line)
    {
        maze = new char[rows][cols];
        solution = false;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                maze[i][j] = line.charAt(i * rows + j);
            }
        }

        //System.out.println(getStart());
        //System.out.println(getEnd());
        check(getStart());
    }

    /**
     * @return the starting coordinates as "x y"
     */
    /*
    public String getStart() { // Not shown, plz ignore implementation
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }
    */

    public Point getStart() { // Not shown, plz ignore implementation
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return new Point(z / maze[0].length, z % maze[0].length);
    }

    /**
     * @return the ending coordinates as "x y"
     */

    /*
    public String getEnd() { // Not shown, plz ignore implementation 
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }
    */

    public Point getEnd() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return new Point(z / maze[0].length, z % maze[0].length);
    }

    private boolean isNotCheckedAndIsInBoundsAndIsGood(Point c)
    {
        if(c.x >= 0 && c.x < maze.length && c.y >= 0 && c.y < maze[0].length)

            return maze[c.x][c.y] != 'c' && maze[c.x][c.y] != '#';
        else
        
            return false;
    }

    private void setChecked(Point c)
    {
        if(c.x >= 0 && c.x < maze.length && c.y >= 0 && c.y < maze[0].length)
            maze[c.x][c.y] = 'c';
    }

    /**
     * Uses recursion to see if the maze has a solution or not.
     * 
     * Suggested algorithm:
     * if X and Y are in bounds and spot is not a #
     * - if you are at $:
     * - - set has a solution
     * - else:
     * - - mark spot as checked
     * - - recur up
     * - - recur down
     * - - recur left
     * - - recur right
     * 
     * @param pos current position in 2D array
     */
    private void check(Point pos)
    {
        //System.out.println("steping forward in call stack");
        //System.out.print("looping... is a clear path? : ");
        //System.out.println(isNotCheckedAndIsInBoundsAndIsGood(pos));

        if(isNotCheckedAndIsInBoundsAndIsGood(pos) && !solution) 
        {
            //System.out.println("checking: " + pos);
            
            if(pos.equals(getEnd()))
            {
                System.out.println("Is it over? YES");
                solution = true;

                setChecked(pos);
            }
            else 
            {
                setChecked(pos);


                check(new Point(pos.x + 1, pos.y)); //right
                check(new Point(pos.x, pos.y + 1)); //up
                check(new Point(pos.x - 1, pos.y)); //left
                check(new Point(pos.x, pos.y - 1)); //down
            }

        }
        else
        {
            //System.out.println("did not travel path");
            //System.out.println("steping backward in call stack");
        }


    }

    /**
     * Determines if there is a solution (a path of '.') for this maze.
     * 
     * @return true if the maze has a path from Start (@) to End ($).
     */
    public boolean hasSolution() {
        
        return solution;

    }

    // HINT overriding toString may be handy. :)

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());

        Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
        check(case1.hasSolution());

        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());

        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());

        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());

        System.out.println("Happy Panda! \uD83D\uDC3C");

    }

}
