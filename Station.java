public class Station 
{
    private String stationId;
    private String stationName;
    private String city;
    private String address;
    
    public Station(String stationId, String stationName, String city, String address) 
    {
        this.stationId = stationId;
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }
    
    public String getStationId() 
    { 
        return stationId; 
    }

    public void setStationId(String stationId) 
    { 
        this.stationId = stationId; 
    }
    
    public String getStationName() 
    { 
        return stationName; 
    }

    public void setStationName(String stationName) 
    { 
        this.stationName = stationName;
    }
    
    public String getCity() 
    { 
        return city; 
    }

    public void setCity(String city) 
    { 
        this.city = city; 
    }
    
    public String getAddress() 
    { 
        return address; 
    }

    public void setAddress(String address) 
    { 
        this.address = address; 
    }
    
    @Override
    public String toString() 
    {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}