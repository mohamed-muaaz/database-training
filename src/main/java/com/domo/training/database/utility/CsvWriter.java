package com.domo.training.database.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVWriter;

public class CsvWriter {
	
	public void writeToFile(String path, List<String[]> data){
		try {
			FileWriter fw = new FileWriter(path);
			CSVWriter csvWriter = new CSVWriter(fw);
			csvWriter.writeAll(data);
			csvWriter.close();
			System.out.println("File write successfull");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
