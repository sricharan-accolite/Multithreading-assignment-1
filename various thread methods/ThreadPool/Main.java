import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat; 
import java.util.Date;
class Task implements Runnable   
{
    private String name;
      
    public Task(String s)
    {
        name = s;
    }
    
    public void run()
    {
        try
        {
                    Random rand = new Random();
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - "+ name +" = " +ft.format(d)); 
                    Thread.sleep(rand.nextInt(5000));
                    d = new Date();
                   
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));   
            }
         
          
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");
        //Creating Executor Service (Step 2)
        //ExecutorService pool = Executors.newFixedThreadPool(2);
         //ExecutorService pool = Executors.newCachedThreadPool();
          ExecutorService pool = Executors.newSingleThreadExecutor();
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        // pool shutdown ( Step 4)
        pool.shutdown();
	}
}
