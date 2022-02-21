package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtleigeKontor {

	private int kontornr;
	private int telefonnummer;
	private Adresse adresse;
	private List<Bil> biler = new ArrayList<Bil>();
	private List<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();

	public UtleigeKontor(Adresse adresse, int kontornr, int telefonnummer) {
		String.format("%04d", kontornr);

		this.kontornr = kontornr;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;

	}

	public String visLedigeGrupper(UtleigeKontor retursted, LocalDateTime henteTid, int dager) {
		StringBuilder sb = new StringBuilder();

		Set<Gruppe> ledigeGrupper = new HashSet<Gruppe>();

		for (Gruppe g : Gruppe.values()) {
			for (Bil b : biler) {
				if (g.equals(b.getGruppe())) {
					ledigeGrupper.add(g);
				}
			}
		}

		for (Gruppe g : ledigeGrupper) {
			sb.append("Gruppe ").append(g).append(" med pris ")
					.append(Integer.toString(Prisliste.utleigepris(g) * dager)).append("kr\n");
		}
		return sb.toString();
	}

	public String ledigeBilerInnenGruppe(Gruppe g) {
		StringBuilder sb = new StringBuilder();

		int i = 1;

		for (Bil b : biler) {
			if (b.getGruppe().equals(g) && b.isLedig()) {
				sb.append(i).append(": ").append(b).append("\n");
				i++;
			}
		}

		return sb.toString();
	}

	public void leggTilBil(Bil bil) {
		biler.add(bil);

	}

	public void flyttBil(Bil bil, UtleigeKontor nytt) {

		nytt.leggTilBil(bil);
		this.fjernBil(bil);
	}

	public void fjernBil(Bil bil) {
		biler.remove(bil);
	}

	public void reserver(Reservasjon res) {
		reservasjoner.add(res);
	}

	public boolean slettReservasjon(Reservasjon res) {
		return reservasjoner.remove(res);
	}

	public int getKontornr() {
		return kontornr;
	}

	public void setKontornr(int kontornr) {
		this.kontornr = kontornr;
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
		return reservasjoner;
	}

	public void setResavasjoner(List<Reservasjon> resavasjoner) {
		this.reservasjoner = resavasjoner;
	}

	public Reservasjon hentReservasjon(int resnr) {

		Reservasjon reservasjon = null;

		for (Reservasjon res : reservasjoner) {
			if (res.getReservasjonsnr() == resnr) {
				reservasjon = res;
			}
		}
		return reservasjon;

	}

	@Override
	public String toString() {
		return "Kontonr:" + kontornr + ", nr:" + telefonnummer + ", adr:" + adresse.getPoststed();
	}

}
