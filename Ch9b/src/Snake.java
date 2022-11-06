import java.awt.*;

public class Snake implements Animal {

    private int i;
    private boolean slither;
    private boolean EastSouth;
    private boolean West;

    public Snake() {
        i = 1;
        slither = true;
        EastSouth = true;
        West = true;
    }

    public String toString() {
        return "S";
    }

    public int getMove() {
        EastSouth = !EastSouth;

        if (!slither) {
            i++;
        }
        if (EastSouth) {
            slither = !slither;
            return (EAST * i);
        }
        else if (!slither)
            return WEST;
        else {
            return (SOUTH);
        }

    }

    public Color getColor() {
        return new Color(100, 100, 0);
    }
}
