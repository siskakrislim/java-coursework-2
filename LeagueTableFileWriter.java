//Name: Siska Kristanti Lim
//Student number: 170281939
import java.io.*;
import java.nio.charset.StandardCharsets;

public class LeagueTableFileWriter {
    public static void write(String league, File file) throws IOException {
    	BufferedWriter out = new BufferedWriter(new FileWriter(file));
    	out.write(league,0,league.length());
    	out.close();
    }
}
