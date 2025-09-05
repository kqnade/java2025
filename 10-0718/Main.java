public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Bicycle", 25);
        Car c = new Car("Sedan", 180, 4);
        ElectricCar e = new ElectricCar("Tesla Model 3", 225, 4, 75);

        System.out.println(v.info());
        System.out.println(c.info());
        System.out.println(e.info());
    }
}
