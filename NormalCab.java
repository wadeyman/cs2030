
import java.util.List;

public class NormalCab extends Driver {
    private static final String DRIVERTYPE = "NormalCab";
    private static final JustRide justride = new JustRide();
    private static final TakeACab takeacab = new TakeACab();
    private static final List<SnatchService> listOf = List.of(justride, takeacab);
    private static final ImList<SnatchService> services = 
        new ImList<SnatchService>().addAll(listOf);
    

    NormalCab(String plate, int waitTime) {
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


