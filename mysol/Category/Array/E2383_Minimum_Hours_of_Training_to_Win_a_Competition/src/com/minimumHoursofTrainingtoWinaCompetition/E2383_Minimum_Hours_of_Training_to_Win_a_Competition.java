package com.minimumHoursofTrainingtoWinaCompetition;
import java.util.*;

/*
You are entering a competition, and are given two positive integers initialEnergy 
and initialExperience denoting your initial energy and initial experience respectively.

You are also given two 0-indexed integer arrays energy and experience, both of length n.

You will face n opponents in order. The energy and experience of the ith opponent is 
denoted by energy[i] and experience[i] respectively. When you face an opponent, 
you need to have both strictly greater experience and energy to defeat them and 
move to the next opponent if available.

Defeating the ith opponent increases your experience by experience[i], 
but decreases your energy by energy[i].

Before starting the competition, you can train for some number of hours. 
After each hour of training, you can either choose to increase your initial 
experience by one, or increase your initial energy by one.

Return the minimum number of training hours required to defeat all n opponents.
*/

public class E2383_Minimum_Hours_of_Training_to_Win_a_Competition {

	public static void main(String[] args) {
		int initialEnergy = 5, initialExperience = 3;
		int[] energy = {1,4,3,2}, experience = {2,6,3,1};
		int output = minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println("energy: " + Arrays.toString(energy) + "; experience: " + Arrays.toString(experience) + "\noutput: " + (output));
	}
	
	
	public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainingHours = 0;
        int currentEnergy = initialEnergy;
        int currentExperience = initialExperience;

        for (int i = 0; i < energy.length; i++) {
            while (currentEnergy <= energy[i] || currentExperience <= experience[i]) {
                // Decide whether to increase energy or experience
                if (currentEnergy <= energy[i]) {
                    currentEnergy++;
                } else {
                    currentExperience++;
                }
                trainingHours++;
            }
            // Defeat the opponent
            currentEnergy -= energy[i];
            currentExperience += experience[i];
        }

        return trainingHours;
    }

}
