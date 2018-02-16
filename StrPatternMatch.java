package syed.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StrPatternMatch {

	public static boolean patternMatch1(String str, String patt) {

		if (str == null || str.length() <= 0 || patt == null
				|| patt.length() <= 0)
			return false;

		if (str.length() < patt.length()
				|| (str.length() == patt.length() && !str.equals(patt)))
			return false;

		if (str.equals(patt))
			return true;

		int i = 0, j = 0, M = str.length(), N = patt.length();
		System.out.println("str: " + str + ", patt:" + patt);
		System.out.println(", M:" + M + ", N:" + N);
		while (i < (M - N + 1)) {
			int k = i;
			j = 0;
			while (j < (N - 1) && str.charAt(k) == patt.charAt(j)) {
				k++;
				j++;
			}
			System.out.println("i:" + i + ", k:" + k + ", j:" + j);
			if (j == (N - 1))
				return true;

			i++;
		}
		return false;
	}

	public static char firstNonRepeatChar(String str) {

		if (str == null || str.length() <= 0)
			return '\0';
		char[] arr = str.toLowerCase().toCharArray();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : arr) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
		}

		for (char c : arr) {
			if (map.get(c) == 1)
				return c;
		}
		return '\0';
	}

	private static Set<String> permutation(String prefix, String str) {
		System.out.println("prefix:" + prefix + ", str:" + str);
		Set<String> result = new HashSet<String>();
		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
			result.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				Set<String> tmp = permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));
				result.addAll(tmp);
			}
			System.out.println(">" + result.size());
		}
		return result;
	}

	public static Set<String> permuteUniqueCharWord(int len, char[] build,
			int pos, int mask[]) {
		System.out.println("build:" + String.valueOf(build) + ", pos:" + pos);
		// printMask(mask);
		Set<String> result = new HashSet<String>();
		if (pos == len) {
			String word = new String(build);
			// do what you need with each word here
			System.out.println("\t >>" + word);
			result.add(word);
			return result;
		}

		for (char c = 'a'; c <= 'z'; c++) {
			if (isCharMaskSet(mask, pos, c))
				continue;
			System.out.println("Setting " + c + " @ " + (pos + 1));
			build[pos] = c;
			mask[pos] = setCharMask(mask[pos], c);
			result.addAll(permuteUniqueCharWord(len, build, pos + 1, mask));
			mask[pos] = 0;
			System.out.println("@Done with " + c);
		}

		return result;
	}

	private static void printMask(int[] mask) {
		// TODO Auto-generated method stub
		int i = 0;
		for (int tmp : mask)
			System.out.print(" i:" + (i++) + " ; mask "
					+ Integer.toHexString(tmp) + " , ");
		System.out.print("\n");
	}

	private static boolean isCharMaskSet(int[] mask, int pos, char c) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pos; i++) {
			int tmp = (c - 'a');
			if ((mask[i] & (1 << tmp)) > 0) {
				// System.out.println("Char "+c+"("+Integer.toHexString(1 <<
				// tmp)+
				// ") already set for pos "+i+"; mask:"+Integer.toHexString(mask[i]));

				return true;
			}
		}
		return false;
	}

	private static int setCharMask(int mask, char c) {
		int tmp = c - 'a';
		return (mask | (1 << tmp));
	}

	private static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		int i = arr.length - 1, end = i;
		while (i >= 0) {
			System.out.println("i:" + arr[i] + ", end:" + arr[end]);
			if (arr[i] == ' ') {
				sb.append(str.substring(i + 1, end + 1) + " ");

				end = i - 1;
			}
			i--;
		}
		System.out.println("i:" + i + ", end:" + end);
		sb.append(str.substring(0, end));
		return sb.toString();
	}

	public static char[][] map = {
		{ '!' },
		{ ',' },
		{ 'a', 'b', 'c' },
		{ 'd', 'e', 'f' },
		{ 'g', 'h', 'i' },
		{ 'j', 'k', 'l' },
		{ 'm', 'n', 'o' },
		{ 'p', 'q', 'r', 's' },
		{ 't', 'u', 'v' },
		{ 'w', 'x', 'y', 'z' }
		};

	public static void permuteNumber(char[] arr, int pos) {
		System.out.println("arr:"+String.valueOf(arr)+", pos:"+pos);

		if(pos > arr.length)
			return;
		if(pos == arr.length) {
			System.out.println(">"+String.valueOf(arr));
			return;
		}
	
		for(int i=0; pos<= arr.length && i< (map[arr[pos]-'0'].length - 1); i++) {
			System.out.println("pos:"+pos+",i="+i+" : "+map[arr[pos]-'0'][i]);
			arr[pos] = map[arr[pos]-'0'][i];
			permuteNumber(arr, pos+1);
			System.out.println("Done "+i);
		}
		System.out.println("Return");
	}
	
	public static void main(String args[]) {
		// System.out.println("Result :" + patternMatch1("catmousecat",
		// "mose"));

		/*
		 * String str = "abcdcdab";
		 * System.out.println("First char non-repeating in "
		 * +str+" is "+firstNonRepeatChar(str));
		 */

		// System.out.println(permutation("", "ABCD"));
		// System.out.println(">"+permutateStr(3));

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int len = 3;

		/*
		 * Set<String> result = permuteUniqueCharWord(len, new char[len], 0, new
		 * int[len]); System.out.println("Size: "+result.size()+"; \n "+result);
		 */
		
		/*String str = "Interviews are awesome!";
		System.out.println("str is " + str + "\n Reverse is : "
				+ reverseString(str));
				*/
		String number = "2456";
		System.out.println("Permute number :"+number+", len:"+number.toCharArray().length);
		char n[] = {'2', '4', '5', '6'};
		permuteNumber(n, 0);
	}
}
