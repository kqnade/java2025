package personal.kqnade;

public class Vector2DApp
{
    public static void main(String[] args) {
        double x, y;
        double a, b;
        Vector2D vectorA;
        Vector2D vectorB;

        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            a = Double.parseDouble(args[2]);
            b = Double.parseDouble(args[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide 4 numbers.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid numbers.");
            return;
        }
        vectorA = new Vector2D(x, y);
        vectorB = new Vector2D(a, b);

        System.out.println("Vector A = ");
        vectorA.print();
        System.out.println("Vector B = ");
        vectorB.print();
        vectorA.add(vectorB);
        System.out.println("Vector A + Vector B = ");
        vectorA.print();
    }
}