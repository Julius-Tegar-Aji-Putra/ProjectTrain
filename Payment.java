public class Payment 
{
    private String paymentId;
    private double amount;
    private TanggalWaktu paymentDate;
    private String status; // pending, completed, failed
    
    public Payment(String paymentId, double amount) throws Exception 
    {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = TanggalWaktu.now();
        this.status = "pending";
    }
    
    public String getPaymentId() 
    { 
        return paymentId; 
    }

    public void setPaymentId(String paymentId) 
    { 
        this.paymentId = paymentId; 
    }
    
    public double getAmount() 
    { 
        return amount; 
    }

    public void setAmount(double amount) 
    { 
        this.amount = amount; 
    }
    
    public TanggalWaktu getPaymentDate() 
    { 
        return paymentDate; 
    }

    public void setPaymentDate(TanggalWaktu paymentDate) 
    { 
        this.paymentDate = paymentDate;
    }
    
    public String getStatus() 
    { 
        return status; 
    }

    public void setStatus(String status) 
    { 
        this.status = status; 
    }
    
    public boolean processPayment() throws PaymentFailedException 
    {
        try 
        {
            System.out.println("Processing payment of " + amount);
            boolean success = Math.random() > 0.2; // simulasi untuk PaymentFailedException
            
            if (success) 
            {
                status = "completed";
                System.out.println("Payment successful");
                return true;
            } 
            else 
            {
                status = "failed";
                throw new PaymentFailedException("Payment processing failed");
            }
        } 
        catch (Exception e) 
        {
            status = "failed";
            throw new PaymentFailedException("Payment processing failed: " + e.getMessage());
        }
    }
    
    public void getReceipt() 
    {
        System.out.println("Generating receipt for payment " + paymentId);
    }
    
    @Override
    public String toString() 
    {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", status='" + status + '\'' +
                '}';
    }
}