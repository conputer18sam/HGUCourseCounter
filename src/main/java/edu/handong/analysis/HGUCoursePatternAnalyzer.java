package edu.handong.analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import edu.handong.analysise.utils.NotEnoughArgumentException;
import edu.handong.analysise.utils.Utils;

public class HGUCoursePatternAnalyzer {

	private HashMap<String,Student> students;
	
	/**
	 * This method runs our analysis logic to save the number courses taken by each student per semester in a result file.
	 * Run method must not be changed!!
	 * @param args
	 */
	public void run(String[] args) {
		
		try {
			// when there are not enough arguments from CLI, it throws the NotEnoughArgmentException which must be defined by you.
			if(args.length<2)
				throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		String dataPath = args[0]; // csv file to be analyzed
		String resultPath = args[1]; // the file path where the results are saved.
		ArrayList<String> lines = Utils.getLines(dataPath, true);
		
		students = loadStudentCourseRecords(lines);
		
		// To sort HashMap entries by key values so that we can save the results by student ids in ascending order.
		Map<String, Student> sortedStudents = new TreeMap<String,Student>(students); 
		// Generate result lines to be saved.
		ArrayList<String> linesToBeSaved = countNumberOfCoursesTakenInEachSemester(sortedStudents);
		
		// Write a file (named like the value of resultPath) with linesTobeSaved.
		Utils.writeAFile(linesToBeSaved, resultPath);
	}
	
	/**
	 * This method create HashMap<String,Student> from the data csv file. Key is a student id and the corresponding object is an instance of Student.
	 * The Student instance have all the Course instances taken by the student.
	 * @param lines
	 * @return
	 */
	private HashMap<String,Student> loadStudentCourseRecords(ArrayList<String> lines) {
		
		// TODO: Implement this method
		HashMap<String,Student> hashMap = new HashMap<String,Student>();

		for(String line:lines){
			
			Course course = new Course(line);
			String key = course.getStudentId();

			Student student = new Student(key);
			
			if(hashMap.containsKey(key)) {
				hashMap.get(student.getStudentId()).addCourse(course);
			}
			else {
				student.addCourse(course);
				hashMap.put(key,student);
			}
		}

		// do not forget to return a proper variable.		
		return hashMap;
	}

	/**
	 * This method generate the number of courses taken by a student in each semester. The result file look like this:
	 * StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester
	 * 0001,14,1,9
     * 0001,14,2,8
	 * ....
	 * 
	 * 0001,14,1,9 => this means, 0001 student registered 14 semeters in total. In the first semeter (1), the student took 9 courses.
	 * 
	 * 
	 * @param sortedStudents
	 * @return
	 */
	private ArrayList<String> countNumberOfCoursesTakenInEachSemester(Map<String, Student> sortedStudents) {
		
		// TODO: Implement this method
		ArrayList<String> arrayList = new ArrayList<String>();

		for(String key : sortedStudents.keySet()){
			Student student = sortedStudents.get(key);
			// 전체 등록학기 수를 알아야해
			int Semester = student.getSemestersByYearAndSemester().size();
			for(int i =0; i<Semester; i++) {
				int NumCoursesTakenInTheSemester = student.getNumCourseInNthSementer(i);
				arrayList.add(key+","+Semester+","+i+","+NumCoursesTakenInTheSemester);
			}
		}
		return arrayList; // do not forget to return a proper variable.
	}
}
