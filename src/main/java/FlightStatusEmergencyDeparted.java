public class FlightStatusEmergencyDeparted extends FlightStatusEmergency{

    private static FlightStatusEmergencyDeparted instance = null;

    private FlightStatusEmergencyDeparted(){};

    public static FlightStatusEmergencyDeparted getInstance(){
        if(instance == null){
            instance = new FlightStatusEmergencyDeparted();
        }
        return instance;
    }

    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusDeparted.getInstance());
        return true;
    }

    public boolean divert(Flight flight){
        flight.setStatus(FlightStatusDivertedDeparted.getInstance());
        return true;
    }

    @Override
    public boolean land(Flight flight){
        return false;
    }
}
