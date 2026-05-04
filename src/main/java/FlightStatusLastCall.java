public class FlightStatusLastCall extends FlightStatus{

    private static FlightStatusLastCall instance = null;

    public static FlightStatusLastCall getInstance(){
        if(instance == null){
            instance = new FlightStatusLastCall();
        }
        return instance;
    }

    private FlightStatusLastCall(){};

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusDeparted.getInstance());
        return true;
    }

    public boolean delay(Flight flight){
        flight.setStatus(FlightStatusDelayedLastCall.getInstance());
        return true;
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "LAST CALL";
    }
}
