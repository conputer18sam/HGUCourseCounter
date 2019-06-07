package edu.handong.analysise.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
	public static ArrayList<String> getLines(String file,boolean removeHeader){
		
		Scanner inputStream = null;
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			// Skip the header line by reading and ignoring it
			inputStream = new Scanner(new File(file)); 
			// 첫번째 라인은 헤더정보니까 무시하기 위해서 nextLine으로 넘어감
			if(removeHeader) {
				inputStream.nextLine(); 
			}
			// Read the rest of the file line by line
			while (inputStream.hasNextLine())
			{
				// Contains SKU,Quantity,Price,Description
				String line = inputStream.nextLine();
				lines.add(line);
			}
			inputStream.close( );
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot find file " + file);
		}
		
		return lines;
		
		
	}
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		try {
			
			File file= new File(targetFileName);
			/* If a file does not exist in the directory, 
			 * FileNotFoundException may occur, to prevent, a logic to create directory is required.
			 */
			file.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			
			dos.write(("StudentID"+","+"TotalNumberOfSemestersRegistered"+","+"Semester"+","+" NumCoursesTakenInTheSemester"+"\n").getBytes());
			
			for(String line:lines){
				dos.write((line+"\n").getBytes());
			}
			//dos.writeBytes();
			dos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}


}
