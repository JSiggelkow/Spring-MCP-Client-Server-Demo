package de.iks.mcp_server;

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

	@Tool(name = "get_geographical_data",
			description = "Get Geographical Data (latitude, longitude, category, type, place_rank, importance, adresstype, name, display_name and boundingbox)" +
					" of provided Cityname, could return multiple data of different Cities with the same name")
	public String getCoordinates(String city) {

		log.info("GeoData Tool: Param: {}, Timestamp: {}", city, LocalDateTime.now());

		ArrayList<GeoData> geoDataList = restClient.get()
				.uri("https://nominatim.openstreetmap.org/search?q={city}&format=jsonv2", city)
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});

		return geoDataList != null ? geoDataList.toString() : "No data found" ;
	}


}

