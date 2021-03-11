import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainClass
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = scan.nextLine();

        System.out.println( "Filename: " +filename);

        System.out.print("Enter word: ");
        String word=scan.nextLine();
        System.out.println("Word is:"+word);

        String contents=readFile(filename);
        int nr=wordCount(contents,word);
        System.out.println("Number of occurences:"+nr);

    }

    public static String readFile(String filename) {

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filename), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();

    }

    public static int wordCount(String contents, String word) {


        if(contents==null || contents.isEmpty()) return 0;
        else{
            Scanner c=new Scanner(contents);
            String a[]=contents.split("\\W+");


            int nr=0;
            for(int i=0;i<a.length;i++)
            {
                if(word.equals(a[i])) nr++;
            }
            return nr;
        }





    }
}