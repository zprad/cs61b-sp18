/*
*  BoundedQueue interface
*  2019/12/10
*  prad
* */

package synthesizer;

public interface BoundedQueue<T> {
    public int capacity();     // return size of the buffer
    public int fillCount();    // return number of items currently in the buffer
    public void enqueue(T x);  // add item x to the end
    public T dequeue();        // delete and return item from the front
    public T peek();           // return (but do not delete) item from the front

    default public boolean isEmpty() {  // is the buffer empty (fillCount equals zero)?
        return fillCount() == 0;
    }

    default public boolean isFull() {   // is the buffer full (fillCount is same as capacity)?
        return fillCount() == capacity();
    }
}