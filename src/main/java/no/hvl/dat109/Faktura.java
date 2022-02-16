package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.Date;

public class Faktura {

	private LocalDateTime ut_dato, inn_dato;
	private int antallDager;
	private double leiePris;
	private double gebyr;
	private double totalPris;
	private Date forfallsDato;
	
	public Faktura(LocalDateTime ut_dato, LocalDateTime inn_dato, int antalDager, double leiePris, double gebyr,
			double totalPris, Date forfallsDato) {
		this.ut_dato = ut_dato;
		this.inn_dato = inn_dato;
		this.antallDager = antalDager;
		this.leiePris = leiePris;
		this.gebyr = gebyr;
		this.totalPris = totalPris;
		this.forfallsDato = forfallsDato;
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

	public int getAntalDager() {
		return antallDager;
	}

	public void setAntalDager(int antalDager) {
		this.antallDager = antalDager;
	}

	public double getLeiePris() {
		return leiePris;
	}

	public void setLeiePris(double leiePris) {
		this.leiePris = leiePris;
	}

	public double getGebyr() {
		return gebyr;
	}

	public void setGebyr(double gebyr) {
		this.gebyr = gebyr;
	}

	public double getTotalPris() {
		return totalPris;
	}

	public void setTotalPris(double totalPris) {
		this.totalPris = totalPris;
	}

	public Date getForfallsDato() {
		return forfallsDato;
	}

	public void setForfallsDato(Date forfallsDato) {
		this.forfallsDato = forfallsDato;
	}
	
	
	
	
	
}
