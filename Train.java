public class Train 
{
    private String trainId;
    private String trainName;
    private double maxSpeed; // dalam km/jam
    private java.util.List<Carriage> carriages;
    
    public Train(String trainId, String trainName, double maxSpeed) 
    {
        this.trainId = trainId;
        this.trainName = trainName;
        this.maxSpeed = maxSpeed;
        this.carriages = new java.util.ArrayList<>();
    }
    
    public void configureStandardPassengerTrain() 
    {
        String baseId = trainId + "-";
        
        addCarriage(Carriage.createEksekutifCarriage(baseId + "X", 1));
        
        addCarriage(Carriage.createBisnisCarriage(baseId + "B1", 2));
        addCarriage(Carriage.createBisnisCarriage(baseId + "B2", 3));
        
        addCarriage(Carriage.createEkonomiCarriage(baseId + "E1", 4));
        addCarriage(Carriage.createEkonomiCarriage(baseId + "E2", 5));
        addCarriage(Carriage.createEkonomiCarriage(baseId + "E3", 6));
    }
    
    public void configureEkspresTrain() 
    {
        String baseId = trainId + "-";
        
        addCarriage(Carriage.createEksekutifCarriage(baseId + "X", 1));
        
        addCarriage(Carriage.createBisnisCarriage(baseId + "B1", 2));
        addCarriage(Carriage.createBisnisCarriage(baseId + "B2", 3));
        addCarriage(Carriage.createBisnisCarriage(baseId + "B3", 4));
        
        addCarriage(Carriage.createEkonomiCarriage(baseId + "E1", 5));
        addCarriage(Carriage.createEkonomiCarriage(baseId + "E2", 6));
    }
    

    public void addCarriage(Carriage carriage) 
    {
        carriages.add(carriage);
        System.out.println("Gerbong " + carriage.getCarriageNumber() + " (" + carriage.getCarriageClass() + ") ditambahkan ke kereta " + trainName);
    }
    
    public boolean removeCarriage(String carriageId) 
    {
        for (int i = 0; i < carriages.size(); i++) 
        {
            if (carriages.get(i).getCarriageId().equals(carriageId)) 
            {
                carriages.remove(i);
                System.out.println("Gerbong dengan ID " + carriageId + " dihapus dari kereta " + trainName);
                return true;
            }
        }
        System.out.println("Gerbong dengan ID " + carriageId + " tidak ditemukan di kereta " + trainName);
        return false;
    }
    
    public String getTrainId() 
    { 
        return trainId; 
    }
    
    public void setTrainId(String trainId) 
    { 
        this.trainId = trainId; 
    }
    
    public String getTrainName() 
    { 
        return trainName; 
    }
    
    public void setTrainName(String trainName) 
    { 
        this.trainName = trainName; 
    }
    
    public double getMaxSpeed() 
    { 
        return maxSpeed; 
    }
    
    public void setMaxSpeed(double maxSpeed) 
    { 
        this.maxSpeed = maxSpeed; 
    }
    
    public java.util.List<Carriage> getCarriages() 
    { 
        return carriages; 
    }
    
    public int getTotalSeats() 
    {
        int total = 0;
        for (Carriage carriage : carriages) 
        {
            total += carriage.getCapacity();
        }
        return total;
    }
    
    public int getTotalAvailableSeats() 
    {
        int total = 0;
        for (Carriage carriage : carriages) 
        {
            total += carriage.getTotalAvailableSeats();
        }
        return total;
    }
    
    public java.util.List<Seat> getAllAvailableSeats() 
    {
        java.util.List<Seat> allAvailableSeats = new java.util.ArrayList<>();
        for (Carriage carriage : carriages) 
        {
            allAvailableSeats.addAll(carriage.getAvailableSeats());
        }
        return allAvailableSeats;
    }
    
    public Carriage findCarriageByNumber(int carriageNumber) 
    {
        for (Carriage carriage : carriages) 
        {
            if (carriage.getCarriageNumber() == carriageNumber) 
            {
                return carriage;
            }
        }
        return null;
    }
    
    public Seat findSeatBySeatNumber(String seatNumber) 
    {
        for (Carriage carriage : carriages) 
        {
            for (Seat seat : carriage.getSeats()) 
            {
                if (seat.getSeatNumber().equals(seatNumber)) 
                {
                    return seat;
                }
            }
        }
        return null;
    }
    
    public Carriage findCarriageBySeat(Seat seat) 
    {
        for (Carriage carriage : carriages) 
        {
            for (Seat s : carriage.getSeats()) 
            {
                if (s.getSeatId().equals(seat.getSeatId())) 
                {
                    return carriage;
                }
            }
        }
        return null;
    }
    
    @Override
    public String toString() 
    {
        return "Kereta{" +
                "id='" + trainId + '\'' +
                ", nama='" + trainName + '\'' +
                ", kecepatan maksimum=" + maxSpeed + " km/jam" +
                ", jumlah gerbong=" + carriages.size() +
                ", total kursi=" + getTotalSeats() +
                ", kursi tersedia=" + getTotalAvailableSeats() +
                '}';
    }
}