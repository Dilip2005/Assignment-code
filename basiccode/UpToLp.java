package basiccode;

public class UpToLp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "changeme";	
		//String upperCase = str.toUpperCase();
		char[] charArray = str.toCharArray();		
	//	int length = charArray.length;
		
		for (int i = 0; i < charArray.length; i++) {			
			if (i%2 == 0) {	//c h a n g e m e			
				charArray[i] = Character.toUpperCase(charArray[i]);					
			} 			
		}
		for (int i = 0; i < charArray.length; i++)  {
			System.out.print(charArray[i]);
		}
	}

}



