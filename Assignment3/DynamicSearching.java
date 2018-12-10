package Assignment3;


import java.io.*;
import java.util.*;
public class DynamicSearching 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		//Opening HW3-unsorted-keywords.txt file
		File file=new File("C:\\Users\\Kavita\\Desktop\\Assignment3\\HW3-unsorted-keywords.txt");
		
		int noOfKeywords=0;				//Variable to count no of keywords in the file
		
		//Scanning file in sc
		Scanner sc=new Scanner(file);
		
		//counting no. of keywords in file
		while(sc.hasNextLine())
		{
			sc.nextLine();
			noOfKeywords++;
		}
		
		//Creating arrayKeywords of size noOfKeywords
		String[] arrayKeywords=new String[noOfKeywords];
		int i=0;
		sc.close();
		
		sc=new Scanner(file);
		//Storing keywords from file to arrayKeywords
		while(sc.hasNextLine())
		{
			arrayKeywords[i]=sc.nextLine();
			i++;
		}
		sc.close();
		
		//Function call to sort arrayKeywords
		sortArray(arrayKeywords);
		
		//Opening input file HW3-input-code.cpp
		file=new File("C:\\Users\\Kavita\\Desktop\\Assignment3\\HW3-input-code.cpp");
		
		sc=new Scanner(file);	//file scanned
		
		//Output file "HW3-output-16103041.txt" opened  
		PrintWriter fout=new PrintWriter("C:\\Users\\Kavita\\Desktop\\Assignment3\\HW3-output-16103041.txt");
		
		int lineCount=0,kywdCount=0;		//Counter variables
		while(sc.hasNextLine())
		{
			boolean isFound=false;			
			lineCount++;
			String[] line=sc.nextLine().split("//");		//Storing each line in "line" excluding comments
			
			//Splitting line into words
			String[] arrayLine=line[0].split("\\t|,|;|\\.|!|-|:|\\[|\\]|\\(|\\)| +|\\*|/");
			
			//Formatting string to write in output file
			String str=String.format("Line %3d: ",lineCount);
			
			for(String a: arrayLine)
			{
				boolean isKeyword=keywordSearch(arrayKeywords, a);		//Checking whether keyword or not
				if(isKeyword)
				{
					isFound=true;
					str+=String.format("%12s(%d)",a,line[0].indexOf(a));	//Adding searched keyword in str
					kywdCount++;
				}
			}
			if(isFound)				//If any keyword found, write string in file
				fout.println(str);
		}
		
		fout.println();
		fout.println("Number of keywords found = "+kywdCount);
		sc.close();
		fout.close();
		System.out.println("Completed Successfuly");
	}
	//Function for sorting array
	public static void sortArray(String[] ar)
	{
		int i,j;	
		boolean chk=true;
		int n=ar.length;
		for(i=0;i<n-1&&chk;i++)					//Bubble sort
		{
			chk=false;
			for(j=0;j<n-i-1;j++)
			{
				if(ar[j].compareTo(ar[j+1]) > 0)
				{					
					String tmp=ar[j+1];			//words swapped
					ar[j+1]=ar[j];
					ar[j]=tmp;
					chk=true;
				}
			}
		}
		
	}
	//Function to search keyword in dictionary
	public static boolean keywordSearch(String[] a, String x) 
	{
	    int low = 0;
	    int high = a.length - 1;
	    int mid;

	    while (low <= high) 
	    {
	        mid = (low + high) / 2;

	        if (a[mid].compareTo(x) < 0) 
	            low = mid + 1;
	        else if (a[mid].compareTo(x) > 0) 
	            high = mid - 1;
	        else 
	            return true;		//returns true if keyword found
	    }
	    return false;				//returns false if keyword not found
	}
}
