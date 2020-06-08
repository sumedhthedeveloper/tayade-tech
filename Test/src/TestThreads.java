
public class TestThreads {

	public static void main(String[] args) {
		Thread t = new MyThread(){
			public void run() {
				System.out.println(" foo");
			}
		};
		t.start();
	}
}
