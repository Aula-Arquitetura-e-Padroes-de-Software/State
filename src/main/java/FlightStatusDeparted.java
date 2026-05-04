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

    public boolean delay(Flight flight){
        return true;
    }

    public boolean cancel(Flight flight){
        flight.setStatus(FlightStatusCancelled.getInstance());
        return true;
    }


    @Override
    public String getFlightStatusName() {
        return "DEPARTED";
    }
}
