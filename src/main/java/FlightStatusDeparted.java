public class FlightStatusDeparted extends FlightStatus{

    private static FlightStatusDeparted instance = null;

    private FlightStatusDeparted(){};

    public static FlightStatusDeparted getInstance(){
        if(instance == null){
            instance = new FlightStatusDeparted();
        }
        return instance;
    }

    public boolean proceed(Flight flight){
        flight.setStatus(FlightStatusEnRoute.getInstance());
        return true;
    }

    public boolean divert(Flight flight){
        flight.setStatus(FlightStatusDivertedDeparted.getInstance());
        return true;
    }

    public boolean emergency(Flight flight){
        flight.setStatus(FlightStatusEmergencyDeparted.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "DEPARTED";
    }
}
