package com.epam.cdp.cnta2016.module4.lecture3.samples.streams.bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Runner {

	public static void main(String[] args) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL("http://epam.by").openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		

	}

}
