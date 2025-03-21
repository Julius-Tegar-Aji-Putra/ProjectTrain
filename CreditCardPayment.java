public class CreditCardPayment extends Payment 
{
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    
    public CreditCardPayment(String paymentId, double amount, String cardNumber, String cardHolderName, String expiryDate, String cvv) throws Exception 
    {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    
    public String getCardNumber() 
    { 
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) 
    { 
        this.cardNumber = cardNumber; 
    }
    
    public String getCardHolderName() 
    { 
        return cardHolderName; 
    }

    public void setCardHolderName(String cardHolderName) 
    { 
        this.cardHolderName = cardHolderName; 
    }
    
    public String getExpiryDate() 
    { 
        return expiryDate; 
    }

    public void setExpiryDate(String expiryDate) 
    {
        this.expiryDate = expiryDate; 
    }
    
    public String getCvv() 
    { 
        return cvv; 
    }

    public void setCvv(String cvv) 
    { 
        this.cvv = cvv; 
    }
    
    @Override
    public String toString() 
    {
        return super.toString() + " CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}