package com.jinwang;

import java.util.LinkedList;
import java.util.Queue;

public class Ch5_exp2 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		System.out.println("=== Offer ===");
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println("Queue: " + queue);
		
		System.out.println("\n=== Poll ===");
		System.out.println("Poll: " + queue.poll());
		System.out.println("Queue: " + queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println("Queue: " + queue);
		
		System.out.println("\n=== Offer Again ===");
		queue.offer(4);
		queue.offer(5);
		System.out.println("Queue: " + queue);
		
		System.out.println("\n=== Peek ===");
		System.out.println("Front Element: " + queue.peek());
		System.out.println("Queue: " + queue);
		
		System.out.println("\n=== Size ===");
		System.out.println("Size: " + queue.size());
		
		System.out.println("\n=== Empty ===");
		System.out.println("Is Empty? " + queue.isEmpty());
		
		System.out.println("\n=== Poll Remaining Elements ===");
		while (!queue.isEmpty()) {
			System.out.println("Poll: " + queue.poll());
			System.out.println("Queue: " + queue);
		}
		
		System.out.println("\n=== Final Check ===");
		System.out.println("Is Empty? " + queue.isEmpty());
		System.out.println("Size: " + queue.size());
	}

}
