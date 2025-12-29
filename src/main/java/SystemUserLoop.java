import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dev.langchain4j.model.anthropic.AnthropicChatModelName.CLAUDE_3_5_SONNET_20241022;

public class SystemUserLoop {
    public static void main(String[] args) {
        Scanner userinput;      // user inputted line as a Scanner
        String cmdline;
        List<ChatMessage> messages;

        ChatModel cmodel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(OpenAiChatModelName.GPT_3_5_TURBO) // or GPT_4
                .temperature(.3)                        // keep randomness low
                .timeout(Duration.ofSeconds(120))       // network timeout is 2 min
                .maxTokens(512)                         // keep data charges low
                .build();

        while (true) {
            messages = new ArrayList<>();

            System.out.print("Instruction> ");
            userinput = new Scanner(System.in);
            cmdline = userinput.nextLine();
            if (cmdline.isBlank())       // If nothing is input, do nothing
                continue;
            SystemMessage sysmsg = new SystemMessage(cmdline);
            messages.add(sysmsg);

            System.out.print("Question> ");
            userinput = new Scanner(System.in);
            cmdline = userinput.nextLine();
            if (cmdline.isBlank())       // If nothing, do nothing
                continue;
            UserMessage usrmsg = UserMessage.from(cmdline);
            messages.add(usrmsg);

            ChatResponse answer = cmodel.chat(messages);
            System.out.println(answer.aiMessage().text());
        }
    }

    static public String getUserInput(String pstring) {
        String cmdline;

        System.out.print(pstring);
        cmdline = new Scanner(System.in).nextLine();
        return cmdline.isBlank()? "" : cmdline;
    }
}
