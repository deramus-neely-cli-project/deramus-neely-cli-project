import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    ContactManager contactManager = new ContactManager();
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      choice = contactManager.showMenu();
      switch (choice) {
        case 1:
          contactManager.viewContacts();
          break;
        case 2:
          contactManager.addContact();
          break;
        case 3:
          System.out.print("Enter the name of the contact to search: ");
          String name = scanner.nextLine();
          Contact contact = contactManager.searchContact(name);
          if (contact != null) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone number: " + contact.getPhoneNumber());
          } else {
            System.out.println("No contact found with the given name.");
          }
          break;
        case 4:
          System.out.print("Enter the name of the contact to delete: ");
          name = scanner.nextLine();
          if (contactManager.deleteContact(name)) {
            System.out.println("Contact deleted successfully.");
          } else {
            System.out.println("No contact found with the given name.");
          }
          break;
        case 5:
          System.out.println("Exiting application...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option (1-5).");
      }
    } while (choice != 5);

    contactManager.writeContacts();
  }

  @Override
  protected void finalize() throws Throwable {
      contactManager.writeContacts();
      super.finalize();
  }
}
