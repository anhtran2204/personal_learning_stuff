class MyStack<E> {
    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<E>();
    }

    public boolean empty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public E push(E item) {
        list.add(item);
        return peek();
    }

    public E pop() {
        E obj = list.get(list.size()-1);
        list.remove(list.size()-1);
        return obj;
    }

    public int search(Object o) {
        int index = list.lastIndexOf(o);
        if (index > 0) {
            return list.size() - list.indexOf(o);
        }
        return index;
    }
}

public class MyArrayList<E> {
    private E array[];
    private int numItems; //contains # of current items stored
    private final int INCREMENTALCAPACITY = 5;

    //default constructor
    public MyArrayList() {
        numItems = 0;
        array = (E[]) new Object [INCREMENTALCAPACITY];
    }

    //expand the array if we are at capacity
    private void expand() {
        if (numItems == array.length) {
            //allocate larger array, transfer everything to it
            E temp[] = (E[]) new Object [array.length + INCREMENTALCAPACITY];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    //add new item at the end of array
    public void add(E newItem) {
        expand();
        //add newItem as the last item in the array
        array[numItems++] = newItem;
    }

    //insert new item at specific index
    public void add(int index, E newItem) {
        expand();
        //-------------------
        //         ^
        System.arraycopy(array, index, array, index+1, numItems-index);
        array[index] = newItem;
        numItems++;
    }


    public String toString() {
        if (numItems == 0)
            return "";

        String result = array[0].toString();
        for(int i=1; i<numItems; i++)
            result += ", " + array[i];

        return result;
    }

    //reset the whole list!
    public void clear() {
        numItems = 0;
        array = (E[]) new Object [10]; //enables old objects be garbage-collected
    }

    //does the list contains the specified object?
    public boolean contains(Object searchItem) {
        for(E item: array)                // we can also do: return indexOf(searchItem) > 0;
            if (item.equals(searchItem))
                return true;
        return false;
    }

    public E get(int index) {
        return array[index];
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    //return the index for the first occurrence pf searchItem, return -1 if not found
    public int indexOf(Object searchItem) {
        for(int i=0; i<numItems; i++)
            if (array[i].equals(searchItem))
                return i;
        return -1;
    }

    public int lastIndexOf(Object searchItem) {
        for(int i=numItems-1; i>=0; i--)
            if (array[i].equals(searchItem))
                return i;
        return -1;
    }

    public int size() {
        return numItems; //return actual # of items stored in the array
    }

    public E set(int index, E item) {
        array[index] = item;
        return array[index];
    }

    public boolean remove(Object item) { //remove the first occurrence of item in the array list.
        for(int i=0; i<numItems; i++)
            if (array[i].equals(item))
                return remove(i);
        return false;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= numItems)
            return false;
        //----------------------
        //          X
        System.arraycopy(array, index+1, array, index, numItems-index-1);
        numItems--;
        return true;
    }

    public static void main(String args[]) {
        MyArrayList<Integer> list1 = new MyArrayList<Integer>();
        list1.add(5);
        list1.add(10);
        list1.add(20);
        list1.add(1, 7);
        System.out.println(list1);
        list1.remove(1);
        System.out.println(list1);

        MyArrayList<String> list2 = new MyArrayList<String>();
        list2.add("Hello");
        list2.add("World!");
        System.out.println(list2);
    }
}
