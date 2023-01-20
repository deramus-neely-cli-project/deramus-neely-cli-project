import java.util.*;

public class App {

  // method to print messages without having to type System.out.println() every
  // time
  public static void print(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) {
    final String FILE_NAME = "data/Contacts.txt";
    ContactsManager myContactsManager = new ContactsManager(FILE_NAME);

    // this code is used to get user input
    try (Scanner scanner = new Scanner(System.in)) {
      int choice; // user's input choice
      while (true) {
        print(
            "\n" + Constants.WELCOME_MESSAGE + "\n\n" + Constants.ADD_CONTACT + "\n" + Constants.VIEW_ALL_CONTACTS
                + "\n" + Constants.SEARCH_CONTACT + "\n" + Constants.DELETE_CONTACT + "\n" + Constants.EXIT + "\n\n"
                + Constants.ENTER_CHOICE);
        // this code is used to validate user input
        while (true) {
          try {
            choice = scanner.nextInt();
            scanner.nextLine();
            break;
          } catch (InputMismatchException e) {
            print(Constants.INVALID_CHOICE);
            scanner.nextLine();
          }
        }
        switch (choice) {
          // if user chooses 1, the user can add a contact
          case 1 -> {
            print("\n" + Constants.ADD_CONTACT_CHOICE);
            print(Constants.NAME_SEARCH);
            String name = scanner.nextLine();
            print("\n" + Constants.ENTER_NUMBER);
            String phone = scanner.nextLine();
            myContactsManager.addContact(name, phone);
            print("\n" + name + " has been added to your contacts.");
          }
          // if user chooses 2, the user can view all contacts
          case 2 -> {
            print("\n" + Constants.CONTACT_LIST + "\n");
            myContactsManager.viewContacts();
          }
          // if user chooses 3, the user can search for a contact
          case 3 -> {
            print("");
            myContactsManager.viewContacts();
            print("\n" + Constants.CONTACT_SEARCH);
            String searchName = scanner.nextLine();
            Contact result = myContactsManager.searchContact(searchName);
            if (result != null) {
              print("\nName: " + result.getName() + ", phone number is " + result.getPhoneNumber());
            } else {
              print(Constants.NO_RESULTS);
            }
          }
          // if user chooses 4, the user can delete a contact
          case 4 -> {
            print("\n" + Constants.CONTACT_LIST + "\n");
            myContactsManager.viewContacts();
            print("\n" + Constants.DELETE_CHOICE);
            String contactNumber = scanner.nextLine();
            myContactsManager.deleteContactByName(contactNumber);
          }
          // if user chooses 5, exit the app
          case 5 -> {
            print("\n" + Constants.EXITING + "\n");
            System.exit(0);
          }
          // if user chooses anything else
          default -> {
            while (true) {
              try {
                print(Constants.INVALID_CHOICE);
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
              } catch (InputMismatchException e) {
                print(Constants.INVALID_CHOICE);
                scanner.nextLine();
              }
            }
          }
        }
      }
    }
  }
}