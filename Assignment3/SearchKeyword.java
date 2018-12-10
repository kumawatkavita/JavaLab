package Assignment3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class SearchKeyword {
	
	//UTILITY FUNCTION TO SORT THE STRINGS USING SELECTION SORT
	 static void sortStringArr(String arr[],int n) {
		 
			for(int i=0;i<n;i++) {
				int j;
				int min=i;
				for(j=i+1;j<n;j++) {
					if(arr[j].compareTo(arr[min])<0) {
						min=j;
					}
				}
				String temp=arr[min];
				arr[min]=arr[i];
				arr[i]=temp;
			}
		}
	 
	 /*SEARCH FUNCTION TO SEARCH THE KEYWORD IN DICTIONARY.*/
	 //BINARY SERACH IS USED TO REDUCE THE COMPLEXITY OF SEARCHING IN THE SORTED ARRAY. 
	 static int search(String key,String arr[],int beg,int end) {
	
		  if(beg<end) {
			 int mid=(beg+end)/2;
			 if(arr[mid].equals(key)) {
				 return 1;
			 }
			 else if(arr[mid].compareTo(key)>0) {
				 return search(key ,arr, beg, mid);
			 }
			 else return search(key, arr, mid+1, end);
		 }
		 return 0;
	 }
	
	public static void main(String[] args) throws IOException,Exception{
		
		//THE CODE AND KEYWORD FILE OBJECT TO READ DATA.
		 File keywords=new File("C:\\Users\\Kavita\\Desktop\\Assignment3\\HW3-unsorted-keywords.txt");
		 File code=new File("C:\\Users\\Kavita\\Desktop\\Assignment3\\HW3-input-code.cpp");
		
		 
		 //CHECK FOR SUCCESSFUL OPEN
		 if(!keywords.exists()) {
			 System.out.print(" ERROR INPUT FILE OF KEYWORDS DOSNOT EXIST!!");
			 return;
		 }
		 if(!code.exists()) {
			 System.out.print(" ERROR INPUT FILE CODE DOSNOT EXIST!!");
			 return;
		 }
		
		 
		 //OUTPUT FILE TO WRITE THE KEYWORDS FOUND WITH THEIR LINE NUMBER AND INDEX
			File output=new File("C:\\Users\\Kavita\\Desktop\\Assignment3\\out.txt");
			
			//TO CREATE AN OUTPUT FILE IN CASE FILE DOESNOT EXISTS.
			if(!output.exists()) {
				output.createNewFile();
			}
		 
		 
		 BufferedReader bfr=new BufferedReader(new FileReader(keywords));
		 BufferedReader bfr2=new BufferedReader(new FileReader(code));
		 BufferedWriter bwr=new BufferedWriter(new FileWriter(output));
		 
		 //TO COUNT THE NUMBER OF LINE IN THE INPUT FILE
		 LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(keywords));
	     lineNumberReader.skip(Long.MAX_VALUE);
	     int words = lineNumberReader.getLineNumber();
	     lineNumberReader.close();
	 
	     //DYNAMIC ALLOCATION OF ARRAY
	     String keyarr[]=new String[words];
	     
	     for(int i=0;i<words;i++) {
	    	 keyarr[i]=bfr.readLine();
	     }
	     
	     
	     //SORT THE KEYWORDS ARRAY
         sortStringArr(keyarr, words);
         
         String line,constLine;int count=0;int lineNumber=1;
         
         //READ THE INPUT CODE FILE LINE BY LINE AND SEARCH IN THE KEYWORD ARRAY
         while((line=bfr2.readLine())!=null) {
        	 
        	 constLine=line;
        	 int f=0;int index=0;
        	 
        	 //REPLACING SPECIAL CHARACTERS TO SEPARATE WORDS
        	 line=line.replace("(", " ");
        	 line=line.replace("*"," ");
        	 line=line.replace(",", " ");
        	 line=line.replace(";"," ");
  
        	 //SPLIT BY MULTIPLE SPACES
        	 String[] arr=line.split("\\s+");
  
        	 for(int i=0;i<arr.length;i++) {
        		
        		 //CHECK FOR COMMENTS
        		 if(arr[i].indexOf("//")!=-1)break;
        		 
        		 //SEARCH USING BINARY SEARCH
        		int found=search(arr[i],keyarr,0,words);
        		 if(found==1) {
        			 index=constLine.indexOf(arr[i],index);
        			 if(f==0) {
	        			 count++;
	        		     f=1;
	        			 String stro="Line ";stro+=lineNumber +":";
	        		     bwr.write(stro);
        			 }
        			 String strw=" ";strw+= arr[i] + "(" + index + ")";
        			 bwr.write(strw);
        			 
        		 }
        	 }    			
        	lineNumber++;
        	if(f!=0) {
        	   bwr.newLine();
        	}
         }
         String res=" Number of keywords found::";
         res+=count;
         bwr.write(res);
         
         //CLOSING THE FILES.
         bwr.close();
         bfr.close();
		 bfr2.close();
	}
}


