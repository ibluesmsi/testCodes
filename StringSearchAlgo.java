package syed.example;

public class StringSearchAlgo {

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return 0;
		int h = haystack.length();
		int n = needle.length();

		if (n > h)
			return -1;
		if (n == 0)
			return 0;
		int[] next = getNext(needle);
		int i = 0;
		while (i <= h - n) {
			int success = 1;
			for (int j = 0; j < n; j++) {
				if (needle.charAt(0) != haystack.charAt(i)) {
					success = 0;
					i++;
					break;
				} else if (needle.charAt(j) != haystack.charAt(i + j)) {
					success = 0;
					i = i + j - next[j - 1];
					break;
				}
			}
			if (success == 1)
				return i;
		}
		return -1;
	}

	public static void dumpNext(int[] next) {
		System.out.print("Next::");
		for(int i=0; i<next.length;i++) {
			System.out.print(next[i]+",");
		}
		System.out.print("\n");
	}
	// KMP
	public static int[] getNext(String needle) {
		int[] next = new int[needle.length()];
		next[0] = 0;
		for (int i = 1; i < needle.length(); i++) {
			
			int index = next[i - 1];
			System.out.println("i:"+i+", index:"+index+", needle:"+needle);
			dumpNext(next);
			while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
				index = next[index - 1];
			}
			System.out.println(" >> index:"+index+", needle(index):"+needle.charAt(index)+", needle(i):"+needle.charAt(i));
			if (needle.charAt(index) == needle.charAt(i)) {
				next[i] = next[i - 1] + 1;
			} else {
				next[i] = 0;
			}
		}
		dumpNext(next);
		return next;
	}

	public static void main(String[] args) {
		String str = "sdsadasfgsgsdsdfsabababcafddsfds";
		System.out.println("str:"+str);
		System.out.println("is abbc present:"+strStr(str, "abababca"));
	}
}
