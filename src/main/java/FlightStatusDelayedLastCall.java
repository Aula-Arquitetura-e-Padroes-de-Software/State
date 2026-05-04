public class FlightStatusDelayedLastCall extends FlightStatusDelayed{

    private static FlightStatusDelayedLastCall instance = null;

    private FlightStatusDelayedLastCall(){};

    public static FlightStatusDelayedLastCall getInstance(){
        if(instance == null){
            instance = new FlightStatusDelayedLastCall();
        }
        return instance;
    }


    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusLastCall.getInstance());
        return true;
    }

    @Override
    public boolean proceed(Flight flight) {
        flight.setStatus(FlightStatusDeparted.getInstance());
        return true;
    }
}
