package no.hvl.dat109;

public class Bil {

	
	private int regNr;
	private String merke;
	private String modell;
	private Farge farge;
	private Gruppe gruppe;
	private boolean ledig;
	private double km;


	public Bil (int regNr, String merke, String bilmodell, Farge farge, Gruppe Gruppe, boolean ledig, int km) {
		this.regNr =  regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.gruppe = gruppe;
		this.ledig = ledig;
		this.km = km;
	}


	public int getRegNr() {
		return regNr;
	}


	public void setRegNr(int regNr) {
		this.regNr = regNr;
	}


	public String getMerke() {
		return merke;
	}


	public String getModell() {
		return modell;
	}


	public void setModell(String modell) {
		this.modell = modell;
	}


	public Farge getFarge() {
		return farge;
	}


	public Gruppe getGruppe() {
		return gruppe;
	}


	public boolean isLedig() {
		return ledig;
	}


	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}


	public double getKm() {
		return km;
	}


	public void setKm(double km) {
		this.km = km;
	}
	
	
}