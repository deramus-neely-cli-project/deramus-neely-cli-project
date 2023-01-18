import java.util.Scanner;

public class App {

  public static void Print(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) {
    final String fileName = "Contacts.txt";
    ContactsManager myContactsManager = new ContactsManager(fileName);

    try (Scanner scanner = new Scanner(System.in)) {
      int choice;
      while (true) {
        Print(
            "\n" + Constants.WelcomeMessage + "\n\n" + Constants.AddContact + "\n" + Constants.ViewAllContacts
                + "\n" + Constants.SearchContact + "\n" + Constants.DeleteContact + "\n" + Constants.Exit + "\n\n"
                + Constants.EnterChoice);
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1 -> {
            Print("\n" + Constants.AddContactChoice);
            Print(Constants.NameSearch);
            String name = scanner.nextLine();
            Print("\n" + Constants.EnterNumber);
            String phone = scanner.nextLine();
            myContactsManager.addContact(name, phone);
            Print("\n" + name + " has been added to your contacts.");
          }
          case 2 -> {
            Print("\n" + Constants.ContactList + "\n");
            myContactsManager.viewContacts();
          }
          case 3 -> {
            Print("");
            myContactsManager.viewContacts();
            Print("\n" + Constants.ContactSearch);
            String searchName = scanner.nextLine();
            Contact result = myContactsManager.searchContact(searchName);
            if (result != null) {
              Print("\nName: " + result.getName() + ", phone number is " + result.getPhoneNumber());
            } else {
              Print(Constants.NoResults);
            }
          }
          case 4 -> {
            Print("\n" + Constants.ContactList + "\n");
            myContactsManager.viewContacts();
            Print("\n" + Constants.DeleteChoice);
            String contactNumber = scanner.nextLine();
            myContactsManager.deleteContactByName(contactNumber);
          }
          case 5 -> {
            Print("\n" + Constants.Exiting + "\n");
            System.exit(0);
          }
          default -> Print(Constants.WrongChoice);
        }
      }
    }
  }
}
