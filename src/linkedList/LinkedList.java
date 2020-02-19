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

    public int indexOf(Person element) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if ((current.value.getFirstName()+current.value.getLastName()).equals(element.getFirstName()+element.getLastName())
                    &&current.value.getEmail().equals(element.getEmail())) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(Person element) {
        if (indexOf(element) != -1) {
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

//    public void sort() {
//        int temp;
//        for (int i = size() - 1; i > 1; i--) {
//            var current = first;
//            for (int j = 0; j < i; j++) {
//                if (current.value > current.next.value) {
//                    temp = current.value;
//                    current.value = current.next.value;
//                    current.next.value = temp;
//                }
//                current = current.next;
//            }
//        }
//    }

//    public void addAt(int pos, int element) {
//        Node node = new Node(element);
//        var current = first;
//        int index = 1;
//        while (index < pos - 1) {
//            current = current.next;
//            index++;
//        }
//        node.next = current.next;
//        current.next = node;
//    }

//    public void deleteBetween(int pos) {
//        int index = 0;
//        Node current = first;
//        while (index < pos) {
//            current = current.next;
//            index++;
//        }
//        var previousNode = getPreviousNode(current);
//        previousNode.next = current.next;
//        current.next = null;
//
//    }

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

    private class Node {
        private Person value;
        private Node next;

        public Node(Person value) {
            this.value = value;
        }
    }
}
