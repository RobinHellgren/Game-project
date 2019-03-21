package tools;

import java.util.Random;
//tool class with static functions that returns die roll values as ints, accepts an int parameter for the ammount of dice to roll
public class DieBag {
	public static int rolld6(int numberOfDie) {
		Random rand = new Random();
		int result = 0;
		for(int x = 0; x < numberOfDie; x++) {
			result += rand.nextInt(6)+1;
		}
		return result;
	}
	public static int rolld8(int numberOfDie) {
		Random rand = new Random();
		int result = 0;
		for(int x = 0; x < numberOfDie; x++) {
			result += rand.nextInt(8)+1;
		}
		return result;
	}
	public static int rolld10(int numberOfDie) {
		Random rand = new Random();
		int result = 0;
		for(int x = 0; x < numberOfDie; x++) {
			result += rand.nextInt(10)+1;
		}
		return result;
	}
	public static int rolld20(int numberOfDie) {
		Random rand = new Random();
		int result = 0;
		for(int x = 0; x < numberOfDie; x++) {
			result += rand.nextInt(20)+1;
		}
		return result;
	}
}
