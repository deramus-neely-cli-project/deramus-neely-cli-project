import java.util.Scanner;

public class App {

  public static void print(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) {
    String fileName = "Contacts.txt";
    ContactsManager myContactsManager = new ContactsManager(fileName);

    try (Scanner scanner = new Scanner(System.in)) {
      int choice = 0;
      while (choice != 4) {
        print(
            "\n" + Constants.welcomeMessage + "\n\n" + Constants.addContact + "\n" + Constants.viewAllContacts
                + "\n" + Constants.searchContact + "\n" + Constants.deleteContact + "\n" + Constants.exit + "\n\n"
                + Constants.enterChoice);
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1 -> {
            print(Constants.addContactChoice);
            print(Constants.nameSearch);
            String name = scanner.nextLine();
            print(Constants.enterNumber);
            String phone = scanner.nextLine();
            myContactsManager.addContact(name, phone);
          }
          case 2 -> {
            print("\n" + Constants.contactList + "\n");
            myContactsManager.viewContacts();
          }
          case 3 -> {
            myContactsManager.viewContacts();
            print(Constants.contactSearch);
            String searchName = scanner.nextLine();
            Contact result = myContactsManager.searchContact(searchName);
            if (result != null) {
              print("Name: " + result.getName() + ", phone number is " + result.getPhoneNumber());
            } else {
              print(Constants.noResults);
            }
          }
          case 4 -> {
            print(Constants.contactList);
            myContactsManager.viewContacts();
            print(Constants.deleteChoice);
            String contactNumber = scanner.nextLine();
            myContactsManager.deleteContactByName(contactNumber);
            choice = 0;
          }
          case 5 -> {
            print(Constants.exiting);
            System.exit(0);
          }
          default -> print(Constants.wrongChoice);
        }
      }
    }
  }
}
