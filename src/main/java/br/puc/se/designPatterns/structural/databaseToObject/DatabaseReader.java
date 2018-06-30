package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.List;

// how can we manage the code to create a lazy load / proxy to load the LogEvent's 
// only when someone call the method `logEntry.getEvents()`
// 
public class DatabaseReader {

	public List<LogEntry>  readFromDate(DateRange dateRange) {
		// hit the database and fill the object with the values from database
		return DatabaseUtils.getentryFromDate(dateRange);
	}
	
	public static void main(String[] args) {
		List<LogEntry> readFromDate = new DatabaseReader().readFromDate(new DateRange());
		
		for(LogEntry entry : readFromDate) {
			entry.getEvents().forEach(event -> System.out.println(event.getEvent()));
		}
	}
	
}
