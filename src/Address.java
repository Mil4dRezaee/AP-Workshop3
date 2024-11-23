public class Address {

    Address (String zipCode, String country, String city) {
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
    }

//To store the address of contacts

    String zipCode;
    String country;
    String city;

    @Override
    public String toString() {
        return country + " - " + city + " - " + zipCode;
    }

}