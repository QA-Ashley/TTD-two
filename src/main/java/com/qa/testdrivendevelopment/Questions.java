package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string and a char, returns the position in the String where the char
	 * first appears. Ensure the positions are numbered correctly, please refer to
	 * the examples for guidance. <br>
	 * Do not ignore case <br>
	 * Ignore whitespace <br>
	 * If the char does not occur, return the number -1. <br>
	 * <br>
	 * For Example: <br>
	 * returnPosition("This is a Sentence",'s') → 4 <br>
	 * returnPosition("This is a Sentence",'S') → 8 <br>
	 * returnPosition("Fridge for sale",'z') → -1
	 */
	public int returnPosition(String input, char letter) {
		int check = -1;
		input = input.replaceAll("\\s", "");
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == letter) {
				check = i + 1;
				break;
			}
		}
		return check;
	}

	/**
	 * Given two Strings of equal length, 'merge' them into one String. Do this by
	 * 'zipping' the Strings together. <br>
	 * Start with the first char of the first String. <br>
	 * Then add the first char from the second String. <br>
	 * Then add the second char from the first String. <br>
	 * And so on. <br>
	 * Maintain case. <br>
	 * You will not encounter whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * zipped("String","Fridge") → "SFtrriidngge" <br>
	 * zipped("Dog","Cat") → "DCoagt"<br>
	 * zipped("True","Tree") → "TTrrueee" <br>
	 * zipped("return","letter") → "rleettutrenr" <br>
	 */
	public String zipped(String input1, String input2) {
		String answer = "";

		for (int i = 0; i < input1.length(); i++) {
			answer += input1.substring(i, i + 1);
			answer += input2.substring(i, i + 1);
		}

		return answer;
	}

	/**
	 * Given an Array of Strings, remove any duplicate Strings that occur, then
	 * return the Array. <br>
	 * Do not ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * removeDuplicates({"Dog"}) → {"Dog"} <br>
	 * removeDuplicates({"Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","DoG","Cat"}) → {"Dog","DoG","Cat"}
	 */
	public String[] removeDuplicates(String[] stringArray) {
		String[] unique = Arrays.stream(stringArray).distinct().toArray(String[]::new);

		return unique;
	}

	/**
	 * Given a large string that represents a csv (comma separated values), the
	 * structure of each record will be as follows:
	 * owner,nameOfFile,encrypted?,fileSize <br>
	 * <br>
	 * Example:
	 * "Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"
	 * <br>
	 * <br>
	 * Where a comma separates out the fields, and the \n represents a new line.
	 * <br>
	 * For each record, if it is not encrypted, return the names of the owners of
	 * the files in a String Array. <br>
	 * Do not include duplicate names. <br>
	 * <br>
	 * For Example: <br>
	 * csvScan("Jeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445")
	 * → {"Jeff"} <br>
	 * csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"}
	 */
	public String[] csvScan(String csvInput) {
		String[] records = csvInput.split("\n");
		List<String> tempNames = new ArrayList<String>();
		
		for(String r:records) {
			if(r.contains("False")) {
				tempNames.add(r.substring(0, r.indexOf(",")));
			}
		}

		String[] names = tempNames.stream().distinct().toArray(String[]::new);

		return names;
	}

	/**
	 * Write a function to randomly generate a list with 5 even numbers between 100
	 * and 200 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * listGen() → {100,102,122,198,200} <br>
	 * listGen() → {108,104,106,188,200} <br>
	 * listGen() → {154,102,132,178,164}
	 */
	public int[] listGen() {
		int[] list = new int[5];

		for (int i = 0; i < 5; i++) {
			list[i] = ThreadLocalRandom.current().nextInt(100, 201);
		}

		return list;

	}

	/**
	 * A prime number is one which is only divisible by one and itself. <br>
	 * Write a function which returns the boolean True if a number is prime, and the
	 * boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * isPrime(3) → True <br>
	 * isPrime(8) → False
	 */
	public boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		
		for(int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Wrtie a function which returns the number of vowels in a given string. <br>
	 * You should ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * getVowel("Hello") → 2 <br>
	 * getVowel("hEelLoooO") → 6
	 */
	public int getVowel(String input) {
		String[] vowels = {"a","e","i","o","u"};
		int count = 0;
		
		for (int a = 0; a < input.length();a++) {
			for(int b = 0; b < vowels.length;b++) {
				if(vowels[b].equalsIgnoreCase(input.substring(a,a+1))) {
					count +=1;
				}
			}
		}
		return count;
	}

	/**
	 * Given two string inputs, if one can be made from the other return the boolean
	 * True, if not return the boolean False. <br>
	 * <br>
	 * For Example: <br>
	 * wordFinder("dog", "god") → True <br>
	 * wordFinder("tiredest", "tree") → True <br>
	 * wordFinder("dog", "cat") → False <br>
	 * wordFinder("tripping", "gin") → True
	 */
	public boolean wordFinder(String initialWord, String madeString) {
		int count = 0;
		String word = "";
		
		int num1;
		int num2;
		int num3;
		int num4;
		
		switch(madeString.length()) {
		case 3:
			do {
				num1 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				num2 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				num3 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				word = initialWord.substring(num1, num1+1) + initialWord.substring(num2, num2+1) + initialWord.substring(num3, num3+1);
				if(word.equals(madeString)) {
					return true;
				}
				count++;
			} while(count != 2000);
			break;
		case 4:
			do {
				num1 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				num2 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				num3 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				num4 = ThreadLocalRandom.current().nextInt(0, initialWord.length());
				word = initialWord.substring(num1, num1+1) + initialWord.substring(num2, num2+1) + initialWord.substring(num3, num3+1) + initialWord.substring(num4, num4+1);
				if(word.equals(madeString)) {
					return true;
				}
				count++;
			} while(count != 2000);
			break;
		}
		return false;
	}

	/**
	 * There is a well known mnemonic which goes "I before E, except after C", which
	 * is used to determine which order "ei" or "ie" should be in a word. <br>
	 * <br>
	 * Write a function which returns the boolean True if a string follows the
	 * mnemonic, and returns the boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * iBeforeE("ceiling") → True <br>
	 * iBeforeE("believe") → True <br>
	 * iBeforeE("glacier") → False <br>
	 * iBeforeE("height") → False
	 */
	public boolean iBeforeE(String input) {
		boolean check;
		int whereIsE2 = 0;
		int whereIsE = input.indexOf("e");
		String input2 = input.substring(0, whereIsE) + input.substring(whereIsE+1, input.length());

		if (input2.contains("e")) {
			whereIsE2 = input2.indexOf("e")+1;
		}
		
		if(input.contains("c") && input.indexOf("c") == whereIsE-1) {
			check = true;
		} else if(input.contains("c") && input.indexOf("c") == whereIsE2-1) {
			check = true;
		} else if(input.indexOf("i") == whereIsE-1 && input.substring(input.indexOf("i")-1, input.indexOf("i")) == "c") {
			check = true;
		} else if(input.contains("i") && input.indexOf("i") == whereIsE2-1) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

	/**
	 * A factorial is the product of itself and all previous numbers <br>
	 * eg 3 factorial is 1 x 2 x 3 = 6 <br>
	 * <br>
	 * Write a function which can compute the factorial of a given number between 1
	 * and 10 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * factorial(1) → 1 <br>
	 * factorial(4) → 24 <br>
	 * factorial(8) → 40320
	 */
	public int factorial(int number) {
		int answer = 0;

		switch (number) {
		case 1:
			answer = 1*1;
			break;
		case 2:
			answer = 1*2;
			break;
		case 3:
			answer = 1*2*3;
			break;
		case 4:
			answer = 1*2*3*4;
			break;
		case 5:
			answer = 1*2*3*4*5;
			break;
		case 6:
			answer = 1*2*3*4*5*6;
			break;
		case 7:
			answer = 1*2*3*4*5*6*7;
			break;
		case 8:
			answer = 1*2*3*4*5*6*7*8;
			break;
		case 9:
			answer = 1*2*3*4*5*6*7*8*9;
			break;
		case 10:
			answer = 1*2*3*4*5*6*7*8*9*10;
			break;
		}
		return answer;
	}

}
