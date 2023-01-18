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

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    if (phoneNumber.matches("[0-9]+") && (phoneNumber.length() == 10 || phoneNumber.length() == 11)) {
      this.phoneNumber = phoneNumber;
    } else {
      System.out.println("Invalid phone number. Phone number should be 10 or 11 digits.");
    }
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