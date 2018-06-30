package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface DatabaseUtils {

	static List<LogEvent> getEventsFromEntry(LogEntry entry) {
		ArrayList<LogEvent> events = new ArrayList<>();
		events.add(new LogEventProxy(entry));
		entry.setEvents(events);
		return events;
	}
	
	static List<LogEntry> getentryFromDate(DateRange range) {
		// list the database and fullfill the entries
		List<LogEntry> entries = listEntries();
		// iterate over entries and fill the events
		for (LogEntry entry : entries) {
			List<LogEvent> events = getEventsFromEntry(entry);
			entry.setEvents(events);
		}
		return entries;
	}

	static List<LogEntry> listEntries() {
		List<LogEntry> list = new ArrayList<>();
		list.add(getEntryInstance());
		list.add(getEntryInstance());
		list.add(getEntryInstance());
		list.add(getEntryInstance());
		return list;	
	}
	
	static LogEntry getEntryInstance() {
		LogEntry entry = new LogEntry();
		entry.setTimestamp(new Date());
		return entry;
	
	}
}
