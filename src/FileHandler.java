import java.io.*;
import java.util.*;

public class FileHandler {
    private final String fileName;
    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public List<Contact> readContacts() {
        List<Contact> contacts = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] contactDetails = line.split(" ");
                    String name = contactDetails[0];
                    String phoneNumber = contactDetails[1];
                    contacts.add(new Contact(name, phoneNumber));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contacts;
    }

    public void writeContacts(List<Contact> contacts) {
        File file = new File(fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Contact contact : contacts) {
                bw.write(contact.getName() + " " + contact.getPhoneNumber());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
