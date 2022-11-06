import java.awt.*;

public class Wolf implements Animal {

    public Wolf() {
        super();
    }

    public String toString() {
        return "W";
    }

    public int getMove() {

        double r = Math.random();

        if (r < 0.5)
            return NORTH;
        else
            return EAST;
    }


    public Color getColor() {
        return new Color(150, 150, 150);
    }
}
