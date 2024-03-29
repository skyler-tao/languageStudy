package format;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;

public class BasicMessageFormatExample {

	public static boolean isPrime(int n) {
		
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= (int)Math.sqrt(n) + 1; i++) {
			if ((n%i == 0)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[10];
		Random rnd = new Random();
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = rnd.nextInt(100);
		}
		
		int primes = 0;
		for(int num : nums) {
			if(isPrime(num)) {
				primes++;
			}
		}
		
		String message = "On the test run at {0, TIME} on {0, date}, we found {1} prime numbers";
		MessageFormat messageFormat = new MessageFormat(message);
		System.out.println(messageFormat.format(new Object[] {new Date(), primes}));
	}
}
