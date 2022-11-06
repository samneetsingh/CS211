import java.awt.*;

public class Rabbit implements Animal {

    private boolean movingUpDown;
    private boolean movingEast;

    public Rabbit() {
        movingUpDown = false;
        movingEast = true;
    }

    public String toString() {
        return "V";
    }

    public int getMove() {
        movingUpDown = !movingUpDown;
        movingEast = !movingEast;

        if (!movingUpDown && !movingEast)
            return (NORTH * 2);
        else if (movingEast) {
            return (EAST * 2);
        }
        else
            return (SOUTH * 2);

    }

    public Color getColor() {
        return new Color(225, 0, 0);
    }
}
