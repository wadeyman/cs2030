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