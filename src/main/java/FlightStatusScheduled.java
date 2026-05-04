public class FlightStatusScheduled extends FlightStatus{

    private static FlightStatusScheduled instance = null;

    private FlightStatusScheduled(){};

    public static FlightStatusScheduled getInstance(){
        if(instance == null){
            instance = new FlightStatusScheduled();
        }
        return instance;
    }

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusInbound.getInstance());
        return true;
    }

    public boolean delay(Flight flight){
        return true;
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "SCHEDULED";
    }
}
