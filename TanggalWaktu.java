public class TanggalWaktu 
{
    private Tanggal tanggal;
    private Waktu waktu;
    
    public TanggalWaktu(int hari, String bulan, int tahun, int jam, int menit) throws TanggalWaktuInvalidException
    {
        this.tanggal = new Tanggal(hari, bulan, tahun);
        this.waktu = new Waktu(jam, menit);
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
        return new TanggalWaktu(Tanggal.now().getHari(),Tanggal.now().getBulan(),Tanggal.now().getTahun(), 0, 0); 
    }
    
    @Override
    public String toString() 
    {
        return tanggal.toString() + " " + waktu.toString();
    }
}