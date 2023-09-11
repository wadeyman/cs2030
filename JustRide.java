class JustRide extends SnatchService {

    private static final int SURCHARGE = 500;
    private static final int RATE = 22;
    private static final int LOWPEAK = 600;
    private static final int HIPEAK = 900;
    // 500c issued between peak hour of 600 to 900 hours

    JustRide() {
    }

    @Override
    public int computeFare(int distance, int pax, int time) {
        int baseFare = distance * RATE;
        if (LOWPEAK <= time && time <= HIPEAK) {
            int upd8Fare = baseFare + SURCHARGE;
            return upd8Fare;
        } else {
            return baseFare;
        }
    }

    @Override
    public String toString() {
        return "JustRide";
    }
}

