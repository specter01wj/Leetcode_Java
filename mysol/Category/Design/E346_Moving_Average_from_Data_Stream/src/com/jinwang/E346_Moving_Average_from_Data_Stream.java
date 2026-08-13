package com.jinwang;

import java.util.LinkedList;
import java.util.Queue;

public class E346_Moving_Average_from_Data_Stream {

	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverage(3);

		System.out.println("Input: 1");
		System.out.println("Output: " + movingAverage.next(1));
		System.out.println();
		
		System.out.println("Input: 10");
		System.out.println("Output: " + movingAverage.next(10));
		System.out.println();
		
		System.out.println("Input: 3");
		System.out.println("Output: " + movingAverage.next(3));
		System.out.println();
		
		System.out.println("Input: 5");
		System.out.println("Output: " + movingAverage.next(5));
	}
	
	static class MovingAverage {

		private Queue<Integer> window;
		private int maxSize;
		private double sum;
		public MovingAverage(int size) {
			this.window = new LinkedList<>();
			this.maxSize = size;
			this.sum = 0.0;
		}
		public double next(int val) {
			// Remove oldest value when window is full
			if (window.size() == maxSize) {
				sum -= window.poll();
			}
			// Add new value
			window.add(val);
			sum += val;
			// Return moving average
			return sum / window.size();
		}
	}

}
