package syed.example;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Gquestion01 {

	public static String process(int mainArray[], int filter[]) {
		StringBuffer buff = new StringBuffer();
		int idx = 0, count = 0;
		int start = mainArray[count];
		int end = 0;
		while (count < mainArray.length) {
			System.out.println("count:" + count + ", arr:" + mainArray[count]
					+ ", idx:" + idx);
			if (idx < filter.length && filter[idx] == mainArray[count]) {
				end = mainArray[count - 1];
				// if(start != mainArray[0])
				// start = mainArray[count+1];
				buff.append(start + "-" + end + ",");
				idx++;
				start = mainArray[count + 1];

			}
			count++;
		}
		end = mainArray[count - 1];
		buff.append(start + "-" + end);
		return buff.toString();
	}

	public static boolean isMatching(char value1, char value2) {
		System.out.println("Matching " + value2 + " and " + value1);
		if (value1 == '}' && value2 == '{')
			return true;
		if (value1 == ')' && value2 == '(')
			return true;
		if (value1 == ']' && value2 == '[')
			return true;
		return false;
	}

	public static boolean checkExpression(String exp) {
		Stack<String> stack = new Stack<String>();

		char[] expArray = exp.toCharArray();
		for (char str : expArray) {
			if (str != '(' && str != ')' && str != '{' && str != '}'
					&& str != '[' && str != ']')
				continue;
			// System.out.println("Process - "+str);
			if (str == '(' || str == '{' || str == '[') {
				// System.out.print("Increasing from "+stack.size());
				stack.push(Character.toString(str));
				// System.out.println(" to "+stack.size()+"; Add "+str);
				dumpQueue(stack);
			} else if (str == ')' || str == '}' || str == ']') {
				if (stack.isEmpty())
					return false;
				dumpQueue(stack);
				if (isMatching(str, stack.peek().charAt(0))) {
					// System.out.print("Decreasing queue from "+stack.size());
					stack.pop();
					// System.out.println(" to "+stack.size());
				} else {
					System.out.println("Missing start braces for " + str);
					return false;
				}
			}

		}
		System.out.println("Final Queue: " + stack.size());
		if (!stack.isEmpty())
			return false;
		return true;
	}

	public static int charToIndex(char c) {
		if (c >= 'A' && c <= 'Z')
			return (c - 'A');
		else if (c >= 'a' && c <= 'z')
			return c - 'a';
		return -1;
	}

	public static void dumpQueue(Stack<String> queue) {
		Iterator<String> iter = queue.iterator();
		System.out.print("**** ");
		while (iter.hasNext()) {

			System.out.print(iter.next());
		}
		System.out.println("");
	}

	public static void populateTable(Hashtable<Character, Integer> table,
			String str) {
		char[] array = str.toCharArray();
		for (char c : array) {

			if (table.get(c) != null) {
				table.put(c, (Integer) table.get(c) + 1);

			} else
				table.put(c, 1);
		}
	}

	public static char findFirstRepeatChar(String str) {
		char[] array = str.toCharArray();

		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		populateTable(table, str);
		for (char c : array) {
			if (table.get(c) != null && table.get(c) > 1)
				return c;
		}
		return 0;
	}

	public static char findFirstNonRepeatChar(String str) {
		char[] array = str.toCharArray();

		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		populateTable(table, str);
		for (char c : array) {
			if (table.get(c) != null && table.get(c) == 1)
				return c;
		}
		return 0;
	}

	public static char findMostRepeatChar(String str) {
		char[] array = str.toCharArray();
		int tablSize = 0;
		char result = 0;
		int maxCount = 0;
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		populateTable(table, str);
		tablSize = table.size();
		Enumeration<Character> keys = table.keys();
		while (keys.hasMoreElements()) {
			Character cc = keys.nextElement();
			if (table.get(cc) > 1 && table.get(cc) > maxCount) {
				maxCount = table.get(cc);
				result = cc;
			}
		}
		return result;
	}

	public static String reverseWord(String str) {
		char[] src = str.toCharArray();
		char[] dest = new char[str.length()+1];
		int destIdx = 0;
		int start;
		int end = src.length - 1;

		System.out.println("end:" + end + ", length:" + src.length);
		for (int i = src.length - 1; i >= 0; i--) {
			System.out.println(">>" + src[i] + " , " + i);
			if (src[i] != ' ' && i > 0) {
				continue;
			}
			start = (i==0)?i:(i + 1);
			for (int t = start; t <= end; t++) {
				System.out.println(t + "::" + src[t] + "  --> " + destIdx);
				dest[destIdx++] = src[t];
			}
			dest[destIdx++] = ' ';
			end = i - 1;
		}

		return new String(dest);
	}
	
	static int digitToInt(char c) {
		switch(c) {
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		}
		return -1;
	}
	
	static int strToInt(String str) {
		char[] array = str.toCharArray();
		int num=0, digit = 1;
		boolean isNegative = false;
		
		for(int i = array.length-1; i >= 0; i--) {
			if(array[i] == '-') {
				isNegative = true;
				continue;
			}
			
			int tmp = digitToInt(array[i]);
			if(tmp == -1) return -1;
			System.out.println("digit:"+digit+", val:"+tmp);

			num += (tmp*digit);
			digit *= 10;
		}
		
		return (isNegative)?(num*-1):num;
	}

	public static void main(String[] args) {
		/*
		 * int arr[] = new int[50]; for(int i=0; i< arr.length; i++) { arr[i] =
		 * i; System.out.print(arr[i]+","); } System.out.print("\n"); int
		 * filter[] = {10, 30, 45};
		 * 
		 * String result = process(arr, filter);
		 * System.out.println("Result :: "+result);
		 */

		/*
		 * String expression = "[()]{}{[())]()}";
		 * System.out.println("expression :"
		 * +expression+", Result :: "+checkExpression(expression)); expression =
		 * "[()]{}{[(())]()}";
		 * System.out.println("expression :"+expression+", Result :: "
		 * +checkExpression(expression));
		 */

		/*
		 * String str = "abcdabbaa";
		 * System.out.println("Str:"+str+",\n first non-repeat char:"
		 * +findFirstNonRepeatChar(str));
		 * 
		 * System.out.println(" first repeat char:"+findFirstRepeatChar(str));
		 * System.out.println(" most repeat char:"+findMostRepeatChar(str));
		 */
		String src = "Hello World!";
		//String result = reverseWord(src);
		//System.out.println(src + "  --->  " + result);
		//Integer.
		String str1 = "545439787";
		System.out.println("str:"+str1+", toInt:"+strToInt(str1)+", Max:"+Integer.MAX_VALUE);
	}
}
