import java.util.*;
import java.io.*;
import java.util.concurrent.CyclicBarrier;

class counter extends Thread{
    String text;
    counter(String text,String threadname, ThreadGroup tgob){
        super(tgob, threadname);
        this.text = text;
        start();
       

    }
    public void run(){
        try{
            Main.cb.await();
            
            BufferedReader br = new BufferedReader(new StringReader(this.text));
    		int wc = 0;String line;
    		while((line = br.readLine())!=null){
    		    
    		    line = line.replace(", "," ");
    		    line = line.replace(". "," ");
    		    line = line.replace(".","");
    		 
    		    wc += line.split(" ").length;
    		}
    		System.out.println(wc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public class Main
{
    static  CyclicBarrier cb;
	public static void main(String[] args) throws Exception {
        ThreadGroup tg = new ThreadGroup("parent thread group");
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
	
		String text="",line;
		
		while((line = br.readLine())!=null){
		    line = line.replace(", "," ");
		    line = line.replace(". "," ");
		    line = line.replace(".","");
		    text += line;
		}
        //System.out.println(text);
        int str_size = text.length();
        System.out.println(text.split(" ").length);
        int n = 6;
        int part_size;
        if (str_size % n != 0) {
            System.out.println("Invalid Input: String size"
                               + "is not divisible by n");
          
        }
        part_size = str_size / n;
        //System.out.println(part_size);
        String parts[] = new String[n];
        int p = 0;
        String temp = "";
        for (int i = 0; i < str_size; i++) {
            if ((i+1) % part_size == 0){
                //System.out.println(temp);
                parts[p++] = temp;
                temp = "";
            }
            temp += Character.toString(text.charAt(i));
        }
        counter threads[] = new counter[n];
        cb = new CyclicBarrier(n+1);
        for(int i=0;i<threads.length;i++){
            threads[i] = new counter(parts[i],System.currentTimeMillis()+"",tg);
            
        }
        double start = System.nanoTime();
        cb.await();
        while(tg.activeCount()>0){
            //System.out.println(tg.activeCount());
        }
        double end = System.nanoTime();
        double time = end-start;
        System.out.println(time);


	}
}
