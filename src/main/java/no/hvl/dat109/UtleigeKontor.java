package no.hvl.dat109;

import java.util.List;

public class UtleigeKontor {
	
	private int kontonr;
	private int telefonnummer;
	private Adresse adresse;
	private List<Bil> biler;
	private List<Reservasjon> resavasjoner;
	private int antBiler;
	
	public UtleigeKontor(int kontonr, int telefonnummer, Adresse adresse, List<Bil> biler,
			List<Reservasjon> resavasjoner, int antBiler) {
		this.kontonr = kontonr;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.biler = biler;
		this.resavasjoner = resavasjoner;
		this.antBiler = antBiler;
	}

	
	public void leggTilBil(Bil bil) {
		biler.add(bil);
		antBiler++;
	}
	
	public void reserver(Reservasjon res) {
		resavasjoner.add(res);
	}


	public int getKontonr() {
		return kontonr;
	}


	public void setKontonr(int kontonr) {
		this.kontonr = kontonr;
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


	public List<Bil> getBiler() {
		return biler;
	}


	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}


	public List<Reservasjon> getResavasjoner() {
		return resavasjoner;
	}


	public void setResavasjoner(List<Reservasjon> resavasjoner) {
		this.resavasjoner = resavasjoner;
	}


	public int getAntBiler() {
		return antBiler;
	}


	public void setAntBiler(int antBiler) {
		this.antBiler = antBiler;
	}
	
	
	
	
}
