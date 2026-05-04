public class FlightStatusEmergencyDiverted extends FlightStatusEmergency{

    private static FlightStatusEmergencyDiverted instance = null;

    private FlightStatusEmergencyDiverted(){};

    public static FlightStatusEmergencyDiverted getInstance(){
        if(instance == null){
            instance = new FlightStatusEmergencyDiverted();
        }
        return instance;
    }

    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusDivertedEnRoute.getInstance());
        return true;
    }
}
