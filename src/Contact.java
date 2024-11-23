import java.util.Objects;

public class Contact {

    public Contact(String group, String email, String firstName, String lastName, PhoneNumber phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.email = email;
        this.phoneNumber = phoneNumber;     //contains country code and phone number.
        this.address = address;             //contains zip code, country and city.
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact() {}

    String group;

    String email;

    String firstName;

    String lastName;

    PhoneNumber phoneNumber;

    Address address;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact otherContact = (Contact) obj;
        return Objects.equals(firstName, otherContact.firstName) &&
                Objects.equals(lastName, otherContact.lastName);
    }

}