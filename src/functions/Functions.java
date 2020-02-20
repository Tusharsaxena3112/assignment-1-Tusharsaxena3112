package functions;

import linkedList.LinkedList;
import person.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    private Scanner scanner = new Scanner(System.in);
    public void addContact(LinkedList linkedList){
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Enter your first Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your Contact:");
        while(true){
            String contact = scanner.nextLine();
            if(contact.matches("[0-9]{10}")){
                arrayList.add(contact);
                break;
            }
            else{
                System.out.println("Add a valid contact.");
            }
        }
        while(true){
            System.out.println("Do you want to add another contact? ");
            String choice = scanner.nextLine();
            if(choice.equals("y")) {
                System.out.println("Enter another contact:");
                String cont = scanner.nextLine();
                while(true){
                    if (cont.matches("[0-9]{10}")) {
                        arrayList.add(cont);
                        break;
                    }
                    else{
                        System.out.println("Add valid contact");
                    }
                }
            }
            else if(choice.equals("n")){
                break;
            }
            else{
                System.out.println("Invalid selection select either y or n.");
            }
        }
        System.out.println("Enter your email address:");
        while(true){
            String temp = scanner.nextLine();
            if(temp.matches("^[a-z]+[0-1]+@[a-z]+\\.[a-z]+$")){
//               String email = temp;
                linkedList.addLast(new Person(firstName,lastName,arrayList,temp));
                break;
            }
            else{
                System.out.println("Invalid email address ! Enter again");
            }
        }
        System.out.println(firstName+" "+lastName+" added to your contacts");
    }

    public void showContacts(LinkedList linkedList){
        if(!linkedList.isEmpty()){
            linkedList.display();
        }
        else{
            System.out.println("No contacts.You dont have any contacts in your contact list . Must add first.");
        }

    }

    public void searchContact(LinkedList linkedList){
        System.out.println("Enter Name of the user you want to search:");
        String name = scanner.nextLine();
        System.out.println("Enter email of the user:");
        String email = scanner.nextLine();

        if(linkedList.indexOf(name,email)>=0){
            System.out.println("Match found!");
            linkedList.getNode(linkedList.indexOf(name,email));
        }
        else{
            System.out.println("No match!!");
        }
    }

    public void deleteContact(LinkedList linkedList){
        if(!linkedList.isEmpty()){
            System.out.println("Here are all the contacts: Press the number against" +
                    " to delete the contact.");
            linkedList.displayOne();
            int choice = scanner.nextInt();
            linkedList.deleteNode(choice);
            linkedList.displayOne();
            System.out.println("Deleted..!!");
        }
        else{
            System.out.println("No Contacts.You must need to add contacts Before you could delete..");
        }
    }

}
