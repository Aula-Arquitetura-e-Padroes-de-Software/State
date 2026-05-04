public abstract class FlightStatusDelayed extends FlightStatus{


    public abstract boolean resume(Flight flight);
    public abstract boolean proceed(Flight flight);

    @Override
    public boolean cancel(Flight flight) {
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }

    @Override
    public String getFlightStatusName() {
        return "DELAYED";
    }
}
