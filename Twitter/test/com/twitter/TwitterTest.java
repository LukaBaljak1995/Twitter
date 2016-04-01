package com.twitter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.twitter.Twitter;

public class TwitterTest {

	@Test
	public void vratiSvePorukeTest() {
		Twitter t = new Twitter();
		t.unesi("Luka", "Poruka ");
		assertEquals(1, t.vratiSvePoruke().size());
	}

	@Test
	public void unesiTestSveOk() {
		Twitter t = new Twitter();
		t.unesi("Luka95", "Belloooo!");
		assertTrue((t.vratiSvePoruke().getLast().getKorisnik().equals("Luka95"))
				&& (t.vratiSvePoruke().getLast().getPoruka().equals("Belloooo!")));
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void unesiTestNullKorisnik() {
		Twitter t = new Twitter();
		t.unesi(null, "Haha");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void unesiTestNullPoruka() {
		Twitter t = new Twitter();
		t.unesi("Luka", null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void unesiTestEmptyKorisnik() {
		Twitter t = new Twitter();
		t.unesi("", "Haha");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void unesiTestEmptyPoruka() {
		Twitter t = new Twitter();
		t.unesi("Luka", "");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void vratiPorukeTestNullTag() {
		Twitter t = new Twitter();
		t.vratiPoruke(5, null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void vratiPorukeTestPrazanTag() {
		Twitter t = new Twitter();
		t.vratiPoruke(5, "");
	}

	@Test
	public void vratiPorukeTestSveOk(){
		Twitter t = new Twitter();
		assertTrue(t.vratiPoruke(2, "#formation").length==2);
	}
	@Test
	public void vratiPorukeTestManjeOdNula(){
		Twitter t = new Twitter();
		assertTrue(t.vratiPoruke(-22, "#formation").length==100);
	}
	
}
