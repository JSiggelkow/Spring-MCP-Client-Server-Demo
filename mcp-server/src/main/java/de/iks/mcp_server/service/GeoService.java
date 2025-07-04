package de.iks.mcp_server.service;

import de.iks.mcp_server.model.GeoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Slf4j
public class GeoService {

	RestClient restClient = RestClient.create();

	@Tool(name = "get_geo_data_by_city_name",
			description = "Returns geographical data (latitude, longitude, category, type, place rank, importance, address type, name, display name, and bounding box) for the provided city name. " +
					"It may return multiple entries for different cities with the same name. ")
	public String geoData(String city) {

		log.info("Tool: get_geo_data_by_city_name, Param: {}, Timestamp: {}", city, LocalDateTime.now());

		ArrayList<GeoData> geoDataList = restClient.get()
				.uri("https://nominatim.openstreetmap.org/search?q={city}&format=jsonv2", city)
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});

		return geoDataList != null ? geoDataList.toString()
				: "No data found";
	}
}

