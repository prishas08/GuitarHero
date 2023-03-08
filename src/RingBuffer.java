import java.util.ArrayList;

public class RingBuffer
{
    private double[] data;          // items in the buffer
    private int      first;         // index for the next dequeue or peek
    private int      last;          // index for the next enqueue
    private int      size;          // number of items in the buffer

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity) {
    	
    	data = new double[capacity];
    	first = 0; 
    	last = 0;
    	size = 0;
        // YOUR CODE HERE
    }

    /** return number of items currently in the buffer */
    public int size() {
        // YOUR CODE HERE

        return size; //REPLACE
    }

    /** is the buffer empty (size equals zero)? */
    public boolean isEmpty() {
        // YOUR CODE HERE
    	if(size==0)
    	{
    		return true;
    	}
        return false; //REPLACE
    }

    /** is the buffer full (size equals array capacity)? */
    public boolean isFull() {
        // YOUR CODE HERE
    	if (size==data.length)
    	{
    		return true;
    	}
        return false; //REPLACE
    }

    /** add item x to the end */
    public void enqueue(double x) {
    	if(size == data.length)
    	{
    		throw new RuntimeException();

    	}
    	if(last == data.length)
    	{
    		last = 0;
    	}
    	if(size == 0)
    	{
    		data[first] = x;
    	}
    	else
    	{
        	data[last] = x;
    	}
    	last++;

    	size++;
    	
        // YOUR CODE HERE
    }

    /** delete and return item from the front */
    public double dequeue() {
    	
        // YOUR CODE HERE
    	if(size == 0)
    	{
    		throw new RuntimeException();

    	}
   
    	double temp = data[first];
    	double [] tempA = new double[data.length];
    	for(int i = 0; i < data.length; i++)
    	{
    		if(i!=first)
    		{
    			tempA[i] = data[i];
    		}
    		else
    		{
    		}
    	}
    	data = new double[tempA.length];
    	for(int i = 0; i < tempA.length; i++)
    	{
    		data[i]=tempA[i];
    	}
    	
    	first++;
    	if(first == data.length)
    	{
    		first = 0;
    	}
    	
    	size--;
        return temp; //REPLACE
    }

    /** return (but do not delete) item from the front */
    public double peek() {
        // YOUR CODE HERE
        return data[first]; //REPLACE
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }


        double t = buffer.dequeue();
        buffer.enqueue(t);
       System.out.println("Size after wrap-around is " + buffer.size());
        
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());

        /*
         * Your program should produce the following output:
         *
         *  Size after wrap-around is 100
			*  5050.0
         */
    }
}
