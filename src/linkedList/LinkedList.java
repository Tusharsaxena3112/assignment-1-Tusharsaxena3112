package linkedList;

import person.Person;

public class LinkedList {
    Person person;
    private Node first;
    private Node last;

    public void addLast(Person element) {
        Node node = new Node(element);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(Person element) {
        Node node = new Node(element);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int indexOf(String firstName,String email) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if ((current.value.getFirstName().equals(firstName)
                    &&current.value.getEmail().equals(email))){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(String firstName,String email) {
        if (indexOf(firstName,email) != -1) {
            return true;
        }
        return false;
    }

    public void removeFirst() {
        if (first == last) {
            first = last = null;
            return;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
    }

    public void removeLast() {
        var previousNode = getPreviousNode(last);
        last = previousNode;
        last.next = null;
    }

    private int size() {
        var current = first;
        int index = 1;
        while (current.next != null) {
            current = current.next;
            index++;
        }
        return index;
    }
    public void deleteNode(int position)
    {
        // If linked list is empty
        if (first == null)
            return;
        // Store head node
        Node temp = first;
        // If head needs to be removed
        if (position == 0)
        {
            first = temp.next;   // Change head
            return;
        }
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
        temp.next = next;  // Unlink the deleted node from list
    }


    private Node getPreviousNode(Node node) {
        var current = first;
        while (current.next != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        var current = first;
        System.out.println("Contact list--->");
        System.out.println();
        while (current != null) {
            System.out.println("-----------------------*-------------------------");
            System.out.println("Name:" + current.value.getFirstName() + " " + current.value.getLastName());
            System.out.println("Contacts:" + current.value.getContacts().toString());
            System.out.println("Email:" + current.value.getEmail());
            System.out.println("------------------------*-------------------------");
            System.out.println();
            current = current.next;
        }
        System.out.println();
    }

    public void displayOne(){
        var current = first;
        int count = 0;
        System.out.println("-----------------------*-------------------------");
        while (current != null) {
            System.out.println(count+" Name:"+current.value.getFirstName()+" "+current.value.getLastName());
            current = current.next;
            count++;
        }
        System.out.println("------------------------*-------------------------");
        System.out.println();
    }

    public void getNode(int pos){
        var current = first;
        int index= 0;
        while(current!=null){
            if(index==pos){
                System.out.println();
                System.out.println("-----------------------*-------------------------");
                System.out.println("Name:" + current.value.getFirstName() + " " + current.value.getLastName());
                System.out.println("Contacts:" + current.value.getContacts().toString());
                System.out.println("Email:" + current.value.getEmail());
                System.out.println("------------------------*-------------------------");
                System.out.println();
                break;
            }
            index++;
            current=current.next;
        }
    }

    private class Node {
        private Person value;
        private Node next;

        public Node(Person value) {
            this.value = value;
        }
    }
}
