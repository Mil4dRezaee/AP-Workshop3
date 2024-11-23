public class PhoneNumber {

    PhoneNumber (String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    //To store the phone number

    String countryCode;

    String number;
    //Not more than 12 length!


    @Override
    public String toString() {
        return countryCode+number;
    }

}