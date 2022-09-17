package basiccode;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "madam";
		String rev = "";
		
		for (int i = str.length()-1; i >= 0 ; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println("Reversed string is " + rev);
		
		if (str.equalsIgnoreCase(rev)) {
			System.out.println("It is a Palindrome");
			
		} else {
			System.out.println("Not a Palindrome");
		}
	}

}
