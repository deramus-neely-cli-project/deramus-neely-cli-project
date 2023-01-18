public class Contact {
  public String name;
  public String phoneNumber;

  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Phone number: " + phoneNumber;
  }

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