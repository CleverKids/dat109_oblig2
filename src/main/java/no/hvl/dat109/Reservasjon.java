package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Timestamp;

public class Reservasjon {

	
	private UtleigeKontor leiested,retursted;
	private LocalDateTime ut_dato, inn_dato;
	private int antallDager;
	private Bil bil;
	private double pris;
	private long kredittkort;
	private Faktura faktura;
	
	private static double gebyr = 500;


public Reservasjon(UtleigeKontor leiested, UtleigeKontor retursted, LocalDateTime ut_dato, LocalDateTime inn_dato,
			int antallDager, Bil bil, double pris, long kredittkort) {
		super();
		this.leiested = leiested;
		this.retursted = retursted;
		this.ut_dato = ut_dato;
		this.inn_dato = inn_dato;
		this.antallDager = antallDager;
		this.bil = bil;
		this.pris = pris;
		this.kredittkort = kredittkort;
	}



	public void fakturer() {
		double fakturagebyr = gebyr;
		if (leiested.equals(retursted)) {fakturagebyr = 0;} 
			
		Date forfallsDato = Timestamp.valueOf(inn_dato.plusDays(14));
		faktura = new Faktura(ut_dato, inn_dato, antallDager, (double)(Prisliste.utleigepris(bil.getGruppe())), 
				fakturagebyr, (double)(Prisliste.utleigepris(bil.getGruppe())*antallDager+fakturagebyr), forfallsDato);
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
	

	
}
