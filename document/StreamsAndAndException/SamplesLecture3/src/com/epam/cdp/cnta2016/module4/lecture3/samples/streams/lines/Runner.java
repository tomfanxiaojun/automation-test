package com.epam.cdp.cnta2016.module4.lecture3.samples.streams.lines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Runner {

	public static void main(String[] args) throws IOException{
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("source3.txt"));
			outputStream = new PrintWriter(new FileWriter("dest3.txt"));
			String l;
			while ((l = inputStream.readLine()) != null) {
				System.out.println("Read/write line " + l);
				outputStream.println(l);
			}
			System.out.println("Completed Successfully!");
		} catch(IOException e) {
			e.printStackTrace();
		
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}

	}

}
