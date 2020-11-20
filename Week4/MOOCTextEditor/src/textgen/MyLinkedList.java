package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /** Create a new empty LinkedList */
    public MyLinkedList() {
        size = 0;
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     * 
     * @param element The element to add
     */
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        LLNode<E> n = new LLNode<E>(element);
        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;
        size++;
        return true;
    }

    public void addFront(E element) {
        LLNode<E> n = new LLNode<E>(element);
        n.next = head.next;
        n.prev = n.next.prev;
        n.next.prev = n;
        head.next = n;
    }

    /**
     * Get the element at position index
     * 
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        // TODO: Implement this method.
        E ans = null;
        if (this.size <= index || (index < 0)) {
            throw new IndexOutOfBoundsException("Requested item not in list");
        } else {
            if (index >= 0 && index <= this.size / 2) {
                int i = 0;
                LLNode<E> me = head;
                while (i <= index) {
                    me = me.next;
                    i++;
                }
                ans = me.data;
            } else {
                int d = this.size - index;
                int i = 0;
                LLNode<E> me = tail;
                while (i < d) {
                    me = me.prev;
                    i++;
                }
                ans = me.data;
            }
        }
        return ans;
    }

    /**
     * Add an element to the list at the specified index
     * 
     * @param The     index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if ((index < 0 || index >= size) && size != 0) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> me;
        if (index >= 0 && index <= this.size / 2) {
            int i = 0;
            me = head;
            while (i <= index) {
                me = me.next;
                i++;
            }
        } else {
            int d = this.size - index;
            int i = 0;
            me = tail;
            while (i < d) {
                me = me.prev;
                i++;
            }
        }
        LLNode<E> ad = new LLNode<E>(element);
        ad.next = me;
        ad.prev = me.prev;
        ad.prev.next = ad;
        ad.next.prev = ad;
        this.size += 1;
    }

    /** Return the size of the list */
    public int size() {
        return this.size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     * 
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     * 
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> me;
        if (index >= 0 && index <= this.size / 2) {
            int i = 0;
            me = head;
            while (i <= index) {
                me = me.next;
                i++;
            }
        } else {
            int d = this.size - index;
            int i = 0;
            me = tail;
            while (i < d) {
                me = me.prev;
                i++;
            }
        }
        E d = me.data;
        me.prev.next = me.next;
        me.next.prev = me.prev;
        this.size -= 1;
        return d;
    }

    /**
     * Set an index position in the list to a new element
     * 
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        LLNode<E> me;
        if (index >= 0 && index <= this.size / 2) {
            int i = 0;
            me = head;
            while (i <= index) {
                me = me.next;
                i++;
            }
        } else {
            int d = this.size - index;
            int i = 0;
            me = tail;
            while (i < d) {
                me = me.prev;
                i++;
            }
        }
        E d = me.data;
        me.data = element;
        return d;
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor

    public LLNode() {
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }
}