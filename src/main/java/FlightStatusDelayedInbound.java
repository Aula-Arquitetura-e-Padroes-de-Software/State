public class FlightStatusDelayedInbound extends FlightStatusDelayed{

    private static FlightStatusDelayedInbound instance = null;

    private FlightStatusDelayedInbound(){};

    public static FlightStatusDelayedInbound getInstance(){
        if(instance == null){
            instance = new FlightStatusDelayedInbound();
        }
        return instance;
    }


    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusInbound.getInstance());
        return true;
    }

    @Override
    public boolean proceed(Flight flight) {
        flight.setStatus(FlightStatusBoarding.getInstance());
        return true;
    }
}