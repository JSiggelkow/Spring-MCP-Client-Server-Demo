package de.iks.mcp_server.service;

import de.iks.mcp_server.model.WeatherData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

	RestClient restClient = RestClient.create();

	@Tool(name = "get_weather_forecast_by_lon_lat",
			description = "Return the weather forecast for one day (temperature and rain) for the provided longitude and latitude.")
	public String weatherData(Float lon, Float lat) {

		log.info("Tool: get_weather_data_by_lon_lat, Param: [lon: {}, lat: {}], Timestamp: {}", lon, lat, LocalDateTime.now());

		WeatherData weatherData = restClient.get()
				.uri("https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&hourly=temperature_2m,rain&forecast_days=1", lat, lon)
				.retrieve()
				.body(WeatherData.class);

		return weatherData != null ? weatherData.toString()
				: "No data found";
	}
}
