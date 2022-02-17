package no.hvl.dat109;

import javax.swing.JOptionPane;

public class Valgmeny {

	private String visValg(String s) {
		return JOptionPane.showInputDialog(s);
	}

	private void visMelding(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	int valg;

	public void index() {
		valg = Integer.parseInt(visValg(
				"Velkommen til " + BilutleigeSelskap.getNavn() + "\n skriv 1 for å fortsette eller 0 for å avslutte"));
	}
	
	public int velgKontor(){
		
	}

	{
		switch (valg) {

		case 0:
			visMelding("Velkommen tilbake neste gang :(");
			break;
		case 1:
			
			break;

		}
	}
}
