public class FactorialMain {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.print("Factorial of "+ i +": " + "1");
			for(int j=2; j<=i; j++) {
				System.out.print("*" + j);
			}
			System.out.println("=" + factorial(i));
		}
	}
	private static long factorial(final int n) {
		if(n<=1) return n;
		else return factorial(n-1)*n;
	}
}