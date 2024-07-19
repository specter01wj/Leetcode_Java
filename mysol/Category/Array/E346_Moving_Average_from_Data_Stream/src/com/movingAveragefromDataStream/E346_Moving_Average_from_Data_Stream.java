package com.movingAveragefromDataStream;
import java.util.*;

/*
Given a stream of integers and a window size, calculate 
the moving average of all integers in the sliding window.

Implement the MovingAverage class:

. MovingAverage(int size) Initializes the object with the size of the window size.
. double next(int val) Returns the moving average of the last size values of the stream.
*/

public class E346_Moving_Average_from_Data_Stream {

	public static void main(String[] args) {
		E346_Moving_Average_from_Data_Stream movingAverage = new E346_Moving_Average_from_Data_Stream(3);
        System.out.println(movingAverage.next(1)); // return 1.0
        System.out.println(movingAverage.next(10)); // return 5.5
        System.out.println(movingAverage.next(3)); // return 4.66667
        System.out.println(movingAverage.next(5)); // return 6.0
	}
	
	/*
    solution:
    Queue
    */
	
	/*
     * @param : a list of integers
     * @return: the moving average of all integers in the sliding window
     */
	private Queue<Integer> window;
    private int maxSize;
    private double sum;

    public E346_Moving_Average_from_Data_Stream(int size) {
        this.window = new LinkedList<>();
        this.maxSize = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        if (window.size() == maxSize) {
            sum -= window.poll();
        }
        window.add(val);
        sum += val;
        return sum / window.size();
    }

}
