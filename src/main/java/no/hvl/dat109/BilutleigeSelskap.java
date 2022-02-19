package no.hvl.dat109;

import java.util.List;

public class BilutleigeSelskap {

	private static String navn;
	private int telefonnummer;
	private Adresse adresse;
	private List<UtleigeKontor> utleigekontor;
	private List<Kunde> kunder;

	public BilutleigeSelskap(String navn, int telefonnummer, Adresse adresse, List<UtleigeKontor> utleigekontor,
			List<Kunde> kunder) {
		BilutleigeSelskap.navn = navn;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.utleigekontor = utleigekontor;
		this.kunder = kunder;
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
