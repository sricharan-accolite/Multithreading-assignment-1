import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		int wc = 0;
		String line;
		double start = System.nanoTime();
		while((line = br.readLine())!=null){
		    
		    line = line.replace(", "," ");
		    line = line.replace(". "," ");
		    line = line.replace(".","");
		    
		    wc += line.split(" ").length;
		}
		double end = System.nanoTime();
		System.out.println(((end-start)/1000000000)+" seconds"+wc);
	}
}
