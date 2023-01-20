public class Contact {
  public String name;
  public String phoneNumber;

  // Constructor for Contact class
  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  // Gets the name of the contact
  public String getName() {
    return name;
  }

  // Gets the phone number of the contact
  public String getPhoneNumber() {
    return phoneNumber;
  }

  // the toString() method is used to print the contact object
  @Override
  public String toString() {
    return "Name: " + name + ", Phone number: " + phoneNumber;
  }

  // used to compare two contact objects
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Contact contact = (Contact) o;
    return phoneNumber.equals(contact.phoneNumber);
  }
}