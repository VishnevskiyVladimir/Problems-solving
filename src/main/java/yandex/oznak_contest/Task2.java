package yandex.oznak_contest;

import java.io.*;
import java.nio.file.Files;

public class Task2
    //Working
{
    public static void main(String[] args) throws Exception
    {
        StreamTokenizer in = new StreamTokenizer(
                new BufferedInputStream(
                        Files.newInputStream(new File("input.txt").toPath())));
        PrintStream out = new PrintStream(new File("output.txt"));
        int a, b;
        in.nextToken();
        a = (int) in.nval;
        in.nextToken();
        b = (int) in.nval;
        out.println(a + b);
    }
}
