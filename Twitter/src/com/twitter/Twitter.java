package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * @author lukabaljak Klasa koja predstavlja drustvenu mrezu Twitter.
 */
public class Twitter {
	/**
	 * Atribut u kom se nalaze poruke sa Twittera.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * @return Metoda vraca listu sa svim Twitter porukama.
	 */

	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * 
	 * @param korisnik
	 *            Onaj koji pise poruku.
	 * @param poruka
	 *            Sama ta poruka. Pravi se nova poruka i puni podacima nakon
	 *            cega se unosi na kraj liste.
	 * 
	 */
	public void unesi(String korisnik, String poruka) {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		poruke.addLast(tp);
	}

	/**
	 * 
	 * @param maxBroj
	 *            Predstavlja broj dozvoljenih Twitter poruka sa zadatim tagom.
	 * @param tag
	 *            Predstavlja onaj tag koji se trazi.
	 * @return Vraca se lista sa svim Twitter porukama koje sadrze trazeni tag.
	 * 
	 *         Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
	 *         Dodat je pomocni niz koja predstavlja rezultat pretrage tj.
	 *         sadrzace sve poruke koje u sebi imaju zadati tag. Pretrazuju se
	 *         poruke i traze se one koje sadrze tag. Ako se nadje neka takva, i
	 *         ako nije prekoracen maxBroj ona se upisuje u niz. Ako je
	 *         prekoracen maxBroj,pretraga se prekida.
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		if (maxBroj <= 0)
			maxBroj = 100;
		int brojac = 0;
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}

}
