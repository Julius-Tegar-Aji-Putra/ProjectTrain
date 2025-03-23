/**
 * File       : Passenger.java
 * Deskripsi  : berisi atribut dan method dalam class Passenger
 * Pembuat    : Kelompok 6
 *  Ivan Pratomo Soelistio - 24060123120011
 *  Julius Tegar Aji Putra - 24060123130117
 *  Muhammad Danendra Daffa - 24060123140164
 *  Muhammad Imron Rosyadi - 24060123140204
 * Tanggal    : 18 Maret 2025
 */

public class Passenger 
{
    private String passengerId;
    private String name;
    private int age;
    private String gender;
    private String idNumber;
    private String email;
    private String phoneNumber;
    private String address;
    
    public Passenger(String passengerId, String name, int age, String gender, String idNumber,
                    String email, String phoneNumber, String address) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getPassengerId() { 
        return passengerId;
    }

    public void setPassengerId(String passengerId) { 
        this.passengerId = passengerId; 
    }
    
    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getAge() { 
        return age; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }
    
    public String getGender() { 
        return gender; 
    }

    public void setGender(String gender) { 
        this.gender = gender;
    }
    
    public String getIdNumber() { 
        return idNumber;
    }

    public void setIdNumber(String idNumber) { 
        this.idNumber = idNumber; 
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean validateIdNumber() {
        return idNumber != null && idNumber.length() >= 10;
    }
    
    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId='" + passengerId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
