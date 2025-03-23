/**
 * File       : Main.java
 * Deskripsi  : berisi main driver untuk mendemonstrasikan sistem pemesanan tiket kereta api
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class Main 
{
    public static void main(String[] args) 
    {
        try 
        {
            displayHeader("SISTEM PEMESANAN TIKET KERETA API");
            
            // ===== INISIALISASI DATA =====
            System.out.println("\n[INISIALISASI DATA]");
            
            // 1. Membuat stasiun
            System.out.println("\nMembuat stasiun...");
            Station jakartaStation = new Station("ST001", "Gambir", "Jakarta", "Jl. Medan Merdeka Timur No.1");
            Station yogyaStation = new Station("ST003", "Tugu", "Yogyakarta", "Jl. Mangkubumi No.1");
            System.out.println("Stasiun berhasil dibuat");
            
            // 2. Membuat kereta api
            System.out.println("\nMembuat kereta api...");
            Train argoLawu = new Train("KA001", "Argo Lawu", 120.0);
            argoLawu.configureStandardPassengerTrain();
            System.out.println("Kereta api berhasil dibuat");
            
            // 3. Membuat jadwal kereta
            System.out.println("\nMembuat jadwal perjalanan kereta...");
            // Tanggal dan waktu
            Tanggal tomorrow = new Tanggal(19, "Maret", 2025);
            
            // Jadwal Jakarta - Yogyakarta
            TanggalWaktu jktYogDepartureTime = new TanggalWaktu(tomorrow.getHari(), tomorrow.getBulan(), tomorrow.getTahun(), 8, 0); 
            TanggalWaktu jktYogArrivalTime = new TanggalWaktu(tomorrow.getHari(), tomorrow.getBulan(), tomorrow.getTahun(), 15,30);
            Schedule jktYogSchedule = new Schedule(
                "SCH001", argoLawu, jakartaStation, yogyaStation, 
                jktYogDepartureTime, jktYogArrivalTime, 450.0
            );
            System.out.println("Jadwal perjalanan berhasil dibuat");
            
            // 4. Membuat penumpang
            System.out.println("\nMembuat data penumpang...");
            Passenger passenger1 = new Passenger(
                "P001", "Budi Santoso", 35, "Laki-laki", "3175020504900001",
                "budi.santoso@email.com", "081234567890", "Jl. Kenangan No. 10, Jakarta"
            );
            
            Passenger passenger2 = new Passenger(
                "P002", "Dewi Lestari", 28, "Perempuan", "3275020504950002",
                "dewi.lestari@email.com", "081234567891", "Jl. Merdeka No. 15, Bandung"
            );
            System.out.println("Data penumpang berhasil dibuat");
            
            // ===== DEMONSTRASI SKENARIO PEMESANAN TIKET =====
            displayHeader("DEMONSTRASI SKENARIO PEMESANAN TIKET");
            
            // Penjelasan format penomoran kursi
            System.out.println("\nFormat Penomoran Kursi:");
            System.out.println("- Format: [Kelas][Nomor Gerbong]-[Nomor Kursi]");
            System.out.println("- Contoh: E5-001 adalah kursi nomor 001 di gerbong 5 kelas Ekonomi");
            System.out.println("- Contoh: B2-001 adalah kursi nomor 001 di gerbong 2 kelas Bisnis");
            System.out.println("- Contoh: X1-001 adalah kursi nomor 001 di gerbong 1 kelas Eksekutif");
            
            // Skenario 1: Pemesanan tiket berhasil
            displayScenarioHeader("SKENARIO 1: PEMESANAN TIKET BERHASIL");
            System.out.println("Detail perjalanan:");
            System.out.println("- ID Jadwal       : " + jktYogSchedule.getScheduleId());
            System.out.println("- Kereta          : " + jktYogSchedule.getTrain().getTrainName());
            System.out.println("- Dari            : " + jktYogSchedule.getDepartureStation().getStationName());
            System.out.println("- Tujuan          : " + jktYogSchedule.getArrivalStation().getStationName());
            System.out.println("- Waktu Berangkat : " + jktYogSchedule.getDepartureTime());
            System.out.println("- Waktu Tiba      : " + jktYogSchedule.getArrivalTime());
            System.out.println("- Jarak           : " + jktYogSchedule.getDistance() + " km");
            
            System.out.println("\nPenumpang: " + passenger1.getName());
            
            // Memilih kursi ekonomi dari kereta
            Carriage ekonomiCarriage = argoLawu.findCarriageByNumber(5); // Ekonomi carriage
            if (ekonomiCarriage != null) {
                Seat selectedSeat = ekonomiCarriage.getAvailableSeats().get(0);
                System.out.println("\nPilihan kursi :");
                System.out.println("- Nomor kursi     : " + selectedSeat.getSeatNumber());
                System.out.println("- Kelas           : " + ekonomiCarriage.getCarriageClass());
                System.out.println("- Gerbong         : " + ekonomiCarriage.getCarriageNumber());
                
                // Memesan tiket
                System.out.println("\nProses pemesanan...");
                Ticket ticket1 = new Ticket("T001", passenger1, jktYogSchedule, selectedSeat);
                ticket1.bookSeat();
                
                // Informasi harga
                double ticketPrice = ticket1.calculatePrice();
                System.out.println("Harga tiket: Rp " + String.format("%,.2f", ticketPrice));
                
                // Pemrosesan pembayaran
                System.out.println("\nMemproses pembayaran e-wallet...");
                EWalletPayment payment = new EWalletPayment("PAY001", ticketPrice, "EW001", "OVO");
                payment.setWalletBalance(500000.0);
                boolean paymentSuccess = ticket1.processPayment(payment);
                
                if (paymentSuccess) {
                    System.out.println("Pembayaran berhasil melalui OVO");
                    System.out.println("\nInformasi tiket:");
                    System.out.println("- ID Tiket    : " + ticket1.getTicketId());
                    System.out.println("- Penumpang   : " + ticket1.getPassenger().getName());
                    System.out.println("- Jadwal      : " + ticket1.getSchedule().getScheduleId());
                    System.out.println("- Kereta      : " + ticket1.getSchedule().getTrain().getTrainName());
                    System.out.println("- Kursi       : " + ticket1.getSeat().getSeatNumber());
                    System.out.println("- Tanggal     : " + ticket1.getSchedule().getDepartureTime().getTanggal());
                    System.out.println("- Status      : " + ticket1.getStatus());
                    System.out.println("- Harga       : Rp " + String.format("%,.2f", ticket1.calculatePrice()));
                }
                
                // Skenario 2: Mencoba memesan kursi yang sudah dipesan
                displayScenarioHeader("SKENARIO 2: MEMESAN KURSI YANG SUDAH DIPESAN");
                System.out.println("Mencoba memesan kursi yang sama: " + selectedSeat.getSeatNumber());
                System.out.println("Penumpang: " + passenger2.getName());
                
                try {
                    Ticket duplicateTicket = new Ticket("T002", passenger2, jktYogSchedule, selectedSeat);
                    duplicateTicket.bookSeat();
                } catch (SeatNotAvailableException e) {
                    System.out.println("\nERROR: " + e.getMessage());
                    System.out.println("Status pemesanan tiket: Gagal");
                    System.out.println("Kursi " + selectedSeat.getSeatNumber() + " sudah dipesan oleh penumpang lain.");
                }
                
                // Skenario 3: Pembayaran gagal (saldo tidak cukup)
                displayScenarioHeader("SKENARIO 3: PEMBAYARAN GAGAL - SALDO TIDAK CUKUP");
                
                // Memilih kursi lain
                Carriage eksekutifCarriage = argoLawu.findCarriageByNumber(1); // Eksekutif carriage
                Seat expensiveSeat = eksekutifCarriage.getAvailableSeats().get(0);
                System.out.println("Pilihan kursi :");
                System.out.println("- Nomor kursi   : " + expensiveSeat.getSeatNumber());
                System.out.println("- Kelas         : " + eksekutifCarriage.getCarriageClass());
                System.out.println("- Gerbong       : " + eksekutifCarriage.getCarriageNumber());
                
                System.out.println("\nProses pemesanan...");
                Ticket expensiveTicket = new Ticket("T003", passenger2, jktYogSchedule, expensiveSeat);
                expensiveTicket.bookSeat();
                
                double expensivePrice = expensiveTicket.calculatePrice();
                System.out.println("Harga tiket: Rp " + String.format("%,.2f", expensivePrice));
                
                try {
                    System.out.println("\nMemproses pembayaran e-wallet...");
                    EWalletPayment lowBalancePayment = new EWalletPayment("PAY002", expensivePrice, "EW002", "GoPay");
                    lowBalancePayment.setWalletBalance(10000.0); // Saldo tidak cukup
                    expensiveTicket.processPayment(lowBalancePayment);
                } catch (PaymentFailedException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    System.out.println("Status pemesanan tiket: Gagal karena pembayaran gagal");
                    System.out.println("Status kursi: " + (expensiveSeat.isBooked() ? "Masih terpesan" : "Kembali tersedia"));
                }
                
                // Skenario 4: Pembayaran dengan kartu kredit
                displayScenarioHeader("SKENARIO 4: PEMBAYARAN DENGAN KARTU KREDIT");
                
                // Memilih kursi lain
                Carriage bisnisCarriage = argoLawu.findCarriageByNumber(2); // Bisnis carriage
                Seat businessSeat = bisnisCarriage.getAvailableSeats().get(0);
                System.out.println("Pilihan kursi:");
                System.out.println("- Nomor kursi : " + businessSeat.getSeatNumber());
                System.out.println("- Kelas       : " + bisnisCarriage.getCarriageClass());
                System.out.println("- Gerbong     : " + bisnisCarriage.getCarriageNumber());
                
                System.out.println("\nProses pemesanan...");
                Ticket creditTicket = new Ticket("T004", passenger2, jktYogSchedule, businessSeat);
                creditTicket.bookSeat();
                
                double businessPrice = creditTicket.calculatePrice();
                System.out.println("Harga tiket: Rp " + String.format("%,.2f", businessPrice));
                
                try {
                    System.out.println("\nMemproses pembayaran kartu kredit...");
                    CreditCardPayment creditPayment = new CreditCardPayment(
                        "PAY003", businessPrice, "4111-1111-1111-1111", "Dewi Lestari", "12/26", "123"
                    );
                    boolean creditSuccess = creditTicket.processPayment(creditPayment);
                    
                    if (creditSuccess) {
                        System.out.println("Pembayaran kartu kredit berhasil");
                        System.out.println("\nInformasi tiket:");
                        System.out.println("- ID Tiket    : " + creditTicket.getTicketId());
                        System.out.println("- Penumpang   : " + creditTicket.getPassenger().getName());
                        System.out.println("- Jadwal      : " + creditTicket.getSchedule().getScheduleId());
                        System.out.println("- Kereta      : " + creditTicket.getSchedule().getTrain().getTrainName());
                        System.out.println("- Kursi       : " + creditTicket.getSeat().getSeatNumber());
                        System.out.println("- Tanggal     : " + creditTicket.getSchedule().getDepartureTime().getTanggal());
                        System.out.println("- Status      : " + creditTicket.getStatus());
                        System.out.println("- Harga       : Rp " + String.format("%,.2f", creditTicket.calculatePrice()));
                    }
                } catch (PaymentFailedException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    System.out.println("Status pemesanan tiket: Gagal karena pembayaran gagal");
                }
                
                // Skenario 5: Pembatalan tiket
                displayScenarioHeader("SKENARIO 5: PEMBATALAN TIKET");
                System.out.println("Membatalkan tiket: " + ticket1.getTicketId());
                System.out.println("Penumpang: " + ticket1.getPassenger().getName());
                System.out.println("Kursi: " + ticket1.getSeat().getSeatNumber());
                
                try {
                    ticket1.cancel();
                    System.out.println("\nStatus tiket setelah dibatalkan: " + ticket1.getStatus());
                    System.out.println("Status kursi: " + (selectedSeat.isBooked() ? "Masih terpesan" : "Kembali tersedia"));
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
                
                // Skenario 6: Informasi ketersediaan kursi
                displayScenarioHeader("SKENARIO 6: INFORMASI KETERSEDIAAN KURSI");
                
                System.out.println("Kereta: " + argoLawu.getTrainName());
                System.out.println("Total kursi: " + argoLawu.getTotalSeats());
                System.out.println("Kursi tersedia: " + argoLawu.getTotalAvailableSeats());
                
                System.out.println("\nRincian kursi per kelas:");
                for (Carriage carriage : argoLawu.getCarriages()) {
                    System.out.println("- Gerbong " + carriage.getCarriageNumber() + 
                                      " (Kelas " + carriage.getCarriageClass() + "): " + 
                                      carriage.getTotalAvailableSeats() + " dari " + 
                                      carriage.getCapacity() + " kursi tersedia");
                }
                
                // Tampilkan contoh kursi dari setiap jenis gerbong
                displayScenarioHeader("CONTOH KURSI DARI SETIAP JENIS GERBONG");
                
                // Gerbong Eksekutif
                Carriage exCarriage = argoLawu.findCarriageByNumber(1);
                if (exCarriage != null && !exCarriage.getAvailableSeats().isEmpty()) {
                    Seat exSeat = exCarriage.getAvailableSeats().get(0);
                    System.out.println("Kelas Eksekutif (Gerbong 1):");
                    System.out.println("- Nomor kursi: " + exSeat.getSeatNumber());
                }
                
                // Gerbong Bisnis
                Carriage busCarriage = argoLawu.findCarriageByNumber(2);
                if (busCarriage != null && !busCarriage.getAvailableSeats().isEmpty()) {
                    Seat busSeat = busCarriage.getAvailableSeats().get(0);
                    System.out.println("\nKelas Bisnis (Gerbong 2):");
                    System.out.println("- Nomor kursi: " + busSeat.getSeatNumber());
                }
                
                // Gerbong Ekonomi
                Carriage ecoCarriage = argoLawu.findCarriageByNumber(4);
                if (ecoCarriage != null && !ecoCarriage.getAvailableSeats().isEmpty()) {
                    Seat ecoSeat = ecoCarriage.getAvailableSeats().get(0);
                    System.out.println("\nKelas Ekonomi (Gerbong 4):");
                    System.out.println("- Nomor kursi: " + ecoSeat.getSeatNumber());
                }
                
                // Menunjukkan informasi perjalanan
                displayScenarioHeader("INFORMASI PERJALANAN");
                
                System.out.println("Jadwal Jakarta - Yogyakarta:");
                System.out.println("- ID Jadwal       : " + jktYogSchedule.getScheduleId());
                System.out.println("- Kereta          : " + jktYogSchedule.getTrain().getTrainName());
                System.out.println("- Dari            : " + jktYogSchedule.getDepartureStation().getStationName());
                System.out.println("- Tujuan          : " + jktYogSchedule.getArrivalStation().getStationName());
                System.out.println("- Waktu Berangkat : " + jktYogSchedule.getDepartureTime());
                System.out.println("- Waktu Tiba      : " + jktYogSchedule.getArrivalTime());
                System.out.println("- Jarak           : " + jktYogSchedule.getDistance() + " km");
                System.out.println("- Durasi          : " + String.format("%.1f", jktYogSchedule.calculateTravelDuration()) + " jam");
            } else {
                System.out.println("Tidak dapat menemukan gerbong ekonomi");
            }
            
            // Menampilkan footer
            displayHeader("DEMONSTRASI SISTEM BERHASIL DIJALANKAN");
            
        } catch (Exception e) {
            System.out.println("\nTerjadi kesalahan dalam aplikasi:");
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
    
    private static void displayHeader(String title) {
        System.out.println("\n======================================================================");
        System.out.println("                  " + title);
        System.out.println("======================================================================");
    }
    
    private static void displayScenarioHeader(String title) {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("  " + title);
        System.out.println("------------------------------------------------------------------");
    }
}