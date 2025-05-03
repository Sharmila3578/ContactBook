import java.util.*;
import java.io.*;

public class ContactBook {
    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.txt";

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void saveContacts() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Contact c : contacts) {
            writer.write(c.getName() + "," + c.toString().split(" \\| ")[1] + "," + c.toString().split(" \\| ")[2]);
            writer.newLine();
        }
        writer.close();
    }

    public void loadContacts() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            addContact(new Contact(parts[0], parts[1], parts[2]));
        }
        reader.close();
    }
}
