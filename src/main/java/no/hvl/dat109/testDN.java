package no.hvl.dat109;

public class testDN {

	public static void main(String[] args) {

		int n = 1234567890;

		String s = Integer.toString(n).substring(0, 4);
		int m = Integer.parseInt(s);

		System.out.println(m);

	}

}
