import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Two_lists {
	public static void main(String[] args)
	{
		boolean isLeft = true;
		boolean isRight = false;
		int distance = 0;
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		//Creating the input file as a scanner to add values to unsorted single list
		try {
			Scanner input = new Scanner(new File("input.txt"));
			while (input.hasNextInt())
			{
				/* Runs through the total inputs putting locations from the left and right 
				 * side of the file in separate arrays so that they can be compared
				 */
				if(isLeft == true)
				{
					leftList.add(input.nextInt());
					isLeft = false;
					isRight = true;
				}
				else if(isRight == true)
				{
					rightList.add(input.nextInt());
					isRight = false;
					isLeft = true;
				}
			}
			//Printing lists unsorted and sorted to check they are filling correctly
			System.out.println();
			System.out.println(leftList.toString());
			System.out.println();
			System.out.println(rightList.toString());
			input.close();
			Collections.sort(leftList);
			Collections.sort(rightList);
			System.out.println();
			System.out.println(leftList.toString());
			System.out.println();
			System.out.println(rightList.toString());
			System.out.println();
			int location = 0;
			//Iterating the lists to get total distance
			while(location < leftList.size())
			{
				if(leftList.get(location) <= rightList.get(location))
				{
					distance += rightList.get(location) - leftList.get(location);
					location++;
					System.out.print(distance + ", ");
				}
				else
				{
					distance += leftList.get(location) - rightList.get(location);
					location ++;
					System.out.print(distance + ", ");
				}
			}
			System.out.println();
			System.out.println();
			System.out.println("Total is: " + distance + "\n");
			//Second part of day one prompt, find the similarity score of the two lists (left value * right occurrences = score for index)
			System.out.println(leftList.toString() + "\n");
			int leftLoc = 0;
			int simScore = 0;
			while(leftLoc < leftList.size())
			{
				int rightLoc = 0;
				int valueStoreLeft = leftList.get(leftLoc);
				while(rightLoc < rightList.size())
				{
					int valueStoreRight = rightList.get(rightLoc);
					if(rightList.contains(leftList.get(leftLoc)) && rightList.get(rightLoc).equals(leftList.get(leftLoc)))
					{
						simScore += leftList.get(leftLoc);
						rightLoc++;
						System.out.print(simScore + ", ");
					}
					else
					{
						rightLoc++;
					}
				}
				leftLoc++;
			}
			System.out.println("\nTotal Similarity Score = " + simScore);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
