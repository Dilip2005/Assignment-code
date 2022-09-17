package basiccode;

public class Resver {

	public static void main(String[] args) {
		String text="I am a software tester";
		String splitText[];
		splitText=text.split(" ");
		String oddIndexWords[]=new String[(splitText.length)];
		String evenIndexWords[]=new String[(splitText.length)];

		for(int i=0;i<splitText.length;i++)
		{
			if(i%2==0) {
				oddIndexWords[i]=splitText[i];
				System.out.print(oddIndexWords[i]+" ");
			}
			else
			{
				evenIndexWords[i]=splitText[i];
				//System.out.print(evenIndexWords[i]+" ");
				char[] evencharacter=evenIndexWords[i].toCharArray();
				for(int j=evencharacter.length-1;j>=0;j--)
				{
					System.out.print(evencharacter[j]);
				}
				System.out.print(" ");
			}
			
			
			
			
			
	
		}
	}

}
