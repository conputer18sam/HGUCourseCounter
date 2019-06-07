package edu.handong.analysis.datamodel;

public class Course {
	
	private String studentId;
	private String yearMonthGraduated;
	private String firstMajor;
	private String secondMajor;
	private String courseCode;
	private String courseName;
	private String courseCredit;
	private int yearTaken;
	private int semesterCourseTaken;

	
	public Course(String line) {
		
		// Split the line from constructor to initialize the field.
		String[] values = line.split(",");
		
		this.setStudentId(values[0]);
		this.setYearMonthGraduated(values[1]);
		this.setFirstMajor(values[2]);
		this.setSecondMajor(values[3]);
		this.setCourseCode(values[4]);
		this.setCourseName(values[5]);
		this.setCourseCredit(values[6]);
		this.setYearTaken(values[7].trim());
		this.setSemesterCourseTaken(values[8].trim());
	}


	// Self-define getter and setter if needed
	
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getYearMonthGraduated() {
		return yearMonthGraduated;
	}


	public void setYearMonthGraduated(String yearMonthGraduated) {
		this.yearMonthGraduated = yearMonthGraduated;
	}


	public String getFirstMajor() {
		return firstMajor;
	}


	public void setFirstMajor(String firstMajor) {
		this.firstMajor = firstMajor;
	}


	public String getSecondMajor() {
		return secondMajor;
	}


	public void setSecondMajor(String secondMajor) {
		this.secondMajor = secondMajor;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseCredit() {
		return courseCredit;
	}


	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}


	public int getYearTaken() {
		return yearTaken;
	}


	public void setYearTaken(String yearTaken) {
		this.yearTaken = Integer.parseInt(yearTaken);
	}


	public int getSemesterCourseTaken() {
		return semesterCourseTaken;
	}


	public void setSemesterCourseTaken(String semesterCourseTaken) {
		this.semesterCourseTaken = Integer.parseInt(semesterCourseTaken);
	}
}
