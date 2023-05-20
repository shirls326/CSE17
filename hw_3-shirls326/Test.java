/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model All the other classes in test
 */

import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Test {
	//main method
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
	/****
	 * method to read notes
	 * @param notes
	 * @param filename
	 */
	public static void readNotes(Organizer<Note> notes, String filename) {

		File file = new File(filename);

		try{
			Scanner f = new Scanner(file);
			while(f.hasNext()){

				Date date = new Date(f.nextLine());
				String title = f.nextLine();
				String description = f.nextLine();
				Note n = new Note(date, title, description);
				notes.addElement(n);

			}

			f.close();


		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		} catch (InvalidDateTimeException e){
			System.out.println(e.getMessage());
		}

	}

	/***
	 * method to read on contacts
	 * @param contacts
	 * @param filename
	 */
	// Definition of readContacts
	public static void readContacts(Organizer<Contact> contacts, String filename) {

		File file = new File(filename);

		try{
			Scanner f = new Scanner(file);
			while(f.hasNext()){

				String line = f.nextLine();
				String[] parts = line.split(" ");
				int index = 0;

				String firstName = parts[index++];
				String lastName = parts[index++];
				String name = firstName + " " + lastName;
				String phone = parts[index++];
				String email = parts[index++];

				// Contact c = new Contact(name, phone, email);
				contacts.addElement(new Contact(name, phone, email));

			}
			f.close();


		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}

	}

}
