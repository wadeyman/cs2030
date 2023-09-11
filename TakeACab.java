class TakeACab extends SnatchService {
    // private final static int SURCHARGE = 0;
    private static final int RATE = 33;
    private static final int BOOKFEE = 200;

    @Override
    public int computeFare(int distance, int pax, int time) {
        int baseFare = distance * RATE + BOOKFEE;
        return baseFare;
    }

    @Override
    public String toString() {
        return "TakeACab";
    }
}
