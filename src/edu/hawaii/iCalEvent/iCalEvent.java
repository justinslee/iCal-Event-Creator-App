package edu.hawaii.iCalEvent;

import java.util.Calendar;

import java.util.TimeZone;
 
import java.io.*;
 
import java.util.regex.Matcher;
 
import java.util.regex.Pattern;
 
import java.text.SimpleDateFormat;
 
import java.text.ParseException;
 

 

 
public class iCalEvent {
 
private final static String version = "2.0";
 
private final static String classification = "PUBLIC";
 
// Incomplete word list of iCal properties to remove any injections
 
private final static String [] wordTest = { "BEGIN",
 
                                            "CLASS",
 
                                            "COMMENT",
 
                                            "DESCRIPTION",
 
                                            "DTEND",
 
                                            "DTSTART",
 
                                            "END",
 
                                            "GEO",
 
                                            "LAST-MODIFIED",
 
                                            "LOCATION",
 
                                            "PRODID",
 
                                            "RESOURCES",
 
                                            "SUMMARY",
 
                                            "TZID",
 
                                            "VERSION"};
 
                                   
 
  public static boolean createEvent ( String eventName, String eventDescription, 
 
                                      String eventLocation, String resources,
 
                                      String latitude, String longitude,
 
                                      String startDate, String startTime, 
 
                                      String endDate, String endTime ) {
 
    try {
 
      // ERROR CHECKING 
 
      // Check for injection
 
      if(!noInjection(eventName)||!noInjection(eventDescription)||!noInjection(eventLocation))
 
        throw new Exception("Exception: Text box injection!");
 
      
 
      // Check for bounds 
 
      if(!isTimePeriodCorrect(startDate,startTime,endDate,endTime))
 
        throw new Exception("Exception: start date > end date");
 
      
 
      // Check for correctDateSyntax
 
      if(!isCorrectDate(startDate) || !isCorrectDate(endDate))
 
        throw new Exception("Exception: Date out of bounds");
 
     
 
        
 
      // Check correct geographical range
 
      if(!isCorrectGeo(latitude,longitude))
 
        throw new Exception("Exception: Geo position DNE");
 
      
 
      
 
      // Start .ics file creation
 
      System.out.println("Creating Event File:"+eventName+startDate+".ics!");       
 
      File file = new File(eventName+startDate+".ics");
 
      file.createNewFile();
 
      
 
      // Delete existing file with same name   
 
      if(file.exists())
 
          file.delete();
 
      
 
      // Create new file   
 
      file.createNewFile();
 
      
 
      FileWriter fileWriter = new FileWriter(file.getName(),true);
 
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);      
 
      bufWriter.write(iCalHeader());
 
      bufWriter.write(iCalBodyTimeZone());
 
      bufWriter.write(iCalBodyEvent(eventName, eventLocation, eventDescription, 
 
                                    resources, latitude,  longitude,
 
                                    startDate, startTime, endDate, endTime));
 
      bufWriter.write(iCalFooter());   
 
        bufWriter.close();  
 
      
 
      return true;
 
    } catch (IOException ex) {
 
      return false;
 
    } catch (Exception ex) { // Change this for more specific cases if needed
 
      return false;
 
    }
 
       
 

 
  }
 
  
 
  private static String iCalHeader() {
 
    String data = "BEGIN:VCALENDAR\n" +
 
                  "PRODID:-//Calendar Event//My Event//EN\n" +
 
                  "VERSION:" + version + "\n" +
 
                  "CLASS:" + classification + "\n"; 
 
    return data;   
 
  }
 
  
 
  private static String iCalBodyTimeZone() {
 
    String data = "BEGIN:VTIMEZONE\n" + 
 
                  "TZID:" + myTimeZone() + "\n" +
 
//                  "LAST-MODIFIED:20120425T120000"+
 
                  "END:VTIMEZONE\n";
 
    return data;
 
  }
 
  
 
  private static String iCalBodyEvent(String eventName, String eventLocation,
 
                                      String eventDescription, String resources,
 
                                      String latitude, String longitude,
 
                                      String startDate, String startTime, 
 
                                      String endDate, String endTime) {
 
    // Used to keep newlines in check(Errors will occur in ics otherwise)                                  
 
    eventDescription = eventDescription.replaceAll("\\r|\\n","\\\\n");
 
    eventName = eventName.replaceAll("\\r|\\n","\\\\n");  
 
    eventLocation = eventLocation.replaceAll("\\r|\\n","\\\\n");  
 
    resources = resources.replaceAll("\\r|\\n","\\\\n");
 
    
 
    String data = "BEGIN:VEVENT\n" +
 
    
 
                  "SUMMARY:" + eventName + "\n" + 
 
                  "LOCATION:" + eventLocation + "\n" +
 
                  "DESCRIPTION:" + eventDescription + "\n" +    // Description and comment same values
 
                  "COMMENT:" + eventDescription + "\n" +
 
                  "RESOURCES:" + resources + "\n" +
 
                  
 
                  "DTSTART:" + startDate + "T" + startTime + "\n" +
 
                  "DTEND:" + endDate + "T" + endTime + "\n" +
 
                  
 
                  "GEO: " + latitude + "," + longitude + "\n" +
 
                  
 
                  "END:VEVENT\n";
 
    return data;
 
  }
 
  
 
  private static String iCalFooter() {
 
    String data = "END:VCALENDAR\n";
 
    return data;  
 
  }
 
  
 
  // Gets the timezone representation for TZID
 
  private static String myTimeZone() {
 
    Calendar calendar = java.util.Calendar.getInstance();  
 
    TimeZone timezone = calendar.getTimeZone();  
 
    return timezone.getDisplayName(false,0);      
 
  }
 
  
 
  // Checks for code injections 
 
  private static boolean noInjection(String ref) {
 
    // Simple check to catch some possible injections
 
    for(int i = 0; i < wordTest.length; i ++) {
 
      Pattern p = Pattern.compile(wordTest[i]+"\\s*:|;");
 
      Matcher m = p.matcher(ref);
 
      if(m.find())
 
        return false;
 
    }
 
    return true;
 
  }
 
  
 
  // Checks to see if time of event is not negative 
 
  private static boolean isTimePeriodCorrect(String startDate, String startTime, String endDate, String endTime) {
 
    
 
    int result = startDate.compareTo(endDate);
 
    if(result > 0)
 
      return false;
 
    else if(result < 0)
 
      return true;
 
    else {
 
      if(startTime.compareTo(endTime) >= 0)
 
         return false; 
 
      return true;
 
    }
 
  } 
 
  // Checks to see if geographical position is in bounds
 
  private static boolean isCorrectGeo(String latitude, String longitude) {
 
    try {
 
      float testLat = Float.valueOf(latitude.trim()).floatValue();
 
      float testLong = Float.valueOf(longitude.trim()).floatValue();
 
      
 
      if(testLat > 90 || testLat < -90) 
 
        return false;
 
      if(testLong > 180 || testLong < -180)
 
        return false;
 
        
 
      return true;
 
    }catch(Exception ex){
 
      return false;
 
    }
 
    
 
  }
 
  // Checks for valid date syntax
 
  //code modified from http://www.javadb.com/check-if-a-string-is-a-valid-date
 
  private static boolean isCorrectDate(String date){
 
  
 
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
 
    if (date.trim().length() != dateFormat.toPattern().length())
 
      return false;
 

 
    dateFormat.setLenient(false);
 
    try {
 
      //parse the inDate parameter
 
      dateFormat.parse(date.trim());
 
    }
 
    catch (ParseException pe) {
 
      return false;
 
    }
 
    return true;
 
  
 
  }
 
  public static void main(String args[]) {
 

 
  }
 

 
}
 
