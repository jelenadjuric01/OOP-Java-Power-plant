package energetika;

import java.awt.Color;

public class Trava extends Parcela {
	public Trava() {
		super('"', Color.GREEN);
	}
}
/*public class Timer extends Thread {
	private Label label;
	private int s, m;
	private boolean work;
	public Timer(Label label) {
		this.label = label;
	}
	public void run() {
		try {
			while(!isInterrupted()) {
				
				synchronized (this) {
					while(!work){
						wait();
					}
				}
				
				label.setText(toString());
				label.revalidate();
				sleep(1000);
				s++;
				if (s % 60 == 0) { m++; s = 0; }
			}
		} catch(InterruptedException e) {}
	}
	public synchronized void go() {
		work = true;
		notify();
	}
	public synchronized void pause() {
		work = false;
	}
	public synchronized void reset() {
		m = s = 0;
	}
	@Override
	public String toString() {
		return String.format("%02d:%02d", m, s);
	}
	
	Menu bgColorMenu = new Menu("Bg color");
	MenuItem bgWhite = new MenuItem("white");
	bgWhite.addActionListener((ae) -> {
			scene.setBgColor(Color.WHITE);
		});
	MenuBar menuBar = new MenuBar();
	menuBar.add(file);
	setMenuBar(menuBar);
	Choice chooseShape = new Choice(); ide actionlistener
	chooseShape.add("Heart");
	List chooseColor = new List(2); ide itemListener
	chooseColor.add("Black");
	chooseColor.select(0);
}*/
