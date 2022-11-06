import java.awt.*;

public class Turtle implements Animal {
    private boolean UpDown;
    private boolean LeftRight;

    public Turtle(){
        UpDown = true;
        LeftRight = false;
    }

    public String toString() {
        return "T";
    }

    public int getMove() {
        if (UpDown && !LeftRight) {

            return (SOUTH * 5);

        }
        else if (!UpDown && LeftRight) {
            return (WEST * 5);

        }
        else if (!UpDown && !LeftRight) {
            return (NORTH * 5);

        }
        else {
            return (EAST * 5);
        }
    }


    public Color getColor() {
        return new Color(0, 100, 100);
    }
}
