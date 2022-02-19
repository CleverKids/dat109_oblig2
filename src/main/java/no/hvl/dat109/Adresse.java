package no.hvl.dat109;

public class Adresse {
	private String gate;
	private int postNr;
	private String poststed;
	
	public Adresse() {
	}

	public Adresse(String gate, int postNr, String poststed) {
		this.gate = gate;
		this.postNr = postNr;
		this.poststed = poststed;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public int getPostNr() {
		return postNr;
	}

	public void setPostNr(int postNr) {
		this.postNr = postNr;
	}

	public String getPoststed() {
		return poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}
}
