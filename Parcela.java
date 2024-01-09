package energetika;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Parcela extends Label {
	private char oznaka;
	//private Color color;
	public Parcela(char oznaka, Color color) {
		super();
		this.oznaka = oznaka;
		setBackground(color);
		setForeground(Color.WHITE);
		setAlignment(Label.CENTER);
		setFont(new Font(Font.SERIF, Font.BOLD, 14));
		setText(""+this.oznaka);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Plac p=(Plac)getParent();
				p.izaberiParcelu(Parcela.this);
			}
		});
	}
	public void setColor(Color color) {
		setBackground(color);
	}
	
}
