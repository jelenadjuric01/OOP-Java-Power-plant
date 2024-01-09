package energetika;

import java.awt.*;
import java.awt.event.*;


public class EnergetskiSistem extends Frame {
	private Plac plac;
	private Baterija bat;
	public EnergetskiSistem(int r,int c,int kap) {
		plac=new Plac(r,c);
		bat=new Baterija(kap);
		setBounds(700,200,500,500);
		setResizable(false);
		setTitle("Energetski sistem");
		Button dodaj=new Button("Dodaj");
		dodaj.addActionListener((ae)->{
			plac.dodajProizvodjaca(new Hidroelektrana(bat));
		});
		Panel north=new Panel();
		north.add(dodaj);
		add(north,BorderLayout.NORTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				plac.zavrsi();
				dispose();
				
			}
		});
		
		add(plac,BorderLayout.CENTER);
		//pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new EnergetskiSistem(5,5,5);
		
		
		//System.out.println(Math.random()*2*Math.PI);

	}
}
