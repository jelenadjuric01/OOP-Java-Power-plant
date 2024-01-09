package energetika;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {
	private int vodPovr=0;
	public Hidroelektrana(Baterija bat) {
		super('H', Color.BLUE, 1500, bat);
		
	}

	protected synchronized boolean napuni() {
		if(vodPovr<1) return false;
	
		bat.dodajEnergiju(vodPovr);
		return true;
	}
	public synchronized void postavi(int i) {
		vodPovr=i;
	}
}
