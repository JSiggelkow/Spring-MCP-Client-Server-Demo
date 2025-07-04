package de.iks.mcp_server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CalendarService {

	@Tool(name = "get_activities_for_today",
			description ="Returns all activities for today, including the time, activity and place")
	public String calendarData() {

		log.info("Tool: get_activities_for_today, Timestamp: {}", LocalDateTime.now());

		return """
				8:00 - 10:00 Uhr Fahrrad fahren in Düsseldorf
				12:00 - 16:00 Uhr Segeln auf dem Bodensee (Friedrichshafen)
				18:00 - 19:00 Uhr Eis essen in Ulm
				20:00 - 22:00 Uhr OpenAir-Konzert in München
				""";
	}
}
