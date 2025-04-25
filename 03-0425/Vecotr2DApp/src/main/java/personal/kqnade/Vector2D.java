package personal.kqnade;

import java.lang.Math;

public class Vector2D {
    public final double x;
    public final double y;

    // Default constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("x=" + x + ", y=" + y);
    }
    // Calculates the length of the vector
    public double length() {
        return Math.sqrt(x * x + y * y);
    }
    // Calculates the angle of the vector in radians or degrees
    public double angle(boolean inDegrees) {
        double angle = Math.atan2(y, x);
        return inDegrees ? Math.toDegrees(angle) : angle;
    }
    // Normalizes the vector to a unit vector
    public Vector2D normalize() {
        double len = length();
        if (len == 0) {
            return new Vector2D(0, 0);
        }
        return new Vector2D(x / len, y / len);
    }
}
