class Car extends Vehicle {
    private int numDoors;

    public Car(String name, int maxSpeed, int numDoors) {
        super(name, maxSpeed);
        this.numDoors = numDoors;
    }

    @Override
    public String info() {
        return "Car: " + super.info().substring(9) + ", Doors: " + numDoors;
    }
}
