public class Tanggal 
{
    private int hari;
    private String bulan;
    private int tahun;

    public Tanggal(int hari, String bulan, int tahun) throws TanggalInvalidException 
    {
        if (hari < 1 || hari > getJumlahHari(bulan, tahun)) 
        {
            throw new TanggalInvalidException("Hari tidak valid untuk bulan " + bulan + " tahun " + tahun);
        }
        if (intBulan(bulan) == 0) 
        {
            throw new TanggalInvalidException("Bulan tidak valid: " + bulan);
        }
        if (tahun < 0) 
        {
            throw new TanggalInvalidException("Tahun tidak valid: " + tahun);
        }
        
        this.hari = hari;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public int getHari()
    {
        return this.hari;
    }

    public String getBulan()
    {
        return this.bulan;
    }

    public int getTahun()
    {
        return this.tahun;
    }
    
    public static int intBulan(String bulan)
    {
        switch(bulan)
        {
            case "Januari": return 1;
            case "Februari": return 2;
            case "Maret": return 3;
            case "April": return 4;
            case "Mei": return 5;
            case "Juni": return 6;
            case "Juli": return 7;
            case "Agustus": return 8;
            case "September": return 9;
            case "Oktober": return 10;
            case "November": return 11;
            case "Desember": return 12;
            default: return 0;
        }
    }

    public static int getJumlahHari(String bulan, int tahun) 
    {
        int bulanint = intBulan(bulan);
        switch(bulanint) 
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (tahun % 4 == 0 && tahun % 100 != 0 || tahun % 400 == 0) 
                {
                    return 29;
                } 
                else 
                {
                    return 28;
                }
            default:
                return 0;
        }
    }

    public boolean isBefore(Tanggal other) 
    {
        if (this.tahun < other.tahun) 
        {
            return true;
        }
        if (this.tahun > other.tahun) 
        {
            return false;
        }
        
        int thisBulan = intBulan(this.bulan);
        int otherBulan = intBulan(other.bulan);
        
        if (thisBulan < otherBulan) 
        {
            return true;
        }
        if (thisBulan > otherBulan) 
        {
            return false;
        }
        
        return this.hari < other.hari;
    }
    
    public boolean isAfter(Tanggal other) 
    {
        if (this.tahun > other.tahun) 
        {
            return true;
        }
        if (this.tahun < other.tahun) 
        {
            return false;
        }
        int thisBulan = intBulan(this.bulan);
        int otherBulan = intBulan(other.bulan);
        
        if (thisBulan > otherBulan) 
        {
            return true;
        }
        if (thisBulan < otherBulan) 
        {
            return false;
        }
        
        return this.hari > other.hari;
    }

    public static Tanggal now() throws TanggalInvalidException 
    {
        // Asumsi tanggal saat ini adalah 18 Maret 2025
        return new Tanggal(18, "Maret", 2025);
    }

    @Override
    public String toString()
    {
        return this.hari + " " + this.bulan + " " + this.tahun;
    }
}