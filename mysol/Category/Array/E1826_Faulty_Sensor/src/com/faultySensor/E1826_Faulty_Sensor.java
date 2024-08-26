package com.faultySensor;
import java.util.*;

/*
An experiment is being conducted in a lab. To ensure accuracy, 
there are two sensors collecting data simultaneously. 
You are given two arrays sensor1 and sensor2, where sensor1[i] 
and sensor2[i] are the ith data points collected by the two sensors.

However, this type of sensor has a chance of being defective, 
which causes exactly one data point to be dropped. 
After the data is dropped, all the data points to the right of 
the dropped data are shifted one place to the left, and the last 
data point is replaced with some random value. 
It is guaranteed that this random value will not be equal to the dropped value.

	. For example, if the correct data is [1,2,3,4,5] and 3 is dropped, the sensor 
		could return [1,2,4,5,7] (the last position can be any value, not just 7).

We know that there is a defect in at most one of the sensors. 
Return the sensor number (1 or 2) with the defect. If there is no defect in 
either sensor or if it is impossible to determine the defective sensor, return -1.
*/

public class E1826_Faulty_Sensor {

	public static void main(String[] args) {
		E1826_Faulty_Sensor solution = new E1826_Faulty_Sensor();
		int[] sensor1 = {2, 3, 4, 5};
        int[] sensor2 = {2, 1, 3, 4};
		int output = solution.badSensor(sensor1, sensor2);
        System.out.println("input1: " + Arrays.toString(sensor1) + 
        		"; input2: " + Arrays.toString(sensor2) + "\noutput: " + (output));
	}
	
	
	public int badSensor(int[] sensor1, int[] sensor2) {
        int i = 0, sz = sensor1.length;
        while (i < sz && sensor1[i] == sensor2[i]) {
            ++i;
        }
        while (i + 1 < sz && sensor1[i] == sensor2[i + 1] && sensor1[i + 1] == sensor2[i]) {
            ++i;
        }
        return i >= sz - 1 ? -1 : sensor1[i] == sensor2[i + 1] ? 1 : 2;
    }

}
