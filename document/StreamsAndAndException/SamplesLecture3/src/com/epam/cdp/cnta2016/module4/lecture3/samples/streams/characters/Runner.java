package com.epam.cdp.cnta2016.module4.lecture3.samples.streams.characters;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		FileReader inputStream = new FileReader("source2.txt");
		FileWriter outputStream = new FileWriter("dest2.txt");
		int c;
		while ((c = inputStream.read()) != -1) {
			System.out.println("Read/write character " + (char) c);
			outputStream.write(c);
		}
		System.out.println("Completed Successfully!");

		if (inputStream != null) {
			inputStream.close();
		}
		if (outputStream != null) {
			outputStream.close();

		}
	}

}
