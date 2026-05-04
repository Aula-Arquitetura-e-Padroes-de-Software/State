
public class Flight {
    private FlightStatus flightStatus;
    private String flightNumber;
    private String destination;

    public Flight(String flightNumber, String destination){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.flightStatus = FlightStatusScheduled.getInstance();
    }

    public boolean proceed(){
        return flightStatus.proceed(this);
    }

    public boolean delay(){
        return flightStatus.delay(this);
    }

    public boolean cancel(){
        return flightStatus.cancel(this);
    }

    public boolean divert(){
        return flightStatus.divert(this);
    }

    public boolean accident(){
        return flightStatus.accident(this);
    }

    public boolean land(){
        return flightStatus.land(this);
    }

    public boolean emergency(){
        return flightStatus.emergency(this);
    }

    public boolean resume(){
        return flightStatus.resume(this);
    }

    public void setStatus(FlightStatus flightStatus){
        this.flightStatus = flightStatus;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFlightStatusName(){
        return flightStatus.getFlightStatusName();
    }

}
