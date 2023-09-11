
import java.util.List;

class Main {
    public static void main(String args[]){
        /*System.out.println(new NormalCab("SHA1234", 5).servicesList());
        System.out.println(new Booking(new NormalCab("SHA1234", 5), new Request(20, 3, 1000)));
        System.out.println(new NormalCab("SHA2345", 10));
        System.out.println(new Booking(new NormalCab("SHA2345", 10), new Request(10, 1, 900)));
        Booking b3 = new Booking(new NormalCab("SHA1234", 5), new Request(10, 1, 900));
        Booking b4 = new Booking(new NormalCab("SHA2345", 10), new Request(10, 1, 900));
        System.out.println(b3.compareTo(b4) < 0);
        System.out.println(new PrivateCar("SMA7890", 5));
        System.out.println(new Booking(new PrivateCar("SLA5678", 10), new Request(10, 1, 900)));
        Booking b1 = new Booking(new PrivateCar("SMA7890", 5), new Request(10, 1, 900));
        Booking b2 = new Booking(new PrivateCar("SLA5678", 10), new Request(10, 1, 900));
        System.out.println( b1.compareTo(b2) < 0);*/

        findBestBooking(new Request(20, 3, 1000),List.of(new NormalCab("SHA1234", 5), new PrivateCar("SMA7890", 10)));
        findBestBooking(new Request(10, 1, 900),
        List.of(new NormalCab("SHA1234", 5), new PrivateCar("SMA7890", 10)));
    }

    public static void findBestBooking(Request request, List<Driver> drivers) {
        ImList<Booking> listBooking = new ImList<Booking>();
        for (Driver driver : drivers) {
            String type = driver.driverType();
            for (int i = 0; i < driver.servicesList().size(); i++) {
                SnatchService service = driver.servicesList().get(i);
                Driver get = new Driver(driver.plate(), driver.waitTime(), new ImList<SnatchService>().add(service));
                Booking want = new Booking(get, request, type);
                listBooking = listBooking.add(want);
            }
        }
        listBooking = listBooking.sort(new CompareBooking());
        String str = "";
    
        for (Booking line : listBooking) {
            str = str + line.toString(line.driverString()) + '\n';
        }
        System.out.println(str);
    }
}
