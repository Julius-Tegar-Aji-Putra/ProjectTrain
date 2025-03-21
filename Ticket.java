public class Ticket 
{
    private String ticketId;
    private Passenger passenger;
    private Schedule schedule;
    private Seat seat;
    private TanggalWaktu bookingDate;
    private String status;
    private Payment payment;
    
    public Ticket(String ticketId, Passenger passenger, Schedule schedule, Seat seat) throws Exception 
    {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.schedule = schedule;
        this.seat = seat;
        this.bookingDate = TanggalWaktu.now();
        this.status = "confirmed";
    }
    
    public String getTicketId() 
    { 
        return ticketId; 
    }
    
    public void setTicketId(String ticketId) 
    { 
        this.ticketId = ticketId; 
    }
    
    public Passenger getPassenger() 
    { 
        return passenger; 
    }
    
    public void setPassenger(Passenger passenger) 
    { 
        this.passenger = passenger; 
    }
    
    public Schedule getSchedule() 
    { 
        return schedule; 
    }
    
    public void setSchedule(Schedule schedule) 
    { 
        this.schedule = schedule; 
    }
    
    public Seat getSeat() 
    { 
        return seat; 
    }
    
    public void setSeat(Seat seat) 
    { 
        this.seat = seat; 
    }
    
    public TanggalWaktu getBookingDate() 
    { 
        return bookingDate; 
    }
    
    public void setBookingDate(TanggalWaktu bookingDate) 
    { 
        this.bookingDate = bookingDate; 
    }
    
    public String getStatus() 
    { 
        return status; 
    }
    
    public void setStatus(String status) 
    { 
        this.status = status; 
    }
    
    public Payment getPayment() 
    { 
        return payment; 
    }
    
    public void setPayment(Payment payment) 
    { 
        this.payment = payment; 
    }
    
    public double calculatePrice() 
    {
        Carriage carriage = schedule.getTrain().findCarriageBySeat(seat);
        if (carriage == null) 
        {
            return 0; 
        }
        
        double pricePerKm = carriage.getPricePerKm();
        double distance = schedule.getDistance();
        
        return distance * pricePerKm;
    }
    
    public boolean bookSeat() throws SeatNotAvailableException 
    {
        try 
        {
            return seat.book();
        } 
        catch (SeatNotAvailableException e) 
        {
            throw new SeatNotAvailableException("Failed to book seat: " + e.getMessage());
        }
    }
    
    public boolean processPayment(Payment payment) throws PaymentFailedException 
    {
        this.payment = payment;
        try 
        {
            boolean success = payment.processPayment();
            if (success) 
            {
                status = "confirmed";
            } 
            else 
            {
                seat.cancel();
                status = "payment_failed";
            }
            return success;
        } 
        catch (PaymentFailedException e) 
        {
            seat.cancel();
            status = "payment_failed";
            throw e;
        }
    }
    
    public boolean cancel() throws TicketCancellationException, Exception 
    {
        if (!status.equals("confirmed")) 
        {
            throw new TicketCancellationException("Cannot cancel ticket with status: " + status);
        }
        
        if (TanggalWaktu.now().isAfter(schedule.getDepartureTime())) 
        {
            throw new TicketCancellationException("Cannot cancel ticket after departure time");
        }
        
        seat.cancel();
        
        status = "cancelled";
        System.out.println("Ticket " + ticketId + " cancelled successfully");
        return true;
    }
    
    @Override
    public String toString() 
    {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", passenger=" + passenger.getName() +
                ", schedule=" + schedule.getScheduleId() +
                ", seat=" + seat.getSeatNumber() +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                ", price=" + calculatePrice() +
                '}';
    }
}