/**
 * File       : CreditCardPayment.java
 * Deskripsi  : berisi atribut dan method dalam class CreditCardPayment
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class CreditCardPayment extends Payment 
{
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    
    public CreditCardPayment(String paymentId, double amount, String cardNumber, String cardHolderName, String expiryDate, String cvv) throws Exception {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    
    public String getCardNumber() { 
        return this.cardNumber; 
    }

    public void setCardNumber(String cardNumber) { 
        this.cardNumber = cardNumber; 
    }
    
    public String getCardHolderName() { 
        return cardHolderName; 
    }

    public void setCardHolderName(String cardHolderName) { 
        this.cardHolderName = cardHolderName; 
    }
    
    public String getExpiryDate() { 
        return expiryDate; 
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate; 
    }
    
    public String getCvv() { 
        return cvv; 
    }

    public void setCvv(String cvv) { 
        this.cvv = cvv; 
    }
    
    @Override
    public String toString() {
        return super.toString() + " CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
