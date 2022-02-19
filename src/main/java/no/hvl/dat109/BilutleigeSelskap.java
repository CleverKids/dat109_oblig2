package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;



public class BilutleigeSelskap {
	
	public static void main(String[] args) {
	
		//main metode for testing
		
		
		Adresse adr = new Adresse("1B", 6823, "Sandane" );
		Adresse adr1 = new Adresse("246", 6812, "Førde");
		Adresse adr2 = new Adresse("66A", 5063, "Bergen");
		Adresse adrFirma = new Adresse("28", 5063, "Bergen");
		Adresse adrKunde = new Adresse("1B", 6823, "Sandane" );
		
		Bil bil1 = new Bil("UA.34689", "VW", "Golf", Farge.GRAA, Gruppe.B, true, 2000);
		Bil bil2 = new Bil("BT.89003", "Honda", "Civic", Farge.KVIT, Gruppe.B, true, 2000);
		Bil bil3 = new Bil("BT.78902", "Tesla", "Roadster", Farge.ROD, Gruppe.A, true, 1000);
		Bil bil4 = new Bil("TV.53290", "Volvo", "V60", Farge.SVART, Gruppe.C, true, 3000);
		Bil bil5 = new Bil("UA.33478", "Toyota", "Proace", Farge.GRAA, Gruppe.D, true, 4000);
		Bil bil6 = new Bil("TV.34559", "Audi", "R8", Farge.KVIT, Gruppe.A, true, 1000);
		
		UtleigeKontor ukontor = new UtleigeKontor(adr,1,89774553);
		UtleigeKontor ukontor1 = new UtleigeKontor(adr1,2,45673443);
		UtleigeKontor ukontor2 = new UtleigeKontor(adr2,3,78879906);
		
		List<UtleigeKontor> testKontorListe = new ArrayList<UtleigeKontor>();
		List<UtleigeKontor> testKontorListe2 = new ArrayList<UtleigeKontor>();
		testKontorListe.add(ukontor1);
		testKontorListe.add(ukontor2);
		testKontorListe2.add(ukontor);
		
		ukontor.leggTilBil(bil1);
		ukontor.leggTilBil(bil2);
		ukontor1.leggTilBil(bil3);
		ukontor1.leggTilBil(bil4);
		ukontor2.leggTilBil(bil5);
		ukontor2.leggTilBil(bil6);
		
		Kunde testkunde = new Kunde("dum", "dumming", adrKunde, 12344321);

        
		BilutleigeSelskap besteSelskap = new BilutleigeSelskap("besteSelskap", 12345678,adrFirma,testKontorListe);

		Valgmeny meny = new Valgmeny(besteSelskap);
		meny.start();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private static String navn;
	private int telefonnummer;
	private Adresse adresse;
	private List<UtleigeKontor> utleigekontor;
	private List<Kunde> kunder = new ArrayList<Kunde>();

	public BilutleigeSelskap(String navn, int telefonnummer, Adresse adresse, List<UtleigeKontor> utleigekontor) {
		BilutleigeSelskap.navn = navn;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.utleigekontor = utleigekontor;
		
	}

	public void leggKontorTilListe(UtleigeKontor nyKontor) {
		utleigekontor.add(nyKontor);
	}

	public void leggTilKunde(Kunde k) {
		kunder.add(k);
	}

	public String getNavn() {
		return navn;
	}

	public static void setNavn(String navn) {
		BilutleigeSelskap.navn = navn;
	}

	public int getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public String getUtleigekontorString() {

		StringBuilder sb = new StringBuilder();

		int n = 1;
		for (UtleigeKontor utlk : utleigekontor) {
			sb.append(n).append(": ").append(utlk).append("\n");
			n++;
		}
		

		return sb.toString();
	}

	public void setUtleigekontor(List<UtleigeKontor> utleigekontor) {
		this.utleigekontor = utleigekontor;
	}

	public List<Kunde> getKunde() {
		return kunder;
	}

	public void setKunde(List<Kunde> kunde) {
		this.kunder = kunde;
	}

	public List<UtleigeKontor> getUtleigekontor() {
		return utleigekontor;
	}

}
