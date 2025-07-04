package de.iks.mcp_server;

import de.iks.mcp_server.service.CalendarService;
import de.iks.mcp_server.service.GeoService;
import de.iks.mcp_server.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider geoTools(GeoService geoService, WeatherService weatherService, CalendarService calendarService) {
		return MethodToolCallbackProvider.builder().toolObjects(geoService, weatherService, calendarService).build();
	}
}
