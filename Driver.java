class Driver {
    private final String plate;
    private final int waitTime;
    private static final String DRIVERTYPE = "driverParentClass";
    private final ImList<SnatchService> services;
    
    Driver(String plate, int waitTime, ImList<SnatchService> services) {
        this.plate = plate;
        this.waitTime = waitTime;
        this.services = services;
    }

    public ImList<SnatchService> servicesList() {
        return this.services;
    }
    
    public String plate() {
        return this.plate;
    }

    public int waitTime() {
        return this.waitTime;
    }

    public String driverType() {
        return DRIVERTYPE;
    }

    public String toString() {
        return String.format("%s (%s mins away)", this.plate, this.waitTime);
    }

}
