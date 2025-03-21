public class Waktu 
{
    private int jam;
    private int menit;
    
    public Waktu(int jam, int menit) throws TanggalWaktuInvalidException 
    {
        if (jam < 0 || jam > 23) 
        {
            throw new TanggalWaktuInvalidException("Jam tidak valid: " + jam);
        }
        if (menit < 0 || menit > 59) 
        {
            throw new TanggalWaktuInvalidException("Menit tidak valid: " + menit);
        }
        
        this.jam = jam;
        this.menit = menit;
    }
    
    public int getJam() 
    {
        return jam;
    }
    
    public int getMenit() 
    {
        return menit;
    }
    
    public boolean isBefore(Waktu other) 
    {
        if (this.jam < other.jam) 
        {
            return true;
        }
        if (this.jam > other.jam) 
        {
            return false;
        }
        return this.menit < other.menit;
    }
    
    public boolean isAfter(Waktu other) 
    {
        if (this.jam > other.jam) 
        {
            return true;
        }
        if (this.jam < other.jam)
        {
            return false;
        }
        return this.menit > other.menit;
    }
    
    @Override
    public String toString() 
    {
        return String.format("%02d:%02d", jam, menit);
    }
}