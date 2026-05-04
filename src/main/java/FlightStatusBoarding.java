public class FlightStatusBoarding extends FlightStatus{

    private static FlightStatusBoarding instance = null;

    private FlightStatusBoarding(){};

    public static FlightStatusBoarding getInstance(){
        if(instance == null){
            instance = new FlightStatusBoarding();
        }
        return instance;
    }

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusLastCall.getInstance());
        return true;
    }

    public boolean delay(Flight flight){
        flight.setStatus(FlightStatusDelayedBoarding.getInstance());
        return true;
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "BOARDING";
    }
}
