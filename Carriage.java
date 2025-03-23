/**
 * File       : Carriage.java
 * Deskripsi  : berisi atribut dan method dalam class Carriage
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class Carriage 
{
    public static final double EKONOMI_PRICE_PER_KM = 400.0;
    public static final double BISNIS_PRICE_PER_KM = 500.0;
    public static final double EKSEKUTIF_PRICE_PER_KM = 600.0;
    
    public static final int EKONOMI_CAPACITY = 72;
    public static final int BISNIS_CAPACITY = 48;
    public static final int EKSEKUTIF_CAPACITY = 24;

    private String carriageId;
    private int carriageNumber;
    private String carriageClass; // Ekonomi, Bisnis, Eksekutif
    private int capacity;
    private java.util.List<Seat> seats;

    private Carriage(String carriageId, int carriageNumber, String carriageClass, int capacity) {
        this.carriageId = carriageId;
        this.carriageNumber = carriageNumber;
        this.carriageClass = carriageClass;
        this.capacity = capacity;
        this.seats = new java.util.ArrayList<>();
        
        createSeats();
    }

    public static Carriage createEkonomiCarriage(String carriageId, int carriageNumber) {
        return new Carriage(carriageId, carriageNumber, "Ekonomi", EKONOMI_CAPACITY);
    }

    public static Carriage createBisnisCarriage(String carriageId, int carriageNumber) {
        return new Carriage(carriageId, carriageNumber, "Bisnis", BISNIS_CAPACITY);
    }

    public static Carriage createEksekutifCarriage(String carriageId, int carriageNumber) {
        return new Carriage(carriageId, carriageNumber, "Eksekutif", EKSEKUTIF_CAPACITY);
    }

    private void createSeats() {
        for (int i = 1; i <= capacity; i++) {
            String seatId = carriageId + "-" + i;
            
            String classPrefix;
            if (carriageClass.equals("Ekonomi")) {
                classPrefix = "E";
            } else if (carriageClass.equals("Bisnis")) {
                classPrefix = "B";
            } else if (carriageClass.equals("Eksekutif")) {
                classPrefix = "X";
            } else {
                classPrefix = "?"; 
            }
            
            String seatNumber = classPrefix + carriageNumber + "-" + String.format("%03d", i);
            
            Seat seat = new Seat(seatId, seatNumber);
            seats.add(seat);
        }
    }

    public String getCarriageId() { 
        return carriageId; 
    }

    public int getCarriageNumber() { 
        return carriageNumber; 
    }

    public String getCarriageClass() { 
        return carriageClass; 
    }

    public int getCapacity() { 
        return capacity;
    }

    public java.util.List<Seat> getSeats() { 
        return seats; 
    }
    
    public double getPricePerKm() {
        switch (carriageClass) {
            case "Ekonomi":
                return EKONOMI_PRICE_PER_KM;
            case "Bisnis":
                return BISNIS_PRICE_PER_KM;
            case "Eksekutif":
                return EKSEKUTIF_PRICE_PER_KM;
            default:
                return EKONOMI_PRICE_PER_KM; // Deafult : Ekonomi
        }
    }

    public int getTotalAvailableSeats() {
        int availableSeats = 0;
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats++;
            }
        }
        return availableSeats;
    }

    public java.util.List<Seat> getAvailableSeats() {
        java.util.List<Seat> availableSeats = new java.util.ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "id='" + carriageId + '\'' +
                ", nomor=" + carriageNumber +
                ", kelas='" + carriageClass + '\'' +
                ", kapasitas=" + capacity +
                ", kursi tersedia=" + getTotalAvailableSeats() +
                '}';
    }
}
