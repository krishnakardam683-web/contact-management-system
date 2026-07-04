package internshipprojects;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public boolean matchesName(String searchName) {
        return name.equalsIgnoreCase(searchName);
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("--------------------------");
    }

    public String getPhone() {
        return phone;
    }
}

public class contactmanagementsystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    contacts.add(new Contact(name, phone, email));

                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:

                    if (contacts.isEmpty()) {
                        System.out.println("No Contacts Found.");
                    } else {
                        for (Contact contact : contacts) {
                            contact.display();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Contact contact : contacts) {

                        if (contact.matchesName(searchName)) {
                            contact.display();
                            found = true;
                        }

                    }

                    if (!found) {
                        System.out.println("Contact Not Found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();

                    boolean removed = contacts.removeIf(contact ->
                            contact.matchesName(deleteName));

                    if (removed) {
                        System.out.println("Contact Deleted Successfully!");
                    } else {
                        System.out.println("Contact Not Found.");
                    }

                    break;

                case 5:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}