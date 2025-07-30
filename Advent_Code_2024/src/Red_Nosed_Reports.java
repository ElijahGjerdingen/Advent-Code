import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Red_Nosed_Reports {

	public static void main(String[] args) throws FileNotFoundException {
		String reportStrng;
		List<Integer> reportInt = new ArrayList<>();
		boolean isSafe;
		Scanner input = new Scanner(new File("RNRinput.txt"));
		while(input.hasNextLine())
		{
			reportStrng = input.nextLine();
			reportInt = getEachReport(reportStrng);
			System.out.println(reportInt + "\n");
		}
		
		

	}

	private static List<Integer> getEachReport(String reportStrng) 
	{
		reportStrng = reportStrng.replaceAll("\\s", "");
		char[] charList = reportStrng.toCharArray();
		List<Integer> intList = new ArrayList<>(charList.length);
		for(int i = 0; i < charList.length; i++)
		{
			intList.add(Character.getNumericValue(charList[i]));
		}
		return intList;
	}

}
