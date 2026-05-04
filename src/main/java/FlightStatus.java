public abstract class FlightStatus {

    public abstract String getFlightStatusName();

    public boolean proceed(Flight flight){
        return false;
    }

    public boolean delay(Flight flight){
        return false;
    }

    public boolean divert(Flight flight){
        return false;
    }

    public boolean accident(Flight flight){
        return false;
    }

    public boolean land(Flight flight){
        return false;
    }

    public boolean emergency(Flight flight){
        return false;
    }

    public boolean resume(Flight flight){
        return false;
    }

    public boolean cancel(Flight flight){
        return false;
    }
}
