import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    final String welcomeMessage = "Welcome to Contacts Manager";
    final String addContact = "1. Add a new contact";
    final String searchContact = "2. Search for a contact";
    final String deleteContact = "3. Delete a contact";
    final String exit = "4. Exit";
    final String enterChoice = "Enter your choice: ";
    ContactsManager myContactsManager = new ContactsManager();
    try (Scanner scanner = new Scanner(System.in)) {
      int choice = 0;
      while (choice != 4) {
        System.out
            .println("\n" + welcomeMessage + "\n\n" + addContact + "\n" + searchContact + "\n" + deleteContact + "\n" + exit + "\n\n" + enterChoice);
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1:
            System.out.println("You have chosen to add a new contact: ");
            System.out.println("Please enter the name of the Person");
            String name = scanner.nextLine();
            System.out.println("Please enter the phone number");
            String phone = scanner.nextLine();
            myContactsManager.addContact(name, phone);
            break;
          case 2:
            System.out.println("You could search for a contact from their first names: ");
            String searchName = scanner.nextLine();
            Contact result = myContactsManager.searchContact(searchName);
            if (result != null) {
              System.out.println("Name: " + result.getName() + ", phone number is " + result.getPhoneNumber());
            } else {
              System.out.println("NO RESULTS FOUND!");
            }
            break;
          case 3:
            System.out.println("Here are your contacts: ");
            myContactsManager.viewContacts();
            System.out.println("Press the number against the contact to delete it: ");
            String contactNumber = scanner.nextLine();
            scanner.nextLine();
            myContactsManager.deleteContact(contactNumber);
            break;
          case 4:
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Wrong choice");
        }
      }
    }
  }
}
