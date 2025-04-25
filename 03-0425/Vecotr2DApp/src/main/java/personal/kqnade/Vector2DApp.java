package personal.kqnade;

public class Vector2DApp {
    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        try {
            // input from arguments
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide two arguments for x and y.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide numeric values for x and y.");
            return;
        }
        Vector2D a = new Vector2D(x, y);
        a.print();
        System.out.println("Length: " + a.length());
        System.out.println("Angle (degrees): " + a.angle(true));
        System.out.println("Angle (radians): " + a.angle(false));
        System.out.println("Normalized: " + a.normalize().x + ", " + a.normalize().y);
    }
}
