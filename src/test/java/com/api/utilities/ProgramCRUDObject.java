package com.api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import io.restassured.RestAssured;

public class ProgramCRUDObject {
	
	private static Logger logger = LogManager.getLogger(ProgramCRUDObject.class);
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	

	public static String getCreateProgramJson(String name, String desc, String status) {
		JSONObject program = new JSONObject();//{}
		
		program.put("programName", name + (new Random().nextInt()));
		program.put("programDescription", desc);
		program.put("programStatus", status);
		String dateStr = sdf.format(new Date());
		program.put("creationTime", dateStr);
		program.put("lastModTime", dateStr);
		
		logger.debug("Sending {} to {}", program, ConfigProperties.getProgramPath());
		return program.toString();
	}
	
	public static String getRandomProgramName(String name) {
		return name + new Random().nextInt();
	}
	
	public static void deleteProgram(int id) {
		String path=ConfigProperties.getDeleteProgramPath();
		RestAssured.given().delete(path+id).then().log().all();
	}
	
	public static String getCreateProgramJsonForExisting(String name, String desc, String status) {
		JSONObject program = new JSONObject();//{}
		
		program.put("programName", name);
		program.put("programDescription", desc);
		program.put("programStatus", status);
		String dateStr = sdf.format(new Date());
		program.put("creationTime", dateStr);
		program.put("lastModTime", dateStr);
		
		return program.toString();
	}
	
}
