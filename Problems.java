package syed.example;

public class Problems {

	public static int flipSign(int a) {
		
		return (~a + 1);
	}
	
	
	public static int negate(int a ) {
		int neg = 0;
		int sign = a<0?1:-1;
		while(a !=0) {
			neg += sign;
			a+= sign;
		}
		return neg;
	}
	
	public static void solveOperationWithAddOnly(int a, int b) {
		int tmp = flipSign(b);
		int tmp2 = negate(b);
		System.out.println(""+a+" is "+Integer.toBinaryString(a));
		System.out.println(""+b+" is "+Integer.toBinaryString(b));
		System.out.println("tmp "+tmp+" is "+Integer.toBinaryString(tmp));
		System.out.println("tmp2 "+tmp2+" is "+Integer.toBinaryString(tmp2));
		System.out.println("Add : "+(a+b));
		System.out.println("Subtract : "+(a+ flipSign(b)));
	}
	
	public static void main(String[] args) {
		solveOperationWithAddOnly(10345, 345);
	}
}
