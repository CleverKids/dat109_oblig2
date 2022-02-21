package no.hvl.dat109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestBUS {

	Adresse adr = new Adresse("1B", 6823, "Sandane");
	Adresse adr1 = new Adresse("246", 6812, "Førde");
	Adresse adr2 = new Adresse("66A", 5063, "Bergen");
	Adresse adrFirma = new Adresse("28", 5063, "Bergen");
	Adresse adrKunde = new Adresse("1B", 6823, "Sandane");

	Bil bil1 = new Bil("UA.34689", "VW", "Golf", Farge.GRAA, Gruppe.B, true, 2000);
	Bil bil2 = new Bil("BT.89003", "Honda", "Civic", Farge.KVIT, Gruppe.B, true, 2000);
	Bil bil3 = new Bil("BT.78902", "Tesla", "Roadster", Farge.ROD, Gruppe.A, true, 1000);
	Bil bil4 = new Bil("TV.53290", "Volvo", "V60", Farge.SVART, Gruppe.C, true, 3000);
	Bil bil5 = new Bil("UA.33478", "Toyota", "Proace", Farge.GRAA, Gruppe.D, true, 4000);
	Bil bil6 = new Bil("TV.34559", "Audi", "R8", Farge.KVIT, Gruppe.A, true, 1000);

	UtleigeKontor ukontor = new UtleigeKontor(adr, 1001, 89774553);
	UtleigeKontor ukontor1 = new UtleigeKontor(adr1, 2001, 45673443);
	UtleigeKontor ukontor2 = new UtleigeKontor(adr2, 3001, 78879906);

	List<UtleigeKontor> testKontorListe = new ArrayList<UtleigeKontor>();

	@BeforeEach
	public void reset() {
		testKontorListe.add(ukontor1);
		testKontorListe.add(ukontor2);
		testKontorListe.add(ukontor);

		ukontor.leggTilBil(bil1);
		ukontor.leggTilBil(bil2);
		ukontor1.leggTilBil(bil3);
		ukontor1.leggTilBil(bil4);
		ukontor2.leggTilBil(bil5);
		ukontor2.leggTilBil(bil6);
	}

	Kunde testkunde = new Kunde("dum", "dumming", adrKunde, 12344321);

	BilutleigeSelskap besteSelskap = new BilutleigeSelskap("besteSelskap", 12345678, adrFirma, testKontorListe);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	String str1 = "2022-03-01 10:00";
	String str2 = "10:00";

	LocalDateTime fast = LocalDateTime.parse(str1, formatter);
	LocalTime slow = LocalTime.parse(str2);

	Reservasjon res = new Reservasjon(ukontor, ukontor1, fast, slow, 5, bil1, testkunde);

	@Test
	public void testLedighet() {
		res.reserver();
		assertFalse(bil1.isLedig());
	}

	@Test
	public void testPris() {
		res.reserver();
		res.hentBil(0);
		res.leverTilbake();
		double d = Prisliste.utleigepris(bil1.getGruppe()) * 5 + Reservasjon.getGebyr();
		assertEquals(d, res.getFaktura().getTotalPris());

	}

	@Test
	public void testFinnReservasjon() {
		res.reserver();
		Reservasjon getReservasjon = besteSelskap.hentReservasjon(res.getReservasjonsnr());
		assertTrue(getReservasjon.equals(res));
	}

	@Test
	public void testLedigEtter() {
		res.reserver();
		res.hentBil(0);
		res.leverTilbake();
		assertTrue(bil1.isLedig());
	}

}
