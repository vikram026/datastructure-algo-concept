package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ALLInOneString {
	static int maxCount = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abaabcdefgfgddfh";
		char[] charArray = s.toCharArray();
		String[] string= {"a"};
		int st=Math.a
		int[] ad=Stream.of(string).mapToInt(Integer::parseInt).toArray();
		//forEach(e->System.out.print(e));
		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& FindMaxOccuringCharacter in the given String");
		char a = findMaxCharactor(charArray, s.length());
		System.out.println("Max occurring character is " + a + " and maxCount is" + maxCount);

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Remove Duplicates from String ");
		String distinctString = removeDuplicates(charArray, s.length());
		System.out.println(distinctString);

		System.out.println("&&&&&  Check wether given two strings are rotations of each other or not ?");
		String s1 = "abc";
		String s2 = "bac";
		boolean isRotation = checkRotation(s1, s2);
		System.out.println(isRotation);

		System.out.println(" &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&  Reverse the word in a given line");

		String line = "india is good";
		String reversedString = reverseWordOfLines(line);
		System.out.println("reversed line is-> " + reversedString);

		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& find the first non repeating character in a given string");
		char result = firstNonRepeatingChar(s);
		System.out.println("first non-repeating character is: " + result);

		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Check weather two strings are anagrams of each other or not?");
		boolean isAnagram = isAnagram(s1, s2);
		System.out.println("say yes for anagram or no for not a anagram " + isAnagram);

		System.out.println("&&&&&&&&&&&&Find the excel column name for given column no");
		int columnNo = 1;
		String column = findColumnFromColumnNo(columnNo);
		System.out.println("Column name for give column No is: " + column);

		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&   Find the smallest window in a string that contains all characters of another string ");
		String bulkString = "abcdxawzxcbcdwazx";
		String smallString = "azx";
		int smallestWindowSize = getSmallestWindowSize(bulkString, smallString);
		System.out.println("\nSmallest window contains the given string is :::::: " + smallestWindowSize + "\n");

		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&&&&& Find the first non repeating character from a stream of character.");
		char nonRepeatingChar = firstNonRepeatingCharacterFromStream(s);
		System.out.println("first Non Repeating Character is:: " + nonRepeatingChar);

		System.out.println(
				"&&&&&&&&&&&&&&&&&&&&&&& minimum no of palindromic subsequence to be removed for binary string of 0s and 1s");
		String stringSequence = "101";
		int countOfPalindromicSequenceToBeRemoved = getNoOfPalindromicSequenceToBeRemoved(stringSequence);
		System.out.println("min no is::: " + countOfPalindromicSequenceToBeRemoved);

		System.out.println("&&&&&&&&&&&&&&&&&&&& Check if given sequence of moves forms circular or not ? ");
		String moves = "GLGLGLG";
		// String moves="GLGRGLG"
		boolean isCircular = operation(moves);
		System.out.println("Is moves taken by robbot is circular?" + isCircular);

		System.out.println("&&&&&&&&&&&&&Minimum and max of array using minimum no of comparisions");
		int[] array = { 4, 1, 3, 5, 8, 7, 6, 4 };
		printMinAndmax(array);

		System.out.println("Convert one string to another using minimum no of given operation(rotation)");
		String string1 = "vikky";
		String string2 = "    ";
		int noOfOperations = convertString2ToString1(string1, string2);
		System.out.println("minimum no of operation is ::: - > " + noOfOperations);

		System.out.println("print concatination of zigzag string in k-rows");
		int k = 3;
		//printZigZag(s, k);

		System.out.println("Remove adjacent duplicate character in a given string");

	}

	private static void printZigZag(String s, int k) {
		char[][] temp = new char[k][];
		int i = 0, j = 0;
		for (char tempChar : s.toCharArray()) {
//			for(int i=0;i<k;i++) {
//				
//				
//			}
			if (i < k) {
				temp[i][j] = tempChar;
				i++;
			}

		}

	}

	private static int convertString2ToString1(String string1, String string2) {
		int[] hash = new int[256];
		if (string1.length() != string2.length())
			return -1;
		for (int i = 0; i < string1.length(); i++) {
			hash[string1.charAt(i)]++;
			hash[string2.charAt(i)]--;
		}
		for (int temp : hash) {
			if (temp != 0)
				return -1;
		}
		int i = string1.length() - 1, result = 0;
		int j = i;
		while (i >= 0) {
			if (string1.charAt(i) != string2.charAt(j))
				result++;
			else
				j--;
			i--;
		}
		return result;
	}

	private static boolean operation(String moves) {
		String direction = "North";
		int x = 0, y = 0;
		for (char temp : moves.toCharArray()) {
			if (temp == 'G') {
				switch (direction) {
				case "North":
					y++;
					break;
				case "South":
					y--;
					break;
				case "East":
					x++;
					break;
				case "West":
					x--;
					break;
				default:
				}
			} else if (temp == 'L') {
				switch (direction) {
				case "North":
					direction = "West";
					break;
				case "South":
					direction = "East";
					break;
				case "East":
					direction = "North";
					break;
				case "West":
					direction = "South";
					break;
				default:
				}
			} else {
				switch (direction) {
				case "North":
					direction = "East";
					break;
				case "South":
					direction = "West";
					break;
				case "East":
					direction = "South";
					break;
				case "West":
					direction = "North";
					break;
				default:
				}
			}

		}
		if (x == 0 && y == 0)
			return true;
		return false;
	}

	private static void printMinAndmax(int[] array) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int a = 0, b = 0;
		for (int i = 0; i < array.length - 1; i = i + 2) {
			a = array[i];
			b = array[i + 1];
			if (a > b) {
				if (a > max)
					max = a;
				if (b < min)
					min = b;
			} else {
				if (b > max)
					max = b;
				if (a < min)
					min = a;
			}
		}
		System.out.println("Minimum of the array is ->" + min + " maximum of the following array is -> " + max);

	}

	private static int getNoOfPalindromicSequenceToBeRemoved(String stringSequence) {
		if (isPalindrome(stringSequence))
			return 1;
		return 2;
	}

	private static boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--))
				return false;
		}
		return true;
	}

	private static char firstNonRepeatingCharacterFromStream(String s) {
		boolean[] repeated = new boolean[256];
		List<Character> dll = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (!repeated[temp]) {
				if (!dll.contains(temp)) {
					dll.add(temp);
				} else {
					dll.remove((Character) temp);
					repeated[temp] = true;
				}
			}

		}

		return dll.get(0);
	}

	private static int getSmallestWindowSize(String bulkString, String smallString) {
		int bulkSize = bulkString.length();
		char[] bulkCharArray = new char[bulkSize];
		int[] hash = new int[256];
		Arrays.fill(hash, 0);
		int minWindowSize = bulkSize;

		for (int i = 0; i < bulkSize; i++) {
			if (smallString.contains(bulkString.charAt(i) + ""))
				bulkCharArray[i] = bulkString.charAt(i);
			else
				bulkCharArray[i] = '-';

		}
		for (char e : bulkCharArray) {
			System.out.print(e + " ");
		}
		int j = 0;
		for (int i = 0; i < bulkSize; i++) {
			char temp = bulkCharArray[i];
			if (temp == '-')
				continue;
			hash[temp]++;
			if (isHashFull(smallString, hash)) {
				while (j < (i - smallString.length() + 1)) {
					char tempj = bulkCharArray[j];

					if (tempj == '-') {
						j++;
						continue;
					} else if (hash[tempj] > 1) {
						hash[tempj]--;
						j++;
					} else
						break;

				}
				if (minWindowSize > (i - j + 1)) {
					minWindowSize = i - j + 1;
				}
			}

		}

		return minWindowSize;
	}

	private static boolean isHashFull(String smallString, int[] hash) {
		for (char smallTemp : smallString.toCharArray()) {
			if (hash[smallTemp] == 0)
				return false;

		}
		return true;
	}

	private static String findColumnFromColumnNo(int columnNo) {
		if (columnNo == 0)
			return "No any column found";
		String result = "";
		// columnNo--;
		while (columnNo > 0) {
			columnNo--;
			char temp = (char) (65 + columnNo % 26);
			result = temp + result;
			columnNo /= 26;
		}
		return result;
	}

	private static boolean isAnagram(String s1, String s2) {
		int[] array = new int[256];
		Arrays.fill(array, 0);
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			array[s1.charAt(i)] += 1;
		}
		for (int i = 0; i < s2.length(); i++) {
			array[s2.charAt(i)] -= 1;
		}
		for (int i = 0; i < 256; i++) {
			if (array[i] != 0)
				return false;
		}
		return true;
	}

	private static char firstNonRepeatingChar(String s) {

		Map<Character, Integer[]> charMap = new HashMap<>();
		int iter = 0;

		while (iter < s.length()) {
			if (charMap.containsKey(s.charAt(iter))) {
				charMap.get(s.charAt(iter))[0] += 1;
			} else {
				Integer[] arrayNew = new Integer[2];
				arrayNew[0] = 1;
				arrayNew[1] = iter;
				charMap.put(s.charAt(iter), arrayNew);
			}

			iter++;
		}
		return charMap.entrySet().stream().sorted((e1, e2) -> e1.getValue()[1].compareTo(e2.getValue()[1]))
				.filter(e -> e.getValue()[0].equals(1)).map(set -> set.getKey()).findAny().get();

	}

	private static String reverseWordOfLines(String line) {
		char[] chars = line.toCharArray();
		int n = line.length();
		int start = 0, end = 0;
		while (end < n) {
			if (end == n - 1) {
				reverseWord(chars, start, end);
			}

			else if (chars[end] == ' ') {
				reverseWord(chars, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		reverseWord(chars, 0, n - 1);
		return String.valueOf(chars);
	}

	private static void reverseWord(char[] word, int start, int end) {

		while (start < end) {
			char temp = word[start];
			word[start++] = word[end];
			word[end--] = temp;
		}
	}

	private static boolean checkRotation(String s1, String s2) {
		s2 += s2;
		for (int i = 0; i < s1.length(); i++) {
			if (s2.charAt(i) == s1.charAt(0) && s2.substring(i, i + s1.length()).equals(s1))
				return true;

		}
		return false;
	}

	private static String removeDuplicates(char[] charArray, int length) {
		int[] hash = getHash();
		int j = 0, i = 0;
		while (j < length && i < length) {

			while (j < length && hash[charArray[j]] == 1)
				j++;
			if(j<length) {
				hash[charArray[j]] = 1;
				if (i != j) {
					char temp = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = temp;
				}
			}
			i++;
			j++;

		}
		return String.valueOf(charArray, 0, i);
	}

	private static int[] getHash() {
		int[] hash = new int[256];
		Arrays.fill(hash, 0);
		return hash;
	}

	private static char findMaxCharactor(char[] charArray, int length) {
		int[] hash = getHash();
		char maxChar = ' ';
		for (int i = 0; i < length; i++) {
			hash[charArray[i]]++;
			if (hash[charArray[i]] > maxCount) {
				maxCount = hash[charArray[i]];
				maxChar = charArray[i];
			}
		}
		return maxChar;
	}
}
