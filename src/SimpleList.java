public class SimpleList {
    private Node start = null;

    public String appendToStart(float d) { // append to the start of the list
        Node newNode = new Node(d);
        if (isEmpty()) {
            start = newNode;
        } else {
            newNode.setNext(start);
            start = newNode;
        }
        return "the number "+d+" was added at the start";
    }

    public String appendToEnd(float d) { // append to the end of the list
        Node newNode = new Node(d), p = start;

        if (isEmpty()) {
            start = newNode;
        } else {
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(newNode);
        }
        return "the number "+d+" was added at the end";
    }

    public String sortByLigament(boolean sortAsc) { // sort the list
        // if the list cant be sorted, exit from the method
        if (isEmpty() || size() == 1) {
            return "The list can't be sorted.";
            
        }

        Node p = start, q, qNext=null, qPrevious = null;
        while (p != null) { // 
            // Initial values ​​for the run of q
            q = start;
            qPrevious = null;
            qNext = null;
            while (q != null) {
                qNext = q.getNext();
                if (qNext != null && // if the next exits
                ((sortAsc && q.getData() > qNext.getData()) || // sort ascendant
                (!sortAsc && q.getData() < qNext.getData()) ) ) { // or sort decreasing
                    q.setNext(qNext.getNext()); // connect q to the node that follows the next
                    qNext.setNext(q); // connet the next with q
                    // previous conection
                    if( qPrevious != null ) qPrevious.setNext(qNext);
                    // Start Change
                    if (q == start) start = qNext;
                }
                
                qPrevious = q; // set qPrevios before q advances
                q = q.getNext(); // going to next nodo
                
            }
            p = p.getNext(); // going to next nodo
        }
        return "Sorted!";
    }

    // >--------------[ UTILITY ]--------------<

    public boolean isEmpty() { // return true if the list is empty
        return start == null ? true : false;
    }

    public int size() { //return the number of nodes of the list
        Node p = start;
        int counter = 0;
        while (p != start) {
            p = p.getNext();
            counter++;
        }
        return counter;
    }

    public String showList() { // returns a string with the list
        Node p = start;
        String output = isEmpty() ? "Empty list" : "", next;

        while (p != null) {
            // output += " | " + p.getData() + p.getNext() == null ? " / " : " | -> ";
            next = p.getNext() == null ? " / " : " | -> ";
            output += " | " + p.getData() + next;
            p = p.getNext();
        }
        return output;
    }
}
