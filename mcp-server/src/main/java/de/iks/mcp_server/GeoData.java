package de.iks.mcp_server;

public record GeoData(
		Long place_id,
		String licence,
		String osm_type,
		Long osm_id,
		String lat,
		String lon,
		String category,
		String type,
		Integer place_rank,
		Double importance,
		String addresstype,
		String name,
		String display_name,
		String[] boundingbox
) { }
