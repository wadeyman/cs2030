public class PrivateCar extends Driver {
    private static final String DRIVERTYPE = "PrivateCar";
    
    private static final JustRide justride = new JustRide();
    private static final ShareARide sharearide = new ShareARide();
    private static final ImList<SnatchService> services 
        = new ImList<SnatchService>().add(justride).add(sharearide);

    PrivateCar(String plate, int waitTime) {
        super(plate, waitTime, services);
        
    }

    @Override
    public String driverType() {
        return DRIVERTYPE;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), this.driverType());
    }
}