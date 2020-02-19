package Main;

import linkedList.LinkedList;
import person.Person;

import java.util.Scanner;

import functions.Functions;

public class Main {

    //Press 1 to add a new contact
    //Press 2 to view all contacts
    //Press 3 to search for a contact
    //Press 4 to delete a contact
    //Press 5 to exit program

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        Functions functions = new Functions();

        System.out.println("Hey there !! My name is Tushar Saxena " +
                ".. Here what can I do for you--->>");
        int c=0;
        while(c!=5) {
            System.out.println("<----------x------x---------->");
            System.out.println("Press 1 to add a new contact");
            System.out.println("Press 2 to view all contacts");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit program ");
            System.out.println("<-----------x------x---------->");

            String choice = scanner.nextLine();

            switch (choice) {
               case "1":
                    functions.addContact(linkedList);
                    break;
                case "2":functions.showContacts(linkedList);
                    break;
                case "3":functions.searchContact(linkedList);
                    break;
                case "4":functions.deleteContact(linkedList);
                    break;
                case "5":
                    c=5;
                    System.out.println("Thank you for using our App..");
                    break;
                default:
                    System.out.println("Invalid choice!! Please select a valid choice.");
            }
        }

    }
}
