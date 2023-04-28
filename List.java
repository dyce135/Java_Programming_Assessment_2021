public class List {
    protected ListNode firstNode; // the first node
    protected ListNode lastNode; // the last node
    protected String name; // a string name
    public void insertAtFront (Object newData) { // insert Object at front
        if (firstNode == null) // empty list
            firstNode = lastNode = new ListNode(newData, null);
        else {
            ListNode newFirstNode = new ListNode(newData, firstNode);
            firstNode = newFirstNode;
        }
    }
    public void insertAtBack (Object newData) { // insert Object at back
        if (firstNode == null) // empty list
            firstNode = lastNode = new ListNode(newData, null);
        else {
            ListNode newLastNode = new ListNode(newData, null);
            lastNode.next = newLastNode;
            lastNode = newLastNode;
        }
    }

    public Object removeFromFront () { // remove Object from front
        if (firstNode == null) // empty list
            return null;
        Object removedData = firstNode.data;
        if (firstNode == lastNode) // only one list node
            firstNode = lastNode = null;
        else
            firstNode = firstNode.next;
        return removedData;
    }

    public Object removeFromBack () { // remove object from back
        if (firstNode == null) // empty list
            return null;
        Object removedData = lastNode.data;
        if (firstNode == lastNode) // only one node in the list
            firstNode = lastNode = null;
        else {
            ListNode current = firstNode;
            while (current.next != lastNode)
                current = current.next;
            lastNode = current;
            current.next = null;
        }
        return removedData;
    }

    public ListNode getFirst () {
        return firstNode;
    }

    protected List concatenate (List concatList) {

        List returnList = new List("Concatenated List"); // create a new list

        if (firstNode == null && concatList.firstNode == null) { // both lists are empty
            return null;
        }

        returnList.firstNode = firstNode; // define firstnode
        lastNode.next = concatList.firstNode; // link the lists
        returnList.lastNode = concatList.lastNode; // define lastnode

        return returnList;

    }

    protected ListNode getMiddleElement () { // gets middle between two nodes of a linked list

        if (firstNode == null) { // if head node is null
            return null;
        }
        // assuming no loop we can use slow and fast pointers to find middle of a singly linked list
        ListNode slow = firstNode; // slow pointer moves 1 step at a time
        ListNode fast = firstNode; // fast pointer moves 2 steps at a time
        int i = 1;

        while(fast != lastNode) {
            i++;
            fast = fast.next;
            if (fast != lastNode) {
                i++;
                slow = slow.next;
                fast = fast.next;
            }
        }

        System.out.println(i);

        if (i%2 == 0) {
            System.out.println("Error: List has an even number of elements. Getting middle element is not possible.");
            return null;
        }

        return slow; // slow traverses half the steps so it will be the middle

    }


    @Override
    public String toString () { // print list content to string
        String output = new String();
        ListNode current = firstNode;
        output = name + ":";
        while (current != null) {
// we are implicitly calling the data object toString method
            output += " " + current.data;
            current = current.next;
        }
        return output;
    }
    // constructors
    public List(String listName) { firstNode = lastNode = null; name = listName; }
    public List() { this(new String("List")); }
} // end class List