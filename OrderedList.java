public abstract class OrderedList extends List {

    protected abstract int compare (Object obj1, Object obj2); // abstract method overridden by child classes

    public ListNode find (Object data) { // original find method to search the lists

        if (firstNode == null) { // if list is empty
            return null; // returns null if list is empty
        }

        ListNode temp = firstNode; // create a ListNode reference and initiate to firstNode

        while(temp != null) { // compares every element in the list
            if (compare (data, temp.data) == 0) {
                return temp; // returns the node if found
            } else {
                temp = temp.next; // points to next element
            }
        }

        return null; // element not found

    }

    public boolean insert (Object newData) { // method to insert elements to lists in order

        if (firstNode == null) { // if list is empty
            firstNode = lastNode = new ListNode(newData, null); // creates a listnode with inserted data
            return true; // returns true to indicate success
        }

        else if (binaryFind(newData) != null) { // if search finds the element data and it already exists in the list
            return false; // already exists so returns false to indicate failure
        }

        else if (compare(newData, firstNode.data) < 0) { // if the element is less than the first node
            firstNode = new ListNode(newData, firstNode); // creates new listnode object before firstnode and declare it as a new firstnode
            return true;
        }

        else if (compare(newData, lastNode.data) > 0) { // if the element is greater than the last node
            ListNode newLastNode = new ListNode(newData, null); // create a new listnode object with the data
            lastNode.next = newLastNode; // declare the next listnode of the original lastnode to be the newlastnode
            lastNode = newLastNode; // declare the newlastnode to be the last node
            return true;
        }

        ListNode newNode = new ListNode(newData, null); //
        ListNode temp = firstNode;
        ListNode tempNext = firstNode.next;
        while (compare(newData, tempNext.data) > 0) {
            temp = temp.next;
            tempNext = tempNext.next;
        }
        newNode.next = tempNext;
        temp.next = newNode;
        System.out.println("ok");
        return true;

    }

    public ListNode remove (Object data) {

        if (firstNode == null) { // list is empty
            return null; // failed so return null
        }

        ListNode temp = firstNode; // create a listnode reference initialised to firstnode
        ListNode removedNode; // create a listnode reference removednode

        if (firstNode == lastNode && firstNode == data) { // only one element in the list
            removedNode = firstNode; // initialise removednode to firstnode
            firstNode = lastNode = null; //
            return removedNode; // return the removed node
        }

        if (compare (data, firstNode.data) == 0) { // if it is at the first node
            removedNode = firstNode; // initialise removednode to firstnode
            firstNode = firstNode.next; // move the firstnode to the next node
            return removedNode; // return the removednode
        }

        while (temp.next != null) { // otherwise, scan the list for the data
            if (compare (data, temp.next.data) == 0) { // if it is found
                removedNode = temp.next; // set the found node to the reference removednode
                if (temp.next == lastNode) { // if it is the last node
                    lastNode = temp; // set the lastnode to the previous node
                    temp.next = null; // set the next node to be null
                    return removedNode;
                }
                temp.next = temp.next.next; // replace the next node for temp to
                return removedNode; // return removedNode
            }
            temp = temp.next; // moves on to the next node in the loop
        }
        return null; // data does not exist in list

    }

    public ListNode getMiddle (ListNode head, ListNode end) { // gets middle between two nodes of a linked list

        if (head == null) { // if head node is null
            return null;
        }
        // assuming no loop we can use slow and fast pointers to find middle of a singly linked list
        ListNode slow = head; // slow pointer moves 1 step at a time
        ListNode fast = head.next; // fast pointer moves 2 steps at a time

        while(fast != end) {
            fast = fast.next;
            if (fast != end) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow; // slow traverses half the steps so it will be the middle

    }

    public ListNode binaryFind(Object data) { // binary search uses the getMiddle method to efficiently search the lists

        if (firstNode == null) { // list is empty, so return null
            return null;
        }

        ListNode start = firstNode; // set firstnode as the start
        ListNode end = null; // search ends when null is encountered

        do {

            ListNode mid = getMiddle(start, end); // get the middle node and define as listnode mid

            if (mid == null) { // if middle is empty
                return null; // failed, so return null
            }


            if (compare(data, mid.data) == 0) { // if value is present at middle
                return mid; // found, so return the node
            }

            else if (compare(data, mid.data) > 0) { // if value is greater than mid
                start = mid.next; // start searching the upper half, beginning by obtaining the middle of the upper half
            }


            else { // if the value is less than mid.
                end = mid; // start searching the lower half, beginning by obtaining the middle of the lower half
            }

        } while (end == null || end != start); // search continues while end is null (searching upper half) or end is not at start (searching lower half)

        return null; // search found no results

    }

    @Override
    public String toString () { // overrides List toString method
        if (firstNode == null) { // if list is empty
            return name + " is empty.";
        }
        String output; // create the string
        ListNode current = firstNode; // define current by initialising to firstNode
        output = name + ": " + current.data; // concatenate first element
        current = current.next; // move on to next node
        while (current != null) { // we are implicitly calling the data object toString method
            output += ", " + current.data; // concatenate elements
            current = current.next; // move on to next node
        }
        return output; // output the string
    }

    @Override
    public void insertAtFront(Object newData) { // insert Object at front, override for orderedlist
        System.out.println("This method should not be used.");
    }

    @Override
    public void insertAtBack(Object newData) { // insert Object at back, override for orderedlist
        System.out.println("This method should not be used.");
    }

}






