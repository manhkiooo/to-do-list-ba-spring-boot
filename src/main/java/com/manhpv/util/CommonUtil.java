package com.manhpv.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

import com.manhpv.dto.WorkDto;

public class CommonUtil {
	public static JSONObject createJsonDeFault(){
		JSONObject joDefault = new JSONObject();
		joDefault.put("error", 0);
		joDefault.put("message", "Success");
		return joDefault;
	}
	
	public static boolean validateWork(JSONObject joObject) {
		Date startDate = stringToDate(joObject.getString("startDate"));
		Date endDate = stringToDate(joObject.getString("endDate"));
		if(!joObject.getString("workName").equals("") 
				&& joObject.getInt("status") > 0
				&& startDate != null
				&& endDate != null
				) {
			return startDate.getTime() < endDate.getTime() ? true : false;
			
		}else 
			return false;
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(ConstanUtil.DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}
	
	public static Date stringToDate(String strDate) 
	{
        DateFormat df = new SimpleDateFormat(ConstanUtil.DATE_FORMAT);
        Date date;
        try {
        	date = df.parse(strDate);
            String newDateString = df.format(date);
            System.out.println(newDateString);
            return date;
        } catch (Exception e) {
           return null;
        }
	        
	}
}
