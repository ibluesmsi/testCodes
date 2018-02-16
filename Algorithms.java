package syed.example;

public class Algorithms {

	public static boolean rabinKarpSearch(String str, String pattern) {
		boolean result = false;
		int m = pattern.length();
		
		if(pattern.length() >= str.length()) {
			System.out.println("Error!! Cannot find "+pattern+" in "+str);
			return false;
		}
		// Pre-compute input pattern
		long hash = hashStr(pattern);
		
		long strHash = hashStr(str.substring(0, m));
		
		for(int i=0; i < (str.length()-m-1); i++) {
			if(hash == strHash && check(str, pattern, (i-1))) {
				
				System.out.println("Found "+pattern+" @ "+(i-1));
				return true;
			}
			strHash = hashStr(str.substring(i, i+m));
		}
		System.out.println("Cannot find "+pattern+" in "+str);
		
		return result;
	}
	
	public static long hashStr(String str) {

		int factor = 128;
		int modo = 101;
		long hash=0;
		for(char c: str.toCharArray()) {
			hash = ((factor*hash) + c) % modo;
		}
		//System.out.println(str+" ::: "+hash);
		return hash;
	}
	
	/*public static boolean naiveSearch(String str, String pattern) {		
		return str.contains(pattern);
	}*/
	
	public static boolean check(String str, String pattern, int idx) {
		for(int i=0; i< pattern.length(); i++) {
			if(pattern.charAt(i) != str.charAt(idx+i))
				return false;
		}
		return true;
	}
	public static boolean naiveSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i+j) != pat.charAt(j)) {
                	//System.out.print("\n");
                    break;
                }
            }
            if (j == M) {
            	System.out.println("\nFound "+pat+" @ "+i);
            	return true;            // found at offset i
            }
        }
        return false;                            // not found
    }

	
	public static void main(String[] args) {
		//System.out.println("Finding 'are' in 'doe asdsad dasdsad dsrebdfbd fdsfds are hearing me'");
		String str = "doe asdsad da342fddbvvbvbbvcdfdsfdsfdsfdsfdsgghd  o egjrns jds ;ld f;bjlbhhbnjfdgdfgdfgfgfdh74457fjhfgghfhfghghy455rydhgfururthdhy45ydf brt df [bpem j0fvj-j 8yvdshdh-ij0mvj0dsjivdsdsf ;lk dsf dsmfd;lf sd;f ;sd;f;sdk fmsdmkf dskm fdsf;dskl;fmkdsl flk;sdmlfk dslfdsf sdklm;bcvbsdfdggjjgbxdftrtgedfbsdsad dsrebdfbd fdsfds are hearing me";
		String pattern = "are";
		long startTime = System.currentTimeMillis();
		boolean result = rabinKarpSearch(str, pattern);
		long endTime = System.currentTimeMillis();
		System.out.println("rabinKarpSearch >>"+result+", time Taken:"+(endTime-startTime)+"\nstartTime:"+startTime+" endTime:"+endTime);
		
		startTime = System.currentTimeMillis();
		result = naiveSearch(str, pattern);
		endTime = System.currentTimeMillis();
		System.out.println("naiveSearch >>"+result+", time Taken:"+(endTime-startTime)+"\nstartTime:"+startTime+" endTime:"+endTime);
	}
}
