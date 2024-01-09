package energetika;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {
	private int vreme;
	protected Baterija bat;
	private Thread t=null;
	private boolean work;
	public Proizvodjac(char oznaka, Color color,int vreme,Baterija bat) {
		super(oznaka, color);
		this.vreme=vreme+(int)(new Random().nextInt(300));
		this.bat=bat;
		t=new Thread(this);
		work=true;
		t.start();
	}
	protected abstract boolean napuni();
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(vreme);
				if(napuni()) {
					setForeground(Color.RED);
				}
				Thread.sleep(300);
				setForeground(Color.WHITE);
				}
		} catch (InterruptedException e) {}
		synchronized (this) {
			t = null;
			notify();
		}
		
	}
	public synchronized void zaustavi() {
		if(t==null)	 return;
		t.interrupt();
		while(t != null) {
			try {
				wait();
			}catch(InterruptedException e) {
				
			}
		}
	}
}
