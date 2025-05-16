package personal.kqnade;

public class Vector2D
{
    private double x, y;

    // Default constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
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
}