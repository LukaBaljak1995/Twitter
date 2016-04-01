package com.twitter.poruke;

/**
 * 
 * @author lukabaljak
 * @version Prva verzija klase Twitter.
 */



public class TwitterPoruka {

	/**
	 * Atribut oznacava korisnicki nalog na Twitteru.
	 */
	
	private String korisnik;
	
	/**
	 * Atribut oznacava poruku korisnika na Twitteru.
	 */
	private String poruka;

	/**
	 * @return Vraca vrednost Stringa korisnik.
	 */
	
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * 
	 * @param korisnik Prosledjuje se metodi kako bi se vrednost ovog atributa promenila na zeljenu vrednost.
	 */
	
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * 
	 * @return Metoda vraca String "poruka".
	 */

	public String getPoruka() {
		return "poruka";
	}

	/**
	 * 
	 * @param poruka Prosledjuje se metodi kako bi se vrednost ovog atributa promenila na zeljenu vrednost.
	 */
	
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
	
}
