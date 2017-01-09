package com.epam.cdp.cnta2016.module4.lecture3.samples.streams.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("source1.txt");
			out = new FileOutputStream("dest1.txt");
			int c;
			while ((c = in.read()) != -1) {
				System.out.println("Read/write byte " + c);
				out.write(c);
			}
			System.out.println("Completed Successfully!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
