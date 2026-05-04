public abstract class FlightStatusEmergency extends FlightStatus{

    public boolean accident(Flight flight){
        flight.setStatus(FlightStatusIncident.getInstance());
        return true;
    };

    public abstract boolean resume(Flight flight);

    public boolean land(Flight flight){
        flight.setStatus(FlightStatusArrived.getInstance());
        return true;
    };

    @Override
    public String getFlightStatusName() {
        return "SEE COUNTER";
    }
}
