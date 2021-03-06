package com.uniqueEmailAddresses;
import java.util.*;

/*Every valid email consists of a local name and a domain name, 
separated by the '@' sign. Besides lowercase letters, 
the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, 
and "leetcode.com" is the domain name.

If you add periods '.' between some characters in the local name 
part of an email address, mail sent there will be forwarded to 
the same address without dots in the local name. Note that this 
rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward 
to the same email address.

If you add a plus '+' in the local name, everything after the first 
plus sign will be ignored. This allows certain emails to be filtered. 
Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".

It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each email[i], 
return the number of different addresses that actually receive mails.

 

Example 1:

Input: emails = ["test.email+alex@leetcode.com",
"test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" 
actually receive mails.

Example 2:

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3*/

public class E929_Unique_Email_Addresses {

	public static void main(String[] args) {
		String[] input = {"test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com"};
        int output = numUniqueEmails(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    去掉加号后面的，再将.去掉
    */
	
	/**
     * @param emails: 
     * @return: The number of the different email addresses
     */
	public static int numUniqueEmails(String[] emails) {
		Set<String> diff = new HashSet<>();
		
		for(String email : emails) {
			String[] parts = email.split("@");
			String[] local = parts[0].split("\\+");
			diff.add(local[0].replace(".", "") + "@" + parts[1]);
		}
		
		return diff.size();
	}

}
