package energetika;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Plac extends Panel{
	private int rows,col;
	private ArrayList<Parcela> parcele;

	private Parcela izabran=null;
	public Plac(int r,int c) {
		super(new GridLayout(r, c, 2, 2));
		rows=r;col=c;
		parcele= new ArrayList<>(col*rows);
		populatePanel();
	}
	public void izaberiParcelu(Parcela p) {
		if(izabran!=null) {
			izabran.setFont(new Font(Font.SERIF, Font.BOLD, 14));
			izabran.revalidate();
		}
		izabran=p;
		izabran.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		izabran.revalidate();
		repaint();
	}
	public boolean dodajProizvodjaca(Proizvodjac p) {
		if(izabran==null) return false;
		if(p instanceof Hidroelektrana) {
			Hidroelektrana h=(Hidroelektrana)p;
			int index=parcele.indexOf(izabran);
			if (izabran instanceof Proizvodjac){
				((Proizvodjac)izabran).zaustavi();
			}
			izabran=h;
			remove(index);
			add(h, index);
			revalidate();
			parcele.set(index, h);
			int v=0;
			int[] okolo=new int[8];
			okolo[0]=((index+1)%col==0?-1:index+1);
			okolo[1]=(index%col==0?-1:index-1);
			okolo[2]=(index-rows<0?-1:index-rows);
			okolo[3]=(index+rows>parcele.size()-1?-1:index+rows);
			okolo[4]=(okolo[2]%col==0 || okolo[2]==-1?-1:okolo[2]-1);
			okolo[5]=((okolo[2]+1)%col==0 || okolo[2]==-1?-1:okolo[2]+1);
			okolo[6]=(okolo[3]%col==0 || okolo[3]==-1?-1:okolo[3]-1);
			okolo[7]=((okolo[3]+1)%col==0 || okolo[3]==-1?-1:okolo[3]+1);
			for(int i=0;i<8;i++) {
				if(okolo[i]!=-1) {
					if(parcele.get(okolo[i]) instanceof Vodena) v++;
				}
			}
			h.postavi(v);
			
		}
		return true;
	}
	private void populatePanel() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++) {
			double ver=Math.random();
			if(ver>0.7) {
				Vodena v=new Vodena();
				add(v);
				parcele.add(v);
			}
			else {
				Trava t=new Trava();
				add(t);
				parcele.add(t);
			}
			}
		}
		
	}
	public synchronized void zavrsi() {
		for(Parcela p:parcele) {
			if(p instanceof Proizvodjac) {
				((Proizvodjac)p).zaustavi();
			}
		}
	}
}
