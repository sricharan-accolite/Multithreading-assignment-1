import java.util.*;
class Daemon extends Thread{
    public void run(){
        if(this.isDaemon())
        System.out.println("Daemon thread");
        else System.out.println("Normal thread");
    }
}
public class Main
{
	public static void main(String[] args) {
		Daemon t1 = new Daemon();
		Daemon t2 = new Daemon();
		t1.setDaemon(true);
		t1.start();
		t2.start();
	}
}
