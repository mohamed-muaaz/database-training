package com.domo.training.database;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Properties {
	public static final String BASE_PATH = new File("").getAbsolutePath().toString();
	public static final String DB_URL = "jdbc:sqlite:D:/Projects/DOMO/Training/Database/DOMO_training_SQLite.db";
	
	public static String getFilePath() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.SSS").format(new Date());
		String path = String.format("%s/src/main/resources/data_%s.csv", 
													BASE_PATH, timeStamp);
	    return path;
	}
}
