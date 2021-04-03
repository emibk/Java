import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.stream.Stream;

public class StringPos {
    public static void main(String[] args) throws IOException
    {
        String src="C:\\Users\\user\\IdeaProjects\\tema sapt 8\\string_position_in_file_column_row\\date.in";
        Scanner scan=new Scanner(System.in);
        String word=scan.nextLine();
        FileInputStream f=new FileInputStream(new File(src));
        String contents=readFile(src);
        System.out.println(contents);
        int row=0;
        int column=0;
        String[] arr=contents.split(" ");
        for(String ch:arr)
        {
           // System.out.println(ch);
            if(ch.equals("\n"))
            {
                column=-1;
                row++;
            }
            if(ch.equals(word)) System.out.println((row+1)+" "+(column+1));
            column++;
        }

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
