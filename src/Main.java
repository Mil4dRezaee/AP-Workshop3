import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String command;
        String [] commandArray;

        String contactFirstName;
        String contactLastName;
        String contactGroup;
        String contactEmail;
        String phoneNumberCountryCode;      //Phone number
        String phoneNumber;                 //Phone number
        String addressZipCode;              //Address
        String addressCountry;              //Address
        String addressCity;                 //Address

        do {

            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            commandArray = command.split(" ");

            if (commandArray[0].equals("exit")) {
                break;
            }
            else if ((commandArray.length == 4) && (commandArray[1].equals("-a") || commandArray[1].equals("-r"))) {

                if (commandArray[0].equals("contacts")) {

                    if (commandArray[1].equals("-a")) {

                        contactFirstName = commandArray[2];
                        contactLastName = commandArray[3];
                        System.out.println("Please enter contact's group:");
                        contactGroup = scanner.nextLine();
                        System.out.println("Please enter contact's email:");
                        contactEmail = scanner.nextLine();
                        System.out.println("Please enter contact's country code:");
                        phoneNumberCountryCode = scanner.nextLine();
                        System.out.println("Please enter contact's phone number:");
                        phoneNumber = scanner.nextLine();
                        System.out.println("Please enter contact's zip code:");
                        addressZipCode = scanner.nextLine();
                        System.out.println("Please enter contact's country:");
                        addressCountry = scanner.nextLine();
                        System.out.println("Please enter contact's city:");
                        addressCity = scanner.nextLine();
                        System.out.println("Contact saved!");

                        PhoneNumber phone = new PhoneNumber(phoneNumberCountryCode, phoneNumber);
                        Address address = new Address(addressZipCode, addressCountry, addressCity);

                        Contact contact = new Contact(contactGroup, contactEmail, contactFirstName, contactLastName, phone, address);

                        PhoneBook.getInstance().addContact(contact);

                    } else if (commandArray[1].equals("-r")) {

                        contactFirstName = commandArray[2];
                        contactLastName = commandArray[3];
                        Contact contact = new Contact(contactFirstName, contactLastName);
                        System.out.println(PhoneBook.getInstance().removeContact(contact));;

                    }

                }

                else {
                    System.out.println("No proper command found!");
                }

            }
            else if ((commandArray.length == 1) || (commandArray.length == 3) || (commandArray.length == 4)) {

                if (commandArray[0].equals("show")) {

                    if (commandArray.length == 1) {

                        PhoneBook.getInstance().printContacts();

                    } else if ((commandArray.length == 3) && (commandArray[1].equals("-g"))) {

                        PhoneBook.getInstance().findGroupedContacts(commandArray[2]);
                        PhoneBook.getInstance().printGroupedContacts();

                    } else if ((commandArray.length == 4) && (commandArray[1].equals("-c"))) {

                        contactFirstName = commandArray[2];
                        contactLastName = commandArray[3];

                        Contact contact = PhoneBook.getInstance().findContact(contactFirstName, contactLastName);
                        if (contact != null)
                            System.out.println("Contact{\n\tgroup:\t" + contact.group +
                                    "\n\temail:\t" + contact.email +
                                    "\n\tfirst name:\t" + contact.firstName +
                                    "\n\tlast name:\t" + contact.lastName +
                                    "\n\tphone number:\t" + contact.phoneNumber.toString() +
                                    "\n\taddress:\t" + contact.address.toString() +
                                    "\n}");
                        else {
                            System.out.println("null");
                        }

                    } else {
                        System.out.println("No proper command found!");
                    }

                }

                else {
                    System.out.println("No proper command found!");
                }

            }

            else {
                System.out.println("No proper command found!");
            }

        } while (true);

    }

}