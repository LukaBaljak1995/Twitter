package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * @author lukabaljak 
 * 		   
 * 			Klasa koja predstavlja drustvenu mrezu Twitter.
 * 			Sluzi sa pravljenje novih poruka na Twitteru, kao
 * 			i za pretrazivanje svih unetih poruka u odnosu na 
 * 			zeljeni tag, kako bi se korisniku prikazale sve 
 * 			poruke koje sadrze zeljeni tag.
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
	 *            Sama ta poruka. 
	 * 
	 *     	 Pravi se Twitter poruka sa korisnikom i porukom koji
	 *     	 su prosledjeni kao parametri. Nakon sto se napravi
	 *       Twitter poruka ona se smesta na kraj liste poruka.
	 * 
	 */
	public void unesi(String korisnik, String poruka) {
		if (korisnik == null || poruka == null || korisnik.isEmpty() || poruka.isEmpty()) {
			throw new RuntimeException("Morate uneti korisnika i poruku.");
		}
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
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
	 *         Ova metoda pretrazuje listu Twitter poruka i pronalazi 
	 *         one u kojima se nalazi tag koji se trazi. Postavlja se 
	 *         maksimalan broj poruka koje mogu da budu rezultat pretrage.
	 *    	   Poruke sa trazenim tagom se smestaju u pomocni niz koji 
	 *    	   metoda vraca kao povratnu vrednost. Ukoliko postoji vise 
	 *         poruka sa trazenim tagom od maksimalnog broja poruka, 
	 *         pretraga se prekida.
	 *         
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
