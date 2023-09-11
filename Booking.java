import java.lang.Comparable;
//import java.util.Comparator;

class Booking implements Comparable<Booking> {
    private final Driver driver;
    private final Request request;
    private final String store;

    Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
        this.store = "";
    }

    Booking(Driver driver, Request request, String store) {
        this.driver = driver;
        this.request = request;
        this.store = store;
    }

    public Driver driver() {
        return this.driver;
    }
    
    public Request request() {
        return this.request;
    }

    public String driverString() {
        return this.store;
    }

    private SnatchService bestService() {
        ImList<SnatchService> tolook = this.driver.servicesList();
        ImList<Integer> fareCents = new ImList<Integer>();
        for (SnatchService services : tolook) {
            int eachFare = this.request.computeFare(services);
            fareCents = fareCents.add(eachFare);
        }
        fareCents = fareCents.sort(new CompareX());
        int lowestFare = fareCents.get(0);
        int aa = 0;
        for (int i = 0; i < tolook.size(); i++) {
            if (tolook.get(i).computeFare(this.request.distance(), 
                this.request.pax(), this.request.time()) == lowestFare) {
                aa = i;
            }
        }
        return tolook.get(aa);
    }
    // --OK here

    public int dollarFare() {
        int fare = this.bestService().computeFare(
            this.request.distance(), this.request.pax(), this.request.time());
        return fare;
    }

    public double dbldollarFare() {
        double bb = this.dollarFare();
        return bb / 100;
    }

    @Override
    public int compareTo(Booking other) {
        int diff = this.dollarFare() - other.dollarFare();
        if (diff == 0) {
            int waitdiff = this.driver.waitTime() - other.driver.waitTime();
            return waitdiff;
        } else {
            return diff;
        }
    }

    @Override
    public String toString() {
        return String.format("$%.2f using %s (%s)", this.dbldollarFare(), this.driver.toString(), 
        this.bestService().toString());
    }

    public String toString(String typeDriver) {
        return String.format("$%.2f using %s %s (%s)", this.dbldollarFare(), 
        this.driver.toString(), typeDriver, this.bestService().toString());
    }

}