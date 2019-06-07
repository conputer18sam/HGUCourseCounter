package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {

	private String studentId;
	private ArrayList<Course> coursesTaken = new ArrayList<Course>(); // List of courses student has taken
	private HashMap<String,Integer> semestersByYearAndSemester = new HashMap<String,Integer>(); 
	
	// constructor
	public Student(String studentId) {
		this.studentId=studentId;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void addCourse(Course newRecord) {
		coursesTaken.add(newRecord);
	}

	public HashMap<String,Integer> getSemestersByYearAndSemester(){
		
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		int semester = 0;
		
		for(Course course : coursesTaken) {
			String key = course.getYearTaken()+"-"+course.getSemesterCourseTaken();
			if(!hashMap.containsKey(key)) {
				hashMap.put(key, semester++);
			}
		}
		this.semestersByYearAndSemester=hashMap;
		return this.semestersByYearAndSemester;
	}
	

	public int getNumCourseInNthSementer(int semester) {
		int count =0;
		
		for(Course course : coursesTaken) {
			String key = course.getYearTaken()+"-"+course.getSemesterCourseTaken();
			if(semestersByYearAndSemester.get(key)==semester) {
				count++;
			}
		}
		return count;
	}
	/* Add getter and setter for the field if needed*/
	public ArrayList<Course> getCoursesTaken() {
		// TODO Auto-generated method stub
		return coursesTaken;
	}
}
