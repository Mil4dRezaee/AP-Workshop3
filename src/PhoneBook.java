import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private PhoneBook(){}
    private static final PhoneBook PHONE_BOOK = new PhoneBook();
    public static PhoneBook getInstance() {
        return PHONE_BOOK;
    }

    //Store the whole contacts

    List<Contact> contactsList = new ArrayList<>();
    List<Contact> groupedContactsList = new ArrayList<>();

    boolean addContact(Contact contact) {
/*       adds a contact to the list,
       if the contact exists in the list
       it will return false
       otherwise it adds the contact to the array
       and return true*/

        if (findContact(contact.firstName, contact.lastName) == null)
            return contactsList.add(contact);
        else
            return false;

    }

    String removeContact(Contact contact) {

        if (findContact(contact.firstName, contact.lastName) != null) {
            contactsList.remove(contact);
            return "OK";
        } else {
            return "Not found";
        }

    }

    Contact findContact(String firstName, String lastName) {
/*        if the contact exists, it will return the contact
        otherwise it will return null*/

        for (Contact contact : contactsList) {
            if (contact.firstName.equals(firstName) && contact.lastName.equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    void findGroupedContacts(String otherGroupName) {

        groupedContactsList.clear();
        for (Contact contact : contactsList) {
            String groupName = contact.group;
            if (groupName.equals(otherGroupName)) {
                groupedContactsList.add(contact);
            }
        }

    }

    void printContacts () {

        /*Prints the contacts list in a good format*/

        for (Contact contact : contactsList) {
            System.out.println("Contact{\n\tgroup:\t" + contact.group +
                    "\n\temail:\t" + contact.email +
                    "\n\tfirst name:\t" + contact.firstName +
                    "\n\tlast name:\t" + contact.lastName +
                    "\n\tphone number:\t" + contact.phoneNumber.toString() +
                    "\n\taddress:\t" + contact.address.toString() +
                    "\n}");
        }

    }

    void printGroupedContacts () {

        /*Prints the contacts list in a good format*/

        for (Contact contact : groupedContactsList) {
            System.out.println("Contact{\n\tgroup:\t" + contact.group +
                    "\n\temail:\t" + contact.email +
                    "\n\tfirst name:\t" + contact.firstName +
                    "\n\tlast name:\t" + contact.lastName +
                    "\n\tphone number:\t" + contact.phoneNumber.toString() +
                    "\n\taddress:\t" + contact.address.toString() +
                    "\n}");
        }

    }

}