import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException
    {

        Path path= Paths.get("C:\\Users\\user\\IdeaProjects\\tema sapt 8\\replace_string\\date");
        Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(path),charset);
        System.out.println(content);

        System.out.println("Replacement word:");
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        System.out.println("Word to replace:");
        String replaced=scanner.nextLine();
        content=content.replaceAll(replaced,word);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));

    }
}
