import java.lang.Object;

public class timer implements Runnable  {
	public int count;
	public int difference;
	public boolean endless = true;

	public timer () {
		count = 0;
	}

	@Override
	public void run () {
		while (endless) {
			try {
				Thread.sleep (50);
				count++; 
				
			}
			catch (InterruptedException e) {
				System.out.println ("error occured!");
		}
	}
	}

	public void displayTime () {
		//stop thread
		endless = false;
		difference = 1200/this.count;
		//set counnt back to 0
		this.count = 0;

	}
}