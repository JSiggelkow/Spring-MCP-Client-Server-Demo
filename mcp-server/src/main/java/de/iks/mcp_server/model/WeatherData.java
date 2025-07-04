package de.iks.mcp_server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherData(
		Double latitude,
        Double longitude,
        @JsonProperty("generationtime_ms")
        Double generationTimeMs,
        @JsonProperty("utc_offset_seconds")
        Integer utcOffsetSeconds,
        String timezone,
        @JsonProperty("timezone_abbreviation")
        String timezoneAbbreviation,
        Double elevation,
        @JsonProperty("hourly_units")
        HourlyUnits hourlyUnits,
        Hourly hourly

) {
	public record HourlyUnits(
			String time,
			@JsonProperty("temperature_2m")
			String temperature2m,
			String rain
	) { }
	public record Hourly(
			List<String> time,
			@JsonProperty("temperature_2m")
			List<Double> temperature2m,
			List<Double> rain
	) { }
}
