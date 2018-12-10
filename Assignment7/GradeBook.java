package Assignment7;


public class GradeBook {
	String student[] = new String[5]; // String Array to hold five students names
	char letterGrades[] = new char[5]; // an array of five characters to hold five students letter grades                                 
	double score[][] = new double[5][4];//five arrays of four doubles each to hold each students set of test scores
	
	//Grade of student
	void setLetterGrades()
	{
		int i;
		for(i=0 ; i<5 ; i++)
		{
			double avg = getAverageTestScore(student[i], i);
			if(avg <= 100 && avg>=90)
				letterGrades[i] = 'A';
			else if(avg >= 80 && avg <= 89)
				letterGrades[i] = 'B';
			else if(avg >= 70 && avg <= 79)
				letterGrades[i] = 'C';
			else if(avg >= 60 && avg <= 69)
				letterGrades[i] = 'D';
			else
				letterGrades[i] = 'F';
			
 		}
	}
	//function which return student name
	public String getName(int i)
	{
		return student[i];
	}
	//function for get the average test score
	double getAverageTestScore(String stud , int i)
	{
		int j;
		double avg=0;
		for(j=0;j<4;j++)
			avg+=score[i][j];
		avg=avg/4;
		return avg;
	}
	
	char getLetterGrade(int nthStudent)
	{
		return letterGrades[nthStudent];
	}
	
	void displayStudentDetails()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Name of Student " + student[i]);
			System.out.println("scores of the student "+score[i][0] +" "+score[i][1] +" " +score[i][2] +" "+score[i][3]);
			System.out.println("Grade: " + getLetterGrade(i));
			System.out.println();
		}
	}
}

