package functions;

import linkedList.LinkedList;
import person.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    ArrayList<String> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addContact(LinkedList linkedList){
        System.out.println("Enter your first Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your Contact:");
        String contact = scanner.nextLine();
        arrayList.add(contact);
        System.out.println("Enter your email address:");
        String email = scanner.nextLine();
        linkedList.addLast(new Person(firstName,lastName,arrayList,email));
        System.out.println(firstName+" "+lastName+"added to your contacts");
    }

}
