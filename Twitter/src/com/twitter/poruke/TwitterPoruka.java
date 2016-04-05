package com.twitter.poruke;

/**
 * 
 * @author lukabaljak
 * 
 *         Klasa koja predstavlja poruku na drustvenoj mrezi Twitter. Pruza
 *         mogucnost imenovanja korisnika koji je autor neke poruke na Twitteru,
 *         kao i pravljenje same poruke. Takodje, uz pomoc njenih get metoda se
 *         moze pristupiti korisniku, kao i njegovoj poruci.
 *
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
	 * @param korisnik
	 *            Prosledjuje se metodi kako bi se vrednost ovog atributa
	 *            promenila na zeljenu vrednost.
	 * 
	 *            Metoda baca RuntimeException u slucaju da se pokusa sa unosom
	 *            nedozvoljenih vredosti za atribut korisnik. U slucaju da je
	 *            unet neki String kao parametar onda metoda postavalja vrednost
	 *            atributa korisnik na vrednost unetu kao parametar.
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * 
	 * @return Metoda vraca String sa tekstom poruke.
	 */

	public String getPoruka() {
		return poruka;
	}

	/**
	 * 
	 * @param poruka
	 *            Prosledjuje se metodi kako bi se vrednost ovog atributa
	 *            promenila na zeljenu vrednost.
	 * 
	 *            Na ovoj drustvenoj mrezi je zabranjeno da duzina poruke bude
	 *            veca od 140 karaktera zbog cega metoda baca RuntimeException u
	 *            slucaju pokusaja postavljanja vrednosti atributa poruka na
	 *            velicinu vecu od 140, kao i u slucaju da se pokusa sa
	 *            prosledjivanjem null vrednosti. Ako se unese String koji nije
	 *            null i kraci je od 140 znakova, vrednost atributa poruka se
	 *            postavlja na vrednost unetu kao parametar.
	 */

	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Metoda vraca String sa imenom korisnik i njegovom porukom na Twitteru.
	 * 
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
