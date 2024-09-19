package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
public static String obterTraducao(String texto) {
OpenAiService service = new OpenAiService("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");

CompletionRequest requisicao = CompletionRequest.builder()
.model("gpt-3.5-turbo-instruct")
.prompt("traduza para o português o texto: " + texto)
.maxTokens(1000)
.temperature(0.7)
.build();

var resposta = service.createCompletion(requisicao);
return resposta.getChoices().get(0).getText();
}
}