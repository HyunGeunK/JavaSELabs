package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String name;
	private String studentId;
	private String major;
	private int grade;
	
	public Student() {} ///기본생성자가 매개변수가있는 생성자가 있을땐 무조건 기본생성자를 만들어줘야하는데 아닐경우는 자동생성 확인

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		if (grade >= 1 && grade <= 4) {
			this.grade = grade;;
	}	else {
		throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
	}
	
}
}