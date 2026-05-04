public class FlightStatusEmergencyEnRoute extends FlightStatusEmergency{

    private static FlightStatusEmergencyEnRoute instance = null;

    private FlightStatusEmergencyEnRoute(){};

    public static FlightStatusEmergencyEnRoute getInstance(){
        if(instance == null){
            instance = new FlightStatusEmergencyEnRoute();
        }
        return instance;
    }

    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusEnRoute.getInstance());
        return true;
    }

    public boolean divert(Flight flight){
        flight.setStatus(FlightStatusDivertedEnRoute.getInstance());
        return true;
    }
}
