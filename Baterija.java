package energetika;

public class Baterija {
	private int energija,maks;

	public Baterija(int maks) {
		super();
		this.maks = maks;
		energija=maks;
	}
	public synchronized void dodajEnergiju(int i) {
		energija=(energija+i>=maks?maks:energija+i);
	}
	public synchronized void isprazni() {
		energija=0;
	}
	public synchronized boolean puna() {
		return energija==maks;
	}
}
