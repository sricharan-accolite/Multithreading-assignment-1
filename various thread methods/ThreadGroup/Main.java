import java.lang.*;
class A extends Thread 
{
    NewThread(String name, ThreadGroup tg)
    {
        super(tg, name);
        start();
    }
    public void run()
        {
      
            for (int i = 0; i < 1000; i++) 
            {
                try 
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) 
                {
                    System.out.println(e);
                }
            }
            System.out.println(this.getName() + 
                " finished executing");
    }
} 
public class Main 
{
    public static void main(String arg[]) throws InterruptedException
    {
        
        ThreadGroup gfg = new ThreadGroup("gfg");
  
        ThreadGroup gfg_child = new ThreadGroup(gfg, "child");
  
        A t1 = new A("one", gfg);
        System.out.println("begin one");
        A t2 = new A("two", gfg);
        System.out.println("begin two");
  
        System.out.println("number of active thread group: "
                           + gfg.activeGroupCount());
    }
}