package no.hvl.dat109;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Valgmeny {

	BilutleigeSelskap selskapet;

	public Valgmeny(BilutleigeSelskap bilutleigeselskap) {
		this.selskapet = bilutleigeselskap;
	}

	private String visValg(String s) {
		return JOptionPane.showInputDialog(s);
	}

	private void visMelding(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public void start() {
/*
		int valgStart = Integer.parseInt(visValg("Velkommen til " + selskapet.getNavn()
				+ "\n skriv 0 for å avslutte, 1 for reservasjon, 2 for å hente bil eller 3 for å lever tilbake bil"));

		switch (valgStart) {

		case 0:
			visMelding("Velkommen tilbake neste gang :(");
			break;

		case 1:
*/
			Kunde kunde;
			UtleigeKontor kontoret;
			UtleigeKontor retursted;
			LocalDateTime henteTid;
			LocalTime leveringsTid;
			int dager;
			Gruppe gruppen;
			Bil bilen;
			Reservasjon reservasjonen;

			String fornavn = visValg("Oppgi fornavn");
			String etternavn = visValg("Oppgi etternavn");
			int nr = Integer.parseInt(visValg("Oppgi telefonnr."));

			Adresse adr = new Adresse();
			adr.setGate(visValg("Oppgi gatenavn"));
			adr.setPostNr(Integer.parseInt(visValg("Oppgi postnr.")));
			adr.setPoststed(visValg("Oppgi poststed"));
			
			kunde = new Kunde(fornavn, etternavn, adr, nr);

			int n = Integer.parseInt(visValg("Velg et selskap\n" + selskapet.getUtleigekontorString()));
			kontoret = selskapet.getUtleigekontor().get(n - 1);

			int m = Integer.parseInt(visValg("Velg et retursted\n" + selskapet.getUtleigekontorString()));
			retursted = selskapet.getUtleigekontor().get(m - 1);

			henteTid = beOmTid("hentetid");

			dager = Integer.parseInt(visValg("Skriv antall dager du vil leie"));

			gruppen = Gruppe.valueOf(visValg("Ledige grupper ved :\n" + kontoret.toString() + "\n"
					+ kontoret.visLedigeGrupper(retursted, henteTid, dager) + "\nSkriv inn den bilgruppen du vil leie")
							.toUpperCase());

			bilen = kontoret.getBiler()
					.get(Integer.parseInt(visValg("Ledige biler: \n" + kontoret.ledigeBilerInnenGruppe(gruppen) + "\n"))
							- 1);

			leveringsTid = LocalTime.parse(visValg("Oppgi leveringstid(hh:mm)"));

			reservasjonen = new Reservasjon(kontoret, retursted, henteTid, leveringsTid, dager, bilen, kunde);

			int bekreft = Integer
					.parseInt(visValg("0 for avbryte bestilling eller 1 for å bekrefte\n" + reservasjonen.toString()));

			if (bekreft == 0) {
				kontoret.slettReservasjon(reservasjonen);
				visMelding("Bestilling slettet, velkommen tilbake neste gang :(");
//				break;

			} else {
				visMelding(
						"Bestilling bekreftet, håper du skrev ned all informasjon for du kommer ikke til å få bekreftelse på e-post");
//				break;
			}

//		case 2:
			int resnr = Integer.parseInt(visValg("Oppgi reservasjonsnr"));

			String s = Integer.toString(resnr).substring(0, 4);
			int knr = Integer.parseInt(s);

			UtleigeKontor kontor = selskapet.hentKontor(knr);
			Reservasjon res = kontor.hentReservasjon(resnr);

			res.hentBil(Long.parseLong(visValg("Oppgi kredittkortnr")));

			visMelding("Kredittkort lagt til $$$");

//			break;

//		case 3:
			int resnum = Integer.parseInt(visValg("Oppgi reservasjonsnr"));

			Reservasjon resrv = selskapet.hentReservasjon(resnum);
			resrv.leverTilbake();
			visMelding(resrv.getFaktura().toString());

//			break;
//		}
	}

	public LocalDateTime beOmTid(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		LocalDateTime datetime1 = LocalDateTime.now();
		String now = datetime1.format(formatter);

		String str = JOptionPane.showInputDialog("Skriv " + s + "(yyyy-MM-dd HH:mm)", now);

		return LocalDateTime.parse(str, formatter);

	}

}
