package no.hvl.dat109;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Timestamp;

public class Reservasjon {
	private static double gebyr = 500;
	private static int reservasjonsGenerator = 0;

	private int reservasjonsnr;
	private UtleigeKontor leiested, retursted;
	private LocalDateTime ut_dato, inn_dato;
	private int antallDager;
	private Bil bil;
	private double pris;
	private long kredittkort;
	private Faktura faktura;
	private double kmFor;
	private double kmEtter;
	private double fakturagebyr;
	private Kunde kunde;

	public Reservasjon(UtleigeKontor leiested, UtleigeKontor retursted, LocalDateTime ut_dato_tid, LocalTime inn_tid,
			int antallDager, Bil bil,Kunde kunde) {

		this.leiested = leiested;

		reservasjonsnr = Integer
				.parseInt(String.valueOf(leiested.getKontornr()) + String.valueOf(generateReservasjonsNr()));

		this.retursted = retursted;
		this.ut_dato = ut_dato_tid;
		this.inn_dato = ut_dato_tid.withHour(inn_tid.getHour()).withMinute(inn_tid.getMinute()).plusDays(antallDager);
		this.antallDager = antallDager;
		this.bil = bil;
		this.setKunde(kunde); 

		pris = (double) (Prisliste.utleigepris(bil.getGruppe()) * antallDager);

		if (leiested.equals(retursted)) {
			fakturagebyr = 0;
		} else {
			fakturagebyr = gebyr;
		}

		bil.setLedig(false);
		leiested.reserver(this);
	}

	public void hentBil(long kredittkort) {
		kmFor = bil.getKm();
		this.kredittkort = kredittkort;
	}

	public void leverTilbake() {
		kmEtter = bil.getKm();

		if (!leiested.equals(retursted)) {
			leiested.flyttBil(bil, retursted);
		}
		
		bil.setLedig(true);


		faktura = new Faktura(ut_dato, inn_dato, antallDager, pris, fakturagebyr, pris + fakturagebyr);
	}

	public UtleigeKontor getLeiested() {
		return leiested;
	}

	public void setLeiested(UtleigeKontor leiested) {
		this.leiested = leiested;
	}

	public UtleigeKontor getRetursted() {
		return retursted;
	}

	public void setRetursted(UtleigeKontor retursted) {
		this.retursted = retursted;
	}

	public LocalDateTime getUt_dato() {
		return ut_dato;
	}

	public void setUt_dato(LocalDateTime ut_dato) {
		this.ut_dato = ut_dato;
	}

	public LocalDateTime getInn_dato() {
		return inn_dato;
	}

	public void setInn_dato(LocalDateTime inn_dato) {
		this.inn_dato = inn_dato;
	}

	public int getAntallDager() {
		return antallDager;
	}

	public void setAntallDager(int antallDager) {
		this.antallDager = antallDager;
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public long getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(long kredittkort) {
		this.kredittkort = kredittkort;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public double getKmFor() {
		return kmFor;
	}

	public void setKmFor(double kmFor) {
		this.kmFor = kmFor;
	}

	public double getKmEtter() {
		return kmEtter;
	}

	public void setKmEtter(double kmEtter) {
		this.kmEtter = kmEtter;
	}

	public static double getGebyr() {
		return gebyr;
	}

	public static void setGebyr(double gebyr) {
		Reservasjon.gebyr = gebyr;
	}

	private int generateReservasjonsNr() {
		return reservasjonsGenerator++;

	}

	@Override
	public String toString() {
		return "Reservasjon\n [reservasjonsnr=" + reservasjonsnr +"\n kunde="+ kunde.getEtternavn() +"\nleiested=" + leiested.getAdresse().getPoststed()
				+ "\n retursted=" + retursted.getAdresse().getPoststed() + "\n hentedato=" + ut_dato + "\n tilbakedato="
				+ inn_dato + "\n antallDager=" + antallDager + "\n bil=" + bil + "\n pris=" + (pris + fakturagebyr)
				+ "kr]";
	}

	public int getReservasjonsnr() {
		return reservasjonsnr;
	}

	public double getFakturagebyr() {
		return fakturagebyr;
	}

	public void setFakturagebyr(double fakturagebyr) {
		this.fakturagebyr = fakturagebyr;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

}
