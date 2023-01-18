import java.util.Scanner;

public class App {

  public static void print(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) {
    final String welcomeMessage = "Welcome to Contacts Manager";
    final String addContact = "1. Add a new contact";
    final String searchContact = "2. Search for a contact";
    final String deleteContact = "3. Delete a contact";
    final String exit = "4. Exit";
    final String enterChoice = "Enter your choice: ";
    final String addContactChoice = "You have chosen to add a new contact: ";
    final String nameSearch = "Enter the name of the contact: ";
    final String enterNumber = "Enter the phone number of the contact: ";
    final String contactSearch = "Enter the name of the contact to search for: ";
    final String noResults = "NO RESULTS FOUND!";
    final String contactList = "Here are your contacts: ";
    final String deleteChoice = "Enter the name of the contact to delete: ";
    final String exiting = "Exiting...";
    final String wrongChoice = "Wrong choice";
    String fileName = "Contacts.txt";

    ContactsManager myContactsManager = new ContactsManager(fileName);
    try (Scanner scanner = new Scanner(System.in)) {
      int choice = 0;
      while (choice != 4) {
        System.out
            .println("\n" + welcomeMessage + "\n\n" + addContact + "\n" + searchContact + "\n" + deleteContact + "\n"
                + exit + "\n\n" + enterChoice);
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1 -> {
            print(addContactChoice);
            print(nameSearch);
            String name = scanner.nextLine();
            print(enterNumber);
            String phone = scanner.nextLine();
            myContactsManager.addContact(new Contact(name, phone));
          }
          case 2 -> {
            print(contactSearch);
            String searchName = scanner.nextLine();
            Contact result = myContactsManager.searchContact(searchName);
            if (result != null) {
              print("Name: " + result.getName() + ", phone number is " + result.getPhoneNumber());
            } else {
              print(noResults);
            }
          }
          case 3 -> {
            print(contactList);
            myContactsManager.viewContacts();
            print(deleteChoice);
            String contactNumber = scanner.nextLine();
            myContactsManager.deleteContactByName(contactNumber);
          }
          case 4 -> print(exiting);
          default -> print(wrongChoice);
        }
      }
    }
  }
}
