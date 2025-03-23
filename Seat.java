/**
 * File       : Seat.java
 * Deskripsi  : berisi atribut dan method dalam class Seat
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class Seat 
{
    private String seatId;
    private String seatNumber;
    private boolean isBooked;
    
    public Seat(String seatId, String seatNumber) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public String getSeatId() { 
        return seatId; 
    }

    public void setSeatId(String seatId) { 
        this.seatId = seatId; 
    }
    
    public String getSeatNumber() { 
        return seatNumber; 
    }

    public void setSeatNumber(String seatNumber) { 
        this.seatNumber = seatNumber; 
    }
    
    public boolean isBooked() { 
        return isBooked; 
    }

    public void setBooked(boolean booked) { 
        isBooked = booked; 
    }
    
    public boolean book() throws SeatNotAvailableException {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully");
            return true;
        } else {
            throw new SeatNotAvailableException("Seat " + seatNumber + " is already booked");
        }
    }
    
    public boolean cancel() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Seat " + seatNumber + " booking cancelled");
            return true;
        } else {
            System.out.println("Seat " + seatNumber + " was not booked");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}
