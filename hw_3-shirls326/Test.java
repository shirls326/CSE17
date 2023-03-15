import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Organizer<Contact> contacts = new Organizer<>(20);
		Organizer<Note> notes = new Organizer<>(20);

		// Testing Organizer for type Note
		readNotes(notes, "notes.txt");
		System.out.println("List of notes:\n" + notes);
		try{
			Date d = new Date("02/22/2021");
			Note n = new Note(d, "Medicine", "Pick up at the pharmacy");
			notes.addElement(n);
			System.out.println("Note: (" + n + ") added successfully.");
			System.out.println("\nList of notes:\n" + notes);
			d = new Date("01/26/2021");
			n = new Note(d, "", "");
			n = notes.findElement(n);
			if (n == null)
				System.out.println("Note not found.");
			else {
				System.out.println("Note found: " + n);
				notes.removeElement(n);
				System.out.println("Note (" + n + ") removed successfully.");
			}
		}
		catch(InvalidDateTimeException e){
			System.out.println(e.getMessage());
		}


		System.out.println("\nList of notes:\n" + notes);
		notes.setComparator(new ComparatorByTitle());
		System.out.println("\nList of notes sorted by title:\n" + notes);

		// Testing Organizer for type Contact
		readContacts(contacts, "contacts.txt");
		System.out.println("\nList of contacts:\n" + contacts);
		Contact c = new Contact("Floss Albert", "610-222-2434", "afloss@lehigh.edu");
		contacts.addElement(c);
		System.out.println("Contact (" + c + ") added successfully.");
		System.out.println("\nList of contacts:\n" + contacts);
		c = new Contact("Philip Mensen", "", "");
		c = contacts.findElement(c);
		if (c == null)
			System.out.println("Contact not found.");
		else {
			System.out.println("Contact found: " + c);
			contacts.removeElement(c);
			System.out.println("Contact (" + c + ") removed successfully.");
		}
		c = new Contact("Albares Cammy", "", "");
		c = contacts.findElement(c);
		if (c == null)
			System.out.println("Contact not found.");
		else {
			System.out.println("Contact found: " + c);
			contacts.removeElement(c);
			System.out.println("Contact(" + c + ") removed successfully.");
		}
		System.out.println("\nList of contacts:\n" + contacts);
		contacts.setComparator(new ComparatorByEmail());
		System.out.println("\nList of contacts sorted by email:\n" + contacts);
	}

	// Definition of readNotes
	public static void readNotes(Organizer<Note> notes, String filename) {

	}

	// Definition of readContacts
	public static void readContacts(Organizer<Contact> contacts, String filename) {

	}

}
