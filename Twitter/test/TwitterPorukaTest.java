import static org.junit.Assert.*;

import org.junit.Test;
import com.twitter.poruke.*;

public class TwitterPorukaTest {

	@Test(expected = java.lang.RuntimeException.class)
	public void setKorisnikTestNull() {
		TwitterPoruka tw = new TwitterPoruka();
		tw.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void setKorisnikTestPrazanString() {
		TwitterPoruka tw = new TwitterPoruka();
		tw.setKorisnik("");
	}

	@Test
	public void setKorisnikTestSveOk() {
		TwitterPoruka tp = new TwitterPoruka();
		String korisnik = "Luka95";
		tp.setKorisnik(korisnik);
		assertEquals(korisnik, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void setPorukaTestNull() {
		TwitterPoruka tw = new TwitterPoruka();
		tw.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void setPorukaTestVeciTekst() {
		TwitterPoruka tw = new TwitterPoruka();
		int i = 0;
		String poruka = "";
		while (i < 150) {
			poruka = poruka + "A";
			i++;
		}
		tw.setPoruka(poruka);
	}

	@Test
	public void setPorukaTestSveOk() {
		TwitterPoruka tp = new TwitterPoruka();
		String poruka = "Formation";
		tp.setPoruka(poruka);
		assertEquals(poruka, tp.getPoruka());
	}

	@Test
	public void toStringTest() {
		TwitterPoruka tp = new TwitterPoruka();
		String korisnik = "Luka95";
		String poruka = "Bello";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		assertEquals("KORISNIK:" + korisnik + " PORUKA:" + poruka, tp.toString());
	}

}
