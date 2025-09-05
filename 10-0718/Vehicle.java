class Vehicle {
    private String name;
    private int maxSpeed;

    public Vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String info() {
        return "Vehicle: " + name + ", Max speed: " + maxSpeed + "km/h";
    }
}
