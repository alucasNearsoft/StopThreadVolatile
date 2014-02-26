import java.util.concurrent.TimeUnit;

// Cooperative thread termination with a volatile field
// While the volatile modifier performs no mutual exclusion, it
// guarantees that any thread that reads the field will see the most recently written value
public class StopThread {
	private static volatile boolean stopRequested;
	public static void main(String[] args)
			throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested)
					i++;
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}