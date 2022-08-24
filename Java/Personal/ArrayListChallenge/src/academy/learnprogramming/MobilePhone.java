package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MobilePhone {

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Contact> myContact = new ArrayList<Contact>();

    public void setMyContact(ArrayList<Contact> myContact) {
        this.myContact = myContact;
    }

    public ArrayList<Contact> getMyContact() {
        return myContact;
    }

    public void printContactList() {
        if (myContact.size() > 0) {
            System.out.println("~ Contacts in this mobile:");
            for (int i = 0; i < myContact.size(); i++) {
                System.out.println((i+1) + ". " + myContact.get(i).getName() + "\n- "
                + myContact.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("Error: No contacts are found in this mobile !!!");
        }
    }

    public void sortContact(Contact contact) {
        myContact.sort(new NameComparator());
    }

    public void addContact(Contact contact) {
        String name = contact.getName();
        int index = findContact(name);

        if (name.equals("") || name.isEmpty()) {
            System.out.println("Error: No characters found");
            System.out.println("Please add at least one characters for the contact's name.");
        } else if (index >= 0) {
            System.out.println("Error: Name already exist in contact list");
        } else {
            myContact.add(contact);
            System.out.println(name + " is successfully added to the contact list.\n");
        }
    }

    public void modify(Contact originalContact, Contact newContact) {
        int position = findContact(originalContact);
        if (position < 0) {
            System.out.println("Error: No contacts are found with that name!");
        } else if (newContact.getName().equals("")) {
            System.out.println("Error: No characters found!");
            System.out.println("Please add at least one characters.\n");
        } else if (existingContact(newContact.getName()) != null) {
            System.out.println("Error: There is already an existing contact with this name!");
            System.out.println("Please enter a new name.\n");
        } else {
            myContact.set(position, newContact);
            System.out.println("Contact " + (position + 1) + ": " +
                    originalContact.getName() + " has been modified with " + newContact.getName());
        }
    }

    private int findContact(Contact contact) {
         return myContact.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContact.size(); i++) {
            Contact contact = myContact.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact existingContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContact.get(position);
        }
        return null;
    }

    public void remove(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            myContact.remove(position);
            System.out.println("Contact " + (position+1) + ": " + myContact.get(position) +
                    " has been removed from contact list.");
        }
    }
}

class NameComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
