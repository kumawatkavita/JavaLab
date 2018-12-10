package Assignment13;


/**
A class of bags whose entries are stored in a chain of linked nodes.
The bag is never full.
@author Frank M. Carrano
 * This code is from Chapter 4 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano
 * 
 * The toString method is overwritten to give a nice display of the items in
 * the bag in this format Bag{Size:# [1] [2] [3] [4] }
 * //- * @version 4.0
 */
public final class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode; // Reference to first node
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /** Sees whether this bag is empty.
    @return true if the bag is empty, or false if not */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /** Gets the current number of entries in this bag.
    @return the integer number of entries currently in the bag */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize


    /** Adds a new entry to this bag.
    @param newEntry The object to be added as a new entry.
    @return True. */
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;
        return true;
    } // end add

    /** Retrieves all entries that are in this bag.
    @return A newly allocated array of all the entries in the bag. */
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while
        return result;
    } // end toArray

    /** Counts the number of times a given entry appears in this bag.
    @param anEntry The entry to be counted.
    @return The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        while ((loopCounter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        } // end while
        return frequency;
    } // end getFrequencyOf
    
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) 
                found = true;
             else 
                currentNode = currentNode.next;
        } // end while
        return found;
    } // end contains

    /** Removes one occurrence of a given entry from this bag, if possible.
    @param anEntry The entry to be removed.
    @return True if the removal was successful, or false otherwise. */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = firstNode.data; // Teplace located entry with entry
                // in first node
            firstNode = firstNode.next; // Remove first node
            numberOfEntries--;
            result = true;
        } // end if
        return result;
    } // end remove

// Locates a given entry within this bag.
// Returns a reference to the node containing the entry, if located,
// or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        } // end while
        return currentNode;
    } // end getReferenceTo

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    } // end clear

    private class Node {

        private T data; // Entry in bag
        private Node next; // link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

    /** Removes one unspecified entry from this bag, if possible.
    @return Either the removed entry, if the removal was successful,
    or null. */
    public T remove() {
        T result = null;
        if(firstNode == null) {
        	return null;
        }
        
        //GENERATE A RANDOM POSITION  
       int random =((int) Math.random())%numberOfEntries;
     
       //MOVE TO THAT POSITION AND SWAP THE DATA WITH THE FIRST NODE
       Node curr = firstNode;
       for(int i=random;i>0;i--) {
    	   curr=curr.next;
       }
       
       result=curr.data;
       curr.data=firstNode.data;

       //REMOVE THE FIRST NODE
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        } // end if


        return result;
    } // end remove

    /** Override the toString method so that we can inspect the contents of the bag.
     * @return A string representation of the contents of the bag. */
    public String toString() {

        String result = "Bag{Size:" + numberOfEntries + " ";

        Node scout = firstNode;

        for (int index = 0; index < numberOfEntries; index++) {
            result += "[" + scout.data + "] ";
            scout = scout.next;
        } // end for

        result += "}";
        return result;
    } // end toString

    /*********************************************************************
     * 
     * METHODS TO BE COMPLETED
     * 
     * 
     ************************************************************************/
    
    /** Check to see if two bags are equals.  
     * @param aBag Another object to check this bag against.
     * @return True if the two bags contain the same objects with the same frequencies.
     */
    public boolean equals(LinkedBag<T> aBag) {
        boolean result = false; 
        
        Node scout = firstNode;
        
        //COMPARE THE SIZE OF THE BAGS
        if(aBag.getCurrentSize() != this.getCurrentSize())
        	return result;
        
      
        while(scout!=null) {
        		//COMPARE FREQUENCY OF EACH ELEMENT
            	if(this.getFrequencyOf(scout.data) != aBag.getFrequencyOf(scout.data) )
            		return result;
            	else 
            	scout=scout.next;
        }
        	 result = true;
      
      return result;
    } 
  

    /** Duplicate all the items in a bag.
     * @return True if the duplication is possible.
     */
    public boolean duplicateAll() {
        boolean success = true; 
       
        Node ptr=firstNode;
        
        while(ptr!=null) {
        	
        	//CREATE THE NODE AND ADD TO THE BEGINNING OF THE LIST
        	
        	Node newnode = new Node(ptr.data);
        	newnode.next=firstNode;
        	firstNode = newnode;
        	numberOfEntries++;
        	
        	ptr = ptr.next;
        }

        return success;
    }  // end duplicateAll

    /** Remove all duplicate items from a bag
     */
    public void removeDuplicates() {
    	if(firstNode == null)return;
    	
    	int count = 0;
    	Node ptr=firstNode;
    	Node firstuniquechain = new Node(ptr.data);
    	firstuniquechain.next = null;
    	count++;
    	
    	while(ptr != null) {
    		
    		Node ptr2 = firstuniquechain;
    		boolean flag = false;
    		
    		//CHECK IF ELEMENT IS UNIQUE 
    		while(ptr2 != null) {
    			if(ptr.data == ptr2.data) {
    				flag = true;
    				break;
    			}
    			ptr2 = ptr2.next;
    		}
    		//IF ELEMENT IS UNIQUE ADD IT TO UNIQUE LIST
    		if(flag == false) {
    			Node newnode = new Node(ptr.data);
            	newnode.next=firstuniquechain;
            	firstuniquechain = newnode;
            	count++;
    		}
    		ptr = ptr.next;
    	}
    	
    	//CHANGE THE LINK OF LIST WITH UNIQUE LIST AND UPDATE NUMBEROFENTRIES
    	firstNode = firstuniquechain;
    	numberOfEntries = count;
    			

        return;
    }  // end removeDuplicates
}
