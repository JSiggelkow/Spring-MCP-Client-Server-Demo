package de.iks.mcp_client;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AIService {

	private final OpenAiChatModel chatModel;
	private final SyncMcpToolCallbackProvider toolCallbackProvider;

	public String promptAI(String prompt) {
		return Optional.ofNullable(ChatClient.create(chatModel)
						.prompt(prompt)
						.toolCallbacks(toolCallbackProvider.getToolCallbacks())
						.call()
						.chatResponse())
				.map(response -> response.getResult().getOutput().getText())
				.orElse("handle error");
	}
}
