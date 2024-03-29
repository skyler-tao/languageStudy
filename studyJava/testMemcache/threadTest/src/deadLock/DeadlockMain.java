package deadLock;

public class DeadlockMain implements Runnable {
	A a = new A();
	B b = new B();
	
	DeadlockMain() {
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RacingThread");
		t.start();
		
		a.foo(b);
		System.out.println("Back in main thread");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		b.bar(a);
		System.out.println("Back in other thread");
	}
	
	public static void main (String[] args) {
		new DeadlockMain();
	}
	
}
