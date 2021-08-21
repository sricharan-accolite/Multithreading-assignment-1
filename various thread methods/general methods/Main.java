import java.util.*;
class Test implements Runnable{
    public void run(){
       System.out.println("t1-"+Main.t1.getState());
       try{
        Main.t1.join();
       }
       catch(Exception e){
           System.out.println(e);
       }
       System.out.println("t1-"+Main.t1.getState());
    }
}
public class Main implements Runnable
{
    static Main ob;
    static Thread t1;
	public static void main(String[] args) {
		ob = new Main();
		t1 = new Thread(ob);
		 System.out.println("t1-"+t1.getState());
		 System.out.println("t1-"+t1.getName());
		 t1.setName("Main thread");
		 System.out.println("t1-"+t1.getName());
		 
	    t1.start();
		
		
	}
	public void run(){
	     System.out.println("t1-"+t1.getState());
	    Test ob = new Test();
	    Thread t2 = new Thread(ob);
	    System.out.println("t2-"+t2.getPriority());
	    t2.start();
	    try{
           Thread.sleep(1000);
        }
        catch(Exception e){
           System.out.println(e);
       }
       System.out.println("t2-"+t2.getState());
       
       
	   
	}
}
