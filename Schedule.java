public class Schedule 
{
    private String scheduleId;
    private Train train;
    private Station departureStation;
    private Station arrivalStation;
    private TanggalWaktu departureTime;
    private TanggalWaktu arrivalTime;
    private double distance; // km
    
    public Schedule(String scheduleId, Train train, Station departureStation, Station arrivalStation, 
                   TanggalWaktu departureTime, TanggalWaktu arrivalTime, double distance) 
    {
        this.scheduleId = scheduleId;
        this.train = train;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.distance = distance;
    }
    
    public String getScheduleId() 
    { 
        return scheduleId; 
    }
    
    public void setScheduleId(String scheduleId) 
    { 
        this.scheduleId = scheduleId; 
    }
    
    public Train getTrain() 
    { 
        return train; 
    }
    
    public void setTrain(Train train) 
    { 
        this.train = train; 
    }
    
    public Station getDepartureStation() 
    { 
        return departureStation; 
    }
    
    public void setDepartureStation(Station departureStation) 
    { 
        this.departureStation = departureStation; 
    }
    
    public Station getArrivalStation() 
    { 
        return arrivalStation; 
    }
    
    public void setArrivalStation(Station arrivalStation) 
    { 
        this.arrivalStation = arrivalStation; 
    }
    
    public TanggalWaktu getDepartureTime() 
    { 
        return departureTime; 
    }
    
    public void setDepartureTime(TanggalWaktu departureTime) 
    { 
        this.departureTime = departureTime; 
    }
    
    public TanggalWaktu getArrivalTime() 
    { 
        return arrivalTime; 
    }
    
    public void setArrivalTime(TanggalWaktu arrivalTime) 
    { 
        this.arrivalTime = arrivalTime; 
    }
    
    public double getDistance() 
    { 
        return distance; 
    }
    
    public void setDistance(double distance) 
    { 
        this.distance = distance; 
    }
    
    public boolean isAvailable() throws Exception 
    {
        return TanggalWaktu.now().isBefore(departureTime);
    }
    
    public java.util.List<Seat> getAvailableSeats() 
    {
        return train.getAllAvailableSeats();
    }
    
    public double calculateTravelDuration() 
    {
        double avgSpeed = train.getMaxSpeed() * 0.7; //Rata rata kecepatan 70% max speed
        double hours = distance / avgSpeed;
        return hours;
    }
    
    @Override
    public String toString() 
    {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", train=" + train.getTrainName() +
                ", departure=" + departureStation.getStationName() +
                ", arrival=" + arrivalStation.getStationName() +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", distance=" + distance + " km" +
                '}';
    }
}