package no.hvl.dat109;

import java.util.HashMap;

public class Prisliste {
	
	
	
	private static HashMap<Gruppe, Integer> katPris = new HashMap<Gruppe, Integer>();
	static {
	katPris.put(Gruppe.A, 1000);
	katPris.put(Gruppe.B, 2000);
	katPris.put(Gruppe.C, 3000);
	katPris.put(Gruppe.D, 4000);
	}
	public Prisliste() {
//		kat_priser();
		

	}
	
	public static int utleigepris(Gruppe gruppe) {
		return katPris.get(gruppe);
	}
	
	private static void kat_priser() {
		katPris.put(Gruppe.A, 1000);
		katPris.put(Gruppe.B, 2000);
		katPris.put(Gruppe.C, 3000);
		katPris.put(Gruppe.D, 4000);
	}

	public static void setKatPris(HashMap<Gruppe, Integer> katPris) {
		Prisliste.katPris = katPris;
	}
	
	
}
