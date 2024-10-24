package com.findtheLosersoftheCircularGame;
import java.util.*;

/*
There are n friends that are playing a game. The friends are sitting 
in a circle and are numbered from 1 to n in clockwise order. 
More formally, moving clockwise from the ith friend brings you to 
the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth 
friend brings you to the 1st friend.

The rules of the game are as follows:

1st friend receives the ball.

	. After that, 1st friend passes it to the friend who is k steps 
		away from them in the clockwise direction.
	. After that, the friend who receives the ball should pass it to 
		the friend who is 2 * k steps away from them in the clockwise direction.
	. After that, the friend who receives the ball should pass it to 
		the friend who is 3 * k steps away from them in the clockwise direction, 
		and so on and so forth.

In other words, on the ith turn, the friend holding the ball should pass it 
to the friend who is i * k steps away from them in the clockwise direction.

The game is finished when some friend receives the ball for the second time.

The losers of the game are friends who did not receive the ball in the entire game.

Given the number of friends, n, and an integer k, return the array answer, 
which contains the losers of the game in the ascending order.
*/

public class E2682_Find_the_Losers_of_the_Circular_Game {

	public static void main(String[] args) {
		E2682_Find_the_Losers_of_the_Circular_Game solution = new E2682_Find_the_Losers_of_the_Circular_Game();
		int input = 5, k = 2;
		int[] output = solution.circularGameLosers(input, k);
        System.out.println("input: " + (input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param n: an integer
     * @param k: an integer
     * @return: the number of good triplets
     */
	public int[] circularGameLosers(int n, int k) {
        // Set to track the friends who have received the ball
        Set<Integer> received = new HashSet<>();
        int[] result;
        
        int currentFriend = 1;  // The game starts with the 1st friend
        int steps = 1;  // Initial steps to pass the ball
        
        // Continue the game until a friend receives the ball twice
        while (!received.contains(currentFriend)) {
            received.add(currentFriend);  // Mark the current friend as having received the ball
            currentFriend = (currentFriend + steps * k - 1) % n + 1;  // Move to the next friend
            steps++;  // Increase the steps (i * k for the next friend)
        }

        // Create a list of friends who did not receive the ball
        List<Integer> losers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!received.contains(i)) {
                losers.add(i);
            }
        }

        // Convert the list of losers to an array
        result = new int[losers.size()];
        for (int i = 0; i < losers.size(); i++) {
            result[i] = losers.get(i);
        }

        return result;
    }

}
