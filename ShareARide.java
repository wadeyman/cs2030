class ShareARide extends SnatchService {
    private static final int RATE = 50;
    private static final int SURCHARGE = 500;
    private static final int LOWPEAK = 600;
    private static final int HIPEAK = 900;

    @Override
    public int computeFare(int distance, int pax, int time) {
        int baseFare = distance * RATE;
        if (LOWPEAK <= time && time <= HIPEAK) {
            baseFare = baseFare + SURCHARGE;
        }
        return baseFare / pax;
    }

    @Override
    public String toString() {
        return "ShareARide";
    }
}