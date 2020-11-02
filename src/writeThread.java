import java.io.*;
import java.nio.charset.StandardCharsets;

public class writeThread implements Runnable {

    @Override
    public void run(){
        try {
            write(read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader read() throws IOException{
        FileInputStream is = new FileInputStream("target1.TXT");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return br;
    }
    public void write(BufferedReader br) throws IOException {
        synchronized (new Object()) {
            File part = new File("copy.TXT");
            if (!part.exists()) {
                part.createNewFile();
            }
            FileOutputStream os = new FileOutputStream(part);
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(Thread.currentThread().getName() + line);
                bw.newLine();
                bw.flush();
                System.out.println(Thread.currentThread().getName() + line);
            }
        }
    }

}
