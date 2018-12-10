package Assignment1;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountGrade {
	
	public static void main(String[] args) throws IOException,Exception {
	
		File file=new File("C:\\Users\\Kavita\\Desktop\\HW1\\HW1-output-16103041.txt");
		BufferedReader bf=new BufferedReader(new FileReader(file));
		String str=bf.readLine();
		str=bf.readLine();
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
		
		int cnt=0,max=-100;
		float total=0;
		int gradecnt[]=new int[5];
		
		
	
		while((str =bf.readLine())!=null) {
			String s[]=str.split("\\s+");
			total=total+Integer.parseInt(s[17]);
			cnt++;
		
			if(max<Integer.parseInt(s[16])) {
				max=Integer.parseInt(s[16]);
			}
			
			//COUNTING GRADES
		    if(s[18].equals("A"))
		    	gradecnt[0]++;
		    else if(s[18].equals("B"))
		    	gradecnt[1]++;
		    else if(s[18].equals("C"))
		    	gradecnt[2]++;
		    else if(s[18].equals("D"))
		    	gradecnt[3]++;
		    else
		    	gradecnt[4]++;
		}
		//APPEND TO RESULT FILE
		String s="\n\nAverage total point percent of all students:";
		s=s + total/cnt +"\n" +"Number of A's : " + gradecnt[0]+"\n";
		s=s+"Number of B's : " + gradecnt[1]+"\n";
		s=s+"Number of C's : " + gradecnt[2]+"\n";
		s=s+"Number of D's : " + gradecnt[3]+"\n";
		s=s+"Number of F's : " + gradecnt[4]+"\n";
		s=s+"Maximum points = " + max;
		
		bw.write(s);
		bw.close();
		
		bf.close();
	}
}
