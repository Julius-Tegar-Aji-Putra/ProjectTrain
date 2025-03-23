/**
 * File       : EWalletPayment.java
 * Deskripsi  : berisi atribut dan method dalam class EWalletPayment
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class EWalletPayment extends Payment 
{
    private String walletId;
    private String walletProvider;
    private double walletBalance;
    
    public EWalletPayment(String paymentId, double amount, String walletId, String walletProvider) throws Exception {
        super(paymentId, amount);
        this.walletId = walletId;
        this.walletProvider = walletProvider;
    }
    
    public String getWalletId() { 
        return walletId; 
    }
    
    public void setWalletId(String walletId) { 
        this.walletId = walletId; 
    }
    
    public double getWalletBalance() { 
        return walletBalance; 
    }
    
    public String getWalletProvider() { 
        return walletProvider; 
    }
    
    public void setWalletProvider(String walletProvider) { 
        this.walletProvider = walletProvider; 
    }

    public void setWalletBalance(double walletBalance) { 
        this.walletBalance = walletBalance; 
    }

    public boolean verifyWalletBalance() throws InsufficientBalanceException {
        boolean hasSufficientFunds;
        if (walletBalance >= getAmount()) {
            hasSufficientFunds = true;
        }
        else {
            hasSufficientFunds = false;
        }
        
        if (hasSufficientFunds) {
            System.out.println("Sufficient funds in wallet");
            return true;
        } 
        else {
            throw new InsufficientBalanceException("Insufficient funds in wallet");
        }
    }
    
    @Override
    public boolean processPayment() throws PaymentFailedException {
        try {
            verifyWalletBalance();
            setWalletBalance(getWalletBalance() - getAmount());
            System.out.println("Processing e-wallet payment using " + walletProvider);
            return super.processPayment();
        } 
        catch (InsufficientBalanceException e) {
            throw new PaymentFailedException(e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " EWalletPayment{" +
                "walletId='" + walletId + '\'' +
                ", walletProvider='" + walletProvider + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}
