package br.puc.se.designPatterns.structural.databaseToObject;

public class LogEventProxy extends LogEvent {
	
	private LogEntry entry;
	
	public LogEventProxy(LogEntry entry) {
		this.entry = entry;
	}
	
	@Override
	public String getEvent() {
		System.out.println("indo buscar no banco os eventos do periodo: " + entry.getTimestamp());
		try {
			Thread.sleep(1000);
		}catch(Exception e){}
		return "evento: " + Math.random();
	}

}
