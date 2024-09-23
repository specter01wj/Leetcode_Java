package com.maximumEnemyFortsThatCanBeCaptured;
import java.util.*;

/*
You are given a 0-indexed integer array forts of length n representing 
the positions of several forts. forts[i] can be -1, 0, or 1 where:

	. -1 represents there is no fort at the ith position.
	. 0 indicates there is an enemy fort at the ith position.
	. 1 indicates the fort at the ith the position is under your command.

Now you have decided to move your army from one of your forts at position i to an empty position j such that:

	. 0 <= i, j <= n - 1
	. The army travels over enemy forts only. Formally, for all k where min(i,j) < k < max(i,j), forts[k] == 0.

While moving the army, all the enemy forts that come in the way are captured.

Return the maximum number of enemy forts that can be captured. 
In case it is impossible to move your army, or you do not have any fort 
under your command, return 0.
*/

public class E2511_Maximum_Enemy_Forts_That_Can_Be_Captured {

	public static void main(String[] args) {
		E2511_Maximum_Enemy_Forts_That_Can_Be_Captured solution = new E2511_Maximum_Enemy_Forts_That_Can_Be_Captured();
		int[] input = {1,0,0,-1,0,0,0,0,1};
		int output = solution.captureForts(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int captureForts(int[] forts) {
        int maxCaptured = 0;
        int prev = -1;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (prev != -1 && forts[prev] != forts[i]) {
                    int captured = i - prev - 1;
                    if (captured > 0) {
                        maxCaptured = Math.max(maxCaptured, captured);
                    }
                }
                prev = i;
            }
        }

        return maxCaptured;
    }

}
