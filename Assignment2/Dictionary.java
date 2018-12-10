package Assign2SortWords;



import java.io.*;

public class dictionary {
	/*bubble_sort function takes unsorted array of strings and return the sorted array of strings*/
	//this method uses bubble sort
	static String[] bubble_sort(String words[])
	{
		int p;
		for(int i=0;i<words.length-1;i++)
		{
			p=i+1;
			while(p<words.length-i)
			{
				if(words[i].compareTo(words[p])>0)
				{
					String st=words[i];
					words[i]=words[p];
					words[p]=st;
				}
				p++;
			}
		}
		return words;
	}
	/*main function reads all dictionary and keywords files and calls sort function to sort them and then matches keywords in dictionary and write output in output file*/
	public static void main(String args[])throws IOException
	{
		File f1=new File("C:\\Users\\Kavita\\Desktop\\HW@\\HW2-dictionary.txt");
		if(!f1.exists())		//check if file1 exists
		{
			System.out.print("file not found");
			System.exit(0);
		}
		File f2=new File("C:\\Users\\Kavita\\Desktop\\HW@\\HW2-keywords.txt");
		if(!f2.exists())		//check if file2 exists
		{
			System.out.print("file not found");
			System.exit(0);
		}
		//file is read by BufferedReader and written by BufferedWriter
		FileReader fr1=new FileReader(f1);
		BufferedReader bf1=new BufferedReader(fr1);
		FileReader fr2=new FileReader(f2);
		BufferedReader bf2=new BufferedReader(fr2);
		File f3=new File("C:\\Users\\Kavita\\Desktop\\HW@\\HW2-output.txt");
		FileWriter fw=new FileWriter(f3);
		BufferedWriter bw=new BufferedWriter(fw);
		String str;
		int i=0;
		String dict[]=new String[16000];
		String kwrd[]=new String[84];
		while((str=bf1.readLine())!=null)
		{
			dict[i++]=str;		//writing dictionary file in dict array
		}
		dict=bubble_sort(dict);		//call bubble sort
		i=0;
		while((str=bf2.readLine())!=null)
		{
			kwrd[i++]=str;		//writing keyword file in kwrd array
		}
		kwrd=bubble_sort(kwrd);		//call bubble sort
		bf1.close();
		bf2.close();
		int count=0;
	outer : for(i=0;i<kwrd.length;i++)
		{
			for(int j=0;j<dict.length;j++)
			{
				if(kwrd[i].compareTo(dict[j])==0)		//comparing keywords with dictionary words
					continue outer;
			}
			bw.write("Keyword not found : "+kwrd[i]);
			count++;
			bw.newLine();
		}
		bw.newLine();
		bw.write("number of keywords not found = "+count);
		bw.close();
	}
}


