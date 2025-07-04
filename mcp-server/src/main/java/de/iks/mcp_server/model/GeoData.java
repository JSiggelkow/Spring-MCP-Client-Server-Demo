package de.iks.mcp_server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GeoData(
		@JsonProperty("place_id")
		Long placeId,
		String licence,
		@JsonProperty("osm_type")
		String osmType,
		@JsonProperty("osm_id")
		Long osmId,
		String lat,
		String lon,
		String category,
		String type,
		@JsonProperty("place_rank")
		Integer placeRank,
		Double importance,
		@JsonProperty("adresstype")
		String addressType,
		String name,
		@JsonProperty("display_name")
		String displayName,
		@JsonProperty("boundingbox")
		List<String> boundingBox
) { }
