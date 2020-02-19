package functions;

import linkedList.LinkedList;
import person.Person;

public class Functions {

    public void addLast(LinkedList linkedList, Person person){
        linkedList.addLast(person);
        System.out.println(person.getFirstName()+" "+person.getLastName() +"added to your contacts");
    }



}
