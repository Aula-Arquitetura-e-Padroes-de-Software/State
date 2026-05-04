public class FlightStatusDelayedBoarding extends FlightStatusDelayed{

    private static FlightStatusDelayedBoarding instance = null;

    private FlightStatusDelayedBoarding(){};

    public static FlightStatusDelayedBoarding getInstance(){
        if(instance == null){
            instance = new FlightStatusDelayedBoarding();
        }
        return instance;
    }


    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusBoarding.getInstance());
        return true;
    }

    @Override
    public boolean proceed(Flight flight) {
        flight.setStatus(FlightStatusLastCall.getInstance());
        return true;
    }
}
