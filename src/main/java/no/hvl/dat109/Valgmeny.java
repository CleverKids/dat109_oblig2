package no.hvl.dat109;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Valgmeny {

	Kunde kunde;
	private BilutleigeSelskap selskapet;
	UtleigeKontor kontoret;
	UtleigeKontor retursted;
	LocalDateTime henteTid;
	int dager;
	Gruppe gruppen;
	Bil bilen;
	Reservasjon reservasjonen;

	public Valgmeny(BilutleigeSelskap bilutleigeselskap) {
		this.selskapet = bilutleigeselskap;
	}

	private String visValg(String s) {
		return JOptionPane.showInputDialog(s);
	}

	private void visMelding(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	int valgStart;

	public void start() {
		valgStart = Integer.parseInt(
				visValg("Velkommen til " + selskapet.getNavn() + "\n skriv 1 for å fortsette eller 0 for å avslutte"));
	}

	{
		switch (valgStart) {

		case 0:
			visMelding("Velkommen tilbake neste gang :(");
			break;

		case 1:
			kunde  = new Kunde();
			kunde.setFornavn(visValg("Oppgi fornavn"));
			kunde.setEtternavn(visValg("Oppgi etternavn"));
			kunde.setFornavn(visValg("Oppgi telefonnr."));
			
			Adresse adr = new Adresse();
			adr.setGate(visValg("Oppgi gatenavn"));
			adr.setPostNr(Integer.parseInt(visValg("Oppgi postnr.")));
			adr.setPoststed(visValg("Oppgi poststed"));
			
			kunde.setAdresse(adr);
			
			
			int n = Integer.parseInt(visValg("Velg et selskap\n" + selskapet.getUtleigekontorString()));
			kontoret = selskapet.getUtleigekontor().get(n - 1);

			int m = Integer.parseInt(visValg("Velg et retursted\n" + selskapet.getUtleigekontorString()));
			retursted = selskapet.getUtleigekontor().get(m - 1);

			henteTid = beOmTid("hentetid");

			dager = Integer.parseInt(visValg("Skriv antall dager du vil leie"));

			gruppen = Gruppe.valueOf(visValg("Ledige grupper ved :\n" + kontoret.toString() + "\n"
					+ kontoret.visLedigeGrupper(retursted, henteTid, dager)
					+ "\nSkriv inn den bilgruppen du vil leie"));

			hentBil(Integer.parseInt(visValg("Ledige biler: \n" + kontoret.ledigeBilerInnenGruppe(gruppen) + "\n")));
			
			
			reservasjonen = new Reservasjon(kontoret, retursted, henteTid, 
					beOmTid("leveringstid"), n, bilen);
		}
	}

	public LocalDateTime beOmTid(String s) {
		String str = visValg("Skriv " + s + "(yyyy-MM-dd HH:mm)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return LocalDateTime.parse(str, formatter);
		
	}

	private void hentBil(int valgBil) {
		if (valgBil == 0) {
			visMelding("Velkommen tilbake neste gang :(");
		} else {
			bilen = kontoret.getBiler().get(valgBil - 1);

		}
	}

}
