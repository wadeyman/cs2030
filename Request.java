class Request {
    private final int distance;
    private final int pax;
    private final int time;

    Request(int distance, int pax, int time) {
        this.distance = distance;
        this.pax = pax;
        this.time = time;
    }

    public int distance() {
        return this.distance;
    }

    public int pax() {
        return this.pax;
    }

    public int time() {
        return this.time;
    }
    
    // this computeFare belongs to request taking in services' computeFare
    public int computeFare(SnatchService service) {
        return service.computeFare(this.distance(), this.pax(), this.time());
    }

    @Override
    public String toString() {
        return String.format("%skm for %spax @ %shrs", this.distance, 
            this.pax, this.time);
    }
}

