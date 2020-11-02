/*多线程读取文件，文件内容自定义，使用多个线程读取一个文件，每个线程读取一部分，然后拼接到另外一个文件，在每个线程读取内容的前面加上线程名。
注意：
1、在读取的时候，请尽量使用并发执行。
2、本次考核其实可以理解为文件的切割与合并。
*/
//获取一个文件对象
//
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main  {
    public static void main(String[] args) throws IOException {
        writeThread wt = new writeThread();
        Thread p1 = new Thread(wt,"part1");
        Thread p2 = new Thread(wt,"part2");
        p1.start();
        p2.start();
    }
}

