public class TanggalWaktu 
{
    private Tanggal tanggal;
    private Waktu waktu;
    
    public TanggalWaktu(Tanggal tanggal, Waktu waktu) 
    {
        this.tanggal = tanggal;
        this.waktu = waktu;
    }
    
    public Tanggal getTanggal() 
    {
        return tanggal;
    }
    
    public Waktu getWaktu() 
    {
        return waktu;
    }
    
    public boolean isBefore(TanggalWaktu other) 
    {
        if (tanggal.isBefore(other.tanggal)) return true;
        if (tanggal.isAfter(other.tanggal)) return false;
        return waktu.isBefore(other.waktu);
    }
    
    public boolean isAfter(TanggalWaktu other) 
    {
        if (tanggal.isAfter(other.tanggal)) return true;
        if (tanggal.isBefore(other.tanggal)) return false;
        return waktu.isAfter(other.waktu);
    }
    
    public static TanggalWaktu now() throws Exception 
    {
        return new TanggalWaktu(Tanggal.now(), new Waktu(10, 30)); // Using a fixed time for demo
    }
    
    @Override
    public String toString() 
    {
        return tanggal.toString() + " " + waktu.toString();
    }
}