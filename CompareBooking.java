import java.util.Comparator;

class CompareBooking implements Comparator<Booking> {
    
    @Override
    public int compare(Booking a, Booking b) {
        int diff = a.dollarFare() - b.dollarFare();
        if (diff == 0) {
            int waitdiff = a.driver().waitTime() - b.driver().waitTime();
            return waitdiff;
        } else {
            return diff;
        }
    }
}
