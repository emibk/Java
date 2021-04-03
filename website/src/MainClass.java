import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) throws IOException
    {
        String source="C:\\Users\\user\\IdeaProjects\\tema sapt 8\\website\\URL";
        String destination="C:\\Users\\user\\IdeaProjects\\tema sapt 8\\website\\Content.html";

        String contents=readFile(source);
        URL url=new URL(contents);
        InputStream inputStream = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
        String linie;
        String content="";
        do {
            linie = bufferedReader.readLine();
            if (linie != null){
                content += linie;
                content+="\n";
            }

        }while (linie != null);
        writer.write(content);
        writer.close();
        bufferedReader.close();


    }
    public static String readFile(String filename)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filename), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append(" \n "));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();

    }
}
