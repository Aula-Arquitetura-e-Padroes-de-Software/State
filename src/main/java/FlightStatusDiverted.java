public abstract class FlightStatusDiverted extends FlightStatus{

    @Override
    public String getFlightStatusName() {
        return "DIVERTED";
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    public boolean accident(Flight flight){
        flight.setStatus(FlightStatusIncident.getInstance());
        return true;
    }

    public boolean emergency(Flight flight){
        flight.setStatus(FlightStatusEmergencyDiverted.getInstance());
        return true;
    }

    public abstract boolean resume(Flight flight);

    public  boolean land(Flight flight){
        flight.setStatus(FlightStatusArrived.getInstance());
        return true;
    };


}
