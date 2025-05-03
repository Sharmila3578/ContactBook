import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook cb = new ContactBook();
        Scanner sc = new Scanner(System.in);

        try {
            cb.loadContacts();
        } catch (Exception e) {
            System.out.println("Could not load contacts.");
        }

        while (true) {
            System.out.println("\nContact Book");
            System.out.println("1. Add Contact\n2. List Contacts\n3. Search\n4. Delete\n5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    cb.addContact(new Contact(name, phone, email));
                    break;
                case 2:
                    cb.listContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    cb.searchContact(sc.nextLine());
                    break;
                case 4:
                    cb.listContacts();
                    System.out.print("Enter contact number to delete: ");
                    cb.deleteContact(sc.nextInt() - 1);
                    break;
                case 5:
                    try {
                        cb.saveContacts();
                        System.out.println("Contacts saved. Exiting.");
                    } catch (Exception e) {
                        System.out.println("Error saving contacts.");
                    }
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
