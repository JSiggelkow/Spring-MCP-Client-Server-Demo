package de.iks.mcp_client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prompt")
@RequiredArgsConstructor
public class AIController {

	private final AIService aiService;

	@PostMapping
	public ResponseEntity<String> prompt(@RequestBody String prompt) {
		return ResponseEntity.ok(aiService.promptAI(prompt));
	}
}
