package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentId("20201485");
		student.setName("김민수");
		student.setMajor("컴퓨터공학");
		
		try {
			student.setGrade(3);
			System.out.println(student.getName() + "/" + student.getMajor() + "/" + student.getGrade() + "학년");
			
			System.out.println("5학년으로 변경");
			student.setGrade(5);
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
