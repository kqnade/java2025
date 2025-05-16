package personal.kqnade;

public class Vector2D
{
    private double x, y;

    // Default constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public void print() {
        System.out.println(x + " " + y);
    }

    public double normCalc() {
        return Math.sqrt(x * x + y * y);
    }

    public void add(Vector2D InputVec) {
        this.x += InputVec.x;
        this.y += InputVec.y;
    }

    public static Vector2D add(Vector2D InputVec1, Vector2D InputVec2) {
        Vector2D result = new Vector2D();
        result.x = InputVec1.x + InputVec2.x;
        result.y = InputVec1.y + InputVec2.y;
        return result;
    }

    public static Vector2D subtract(Vector2D InputVec1, Vector2D InputVec2) {
        Vector2D result = new Vector2D();
        result.x = InputVec1.x - InputVec2.x;
        result.y = InputVec1.y - InputVec2.y;
        return result;
    }

    public double calcDistance(Vector2D InputVec1, Vector2D InputVec2) {
        Vector2D diff = subtract(InputVec1, InputVec2);
        return diff.normCalc();
    }
}