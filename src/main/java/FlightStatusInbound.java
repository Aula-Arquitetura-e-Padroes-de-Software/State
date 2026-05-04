public class FlightStatusInbound extends FlightStatus{

    private static FlightStatusInbound instance = null;

    private FlightStatusInbound(){};

    public static FlightStatusInbound getInstance(){
        if(instance == null){
            instance = new FlightStatusInbound();
        }
        return instance;
    }

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusBoarding.getInstance());
        return true;
    }

    public boolean delay(Flight flight){
        flight.setStatus(FlightStatusDelayedInbound.getInstance());
        return true;
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "INBOUND";
    }
}
