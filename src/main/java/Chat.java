import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner userinput;      // user inputted line as a Scanner
        String cmdline;

        ChatModel cmodel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("marcos_model")
                .build();

        while (true) {
            System.out.print("prompt> ");

            userinput = new Scanner(System.in);
            cmdline = userinput.nextLine();

            if (cmdline.isBlank())       // If nothing, do nothing
                continue;

            String answer = cmodel.chat(cmdline);   // send the prompt and save the response

            System.out.println(answer);
        }
    }
}
