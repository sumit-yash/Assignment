package com.yash.exceptions.Question3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {
	public static void main(String[] args) {
		 String line;
		    try(BufferedReader br = new BufferedReader(new FileReader("D:\\Training\\practiceWorkspace\\Training_25_08_2022\\src\\com\\yash\\exceptions\\Question3\\demo.txt"))) {
		      while ((line = br.readLine()) != null) {
		        System.out.println("Line="+line);
		      }
		    }
		      catch (IOException e) {
		      System.out.println("IOException in try block=" + e.getMessage());
		    }
	}
}
