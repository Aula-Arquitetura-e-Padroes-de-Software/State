public class FlightStatusEnRoute extends FlightStatus{

    private static FlightStatusEnRoute instance = null;

    private FlightStatusEnRoute(){};

    public static FlightStatusEnRoute getInstance(){
        if(instance == null){
            instance = new FlightStatusEnRoute();
        }
        return instance;
    }

    public boolean land(Flight flight){
        flight.setStatus(FlightStatusArrived.getInstance());
        return true;
    }

    public boolean divert(Flight flight){
        flight.setStatus(FlightStatusDivertedEnRoute.getInstance());
        return true;
    }

    public boolean emergency(Flight flight){
        flight.setStatus(FlightStatusEmergencyEnRoute.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName(){
        return "EN ROUTE";
    }
}
