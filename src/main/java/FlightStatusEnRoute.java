public class FlightStatusEnRoute extends FlightStatus{

    private static FlightStatusEnRoute instance = null;

    private FlightStatusEnRoute(){};

    public static FlightStatusEnRoute getInstance(){
        if(instance == null){
            instance = new FlightStatusEnRoute();
        }
        return instance;
    }

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusArrived.getInstance());
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
    public String getFlightStatusName(){
        return "EN ROUTE";
    }
}
