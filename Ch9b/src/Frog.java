import java.awt.Color;

public class Frog implements Animal {

    public Frog() {
        super();
    }

    public String toString() {
        return "F";
    }

    public int getMove() {
        double r = Math.random();
        if (r < 0.25)
            return (NORTH * 3);
        else if (r < 0.5)
            return (SOUTH * 3);
        else if (r < 0.75)
            return (WEST * 3);
        else
            return (EAST * 3);

    }


    public Color getColor() {
        return Color.GREEN;
    }

}
