package Assignment7;


import java.util.Scanner;
public class GradeBookTest {
private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		GradeBook object = new GradeBook();
		
		//we can also use set methods here
		System.out.println("Enter Name of the 5 students");
		for(int i=0;i<5;i++)
			object.student[i] = input.nextLine();
			
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter Marks of " + object.getName(i));
			for(int j=0;j<4;j++)
			{
				System.out.println("enter scores in Subject " +(j+1));
				object.score[i][j] = input.nextDouble();
				try
				{
				//check for the entered marks if not in range 0-100 throw exception
					if(object.score[i][j]<0 || object.score[i][j] >100)
						throw new ArithmeticException("Invalid Marks");
				}
				catch(ArithmeticException e)
				{
					System.out.println("Exception " +e.getMessage());
					object.score[i][j] = input.nextDouble();
				}
			}
		}
						
		//set the letter grade of every student
		object.setLetterGrades();
			
		//display the data of student 
		object.displayStudentDetails();
	}
}

