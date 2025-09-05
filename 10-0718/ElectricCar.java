class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String name, int maxSpeed, int numDoors, int batteryCapacity) {
        super(name, maxSpeed, numDoors);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String info() {
        return "ElectricCar: " + super.info().substring(5) + ", Battery: " + batteryCapacity + "kWh";
    }
}
