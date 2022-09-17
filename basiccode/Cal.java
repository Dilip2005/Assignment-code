package basiccode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cal {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String word[]=text.split(" ");
		Set<String> uniqueWords=new TreeSet<String>();
		for(int i=0;i<word.length;i++)
		{
			uniqueWords.add(word[i]);
		}
		
		//displaying as string
		System.out.println("After removing duplicates the given text becomes :");
		for (String unique : uniqueWords) {
			System.out.print(unique+" ");
		}
		
		}
	

}
