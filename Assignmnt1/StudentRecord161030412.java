package Assignment1;



import java.io.BufferedReader;
import java.io.*;


public class StudentRecord161030412{
	 
	String print(String s[],int l) {
	
		int total=0;
		String res=s[0] +"  ";
				for(int i=1;i<l;i++) {
			if(Integer.parseInt(s[i])<10) {
				res=res+" " +s[i] + "  ";
			}
			else res=res+s[i]+"  ";
			if(i>=2 && i<12) {
			
				total+=Integer.parseInt(s[i]);
			}
			
			if(i==11)
				res=res+total+"  ";
		}
		total=total+Integer.parseInt(s[1])+Integer.parseInt(s[12])+ Integer.parseInt(s[13])+ Integer.parseInt(s[14]);
		res=res+total+ "  ";
		
		int percentage= getPercent(total-Integer.parseInt(s[14]));
		res=res + percentage+"  ";
		
		res=res + grade(percentage) + "\n";
		return res;
	}
	
     int getPercent(int marks) {
    	
		float percentage= (float)(((float)marks/420.0)*100.0);
		float y=percentage - (int)percentage;
		int result;
		if(y>=0.5) {
			result=(int)percentage+1;
		}
		else result=(int)percentage;
		return result;
	}
	
	
    String grade(int percentage) {
   
		if(percentage >=90) 
			return "A";
		else if(percentage>=78)
			return "B";
		else if(percentage>=62)
			return "C";
		else if(percentage>=46)
			return "D";
		else return "E";
	}
	
	
	public static void main(String args[]) throws IOException,Exception{
		
		StudentRecord161030412 record=new StudentRecord161030412();
		
	
		File input=new File("C:\\Users\\Kavita\\Desktop\\HW1\\HW1-data.txt");
		BufferedReader bf=new BufferedReader(new FileReader(input));
		File result=new File("C:\\Users\\Kavita\\Desktop\\HW1\\HW1-output-16103041.txt");
		
		
		if(!input.exists()) {
			System.out.println(" ERROR!!! INPUT FILE DOESNOT EXISTS");
		}
		

		if(!result.exists()) {
			result.createNewFile();
		}
	

		FileWriter fileWriter =new FileWriter(result);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String str;
		String pre="Stdnt ID  Ex  ---------------Assignments------------  Tot  Mi Fin  CL  Pts Pct  Gr \n";
		String pre2="--------  --  --------------------------------------  ---  -- ---  --  --- ---  -- \n";
		bufferedWriter.write(pre);
		bufferedWriter.write(pre2);
		
		
		while((str =bf.readLine())!=null) {
			
			String s[]=str.split("\\s+");
		
			String res=record.print(s,s.length);
			bufferedWriter.write(res);
			bufferedWriter.newLine();
		}
		
		bufferedWriter.close();
		bf.close();
	}
}
