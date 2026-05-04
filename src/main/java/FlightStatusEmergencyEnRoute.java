public class FlightStatusEmergencyEnRoute extends FlightStatusEmergency{
    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusEnRoute.getInstance());
        return true;
    }

    public boolean divert(Flight flight){
        flight.setStatus(FlightStatusEmergencyDiverted.getInstance());
        return true;
    }
}
