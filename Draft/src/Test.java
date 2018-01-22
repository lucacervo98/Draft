import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Turno turno = new Turno();
		Properties p = new Properties();

		GenerazioneGriglia griglia = null;

		try {
			InputStream is = new FileInputStream("Config.properties");
			p.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("Errore: file di configurazione mancante.");
		} catch (IOException e) {
			System.out.println("Errore durante la lettura del file.");
		}

		try {
			Integer.parseInt(p.getProperty("righe").trim());
			Integer.parseInt(p.getProperty("colonne").trim());
			Integer.parseInt(p.getProperty("turni").trim());
			Integer.parseInt(p.getProperty("animali_che_si_accoppiano").trim());
			Integer.parseInt(p.getProperty("animali_che_si_clonano").trim());

			try {
				griglia = new GenerazioneGriglia(Integer.parseInt(p.getProperty("righe").trim()),
						Integer.parseInt(p.getProperty("colonne").trim()));
				griglia.inserisciNellaGriglia(griglia,
						Integer.parseInt(p.getProperty("animali_che_si_accoppiano").trim()),
						Integer.parseInt(p.getProperty("animali_che_si_clonano").trim()));
				System.out.println("\n" + "Inizia il gioco!" + "\n");
				System.out.println(griglia);
				turno.faiTurni(griglia, turno, Integer.parseInt(p.getProperty("turni").trim()));
			} catch (EccezioneGrigliaInferiore5x5 e) {
				System.out.println("Errore: inseriti valori per la griglia minori di 5.");
			} catch (EccezioneTurniNegativi e) {
				System.out.println("Errore: inserito numero turni negativi o uguale a 0.");
			} catch (EccezioneGrigliaPienaAInizioGioco e) {
				System.out.println("Errore: inseriti valori troppo alti per gli animali iniziali.");
			} catch (EccezioneAnimaliNegativiOUgualiAZero e) {
				System.out.println("Errore: inserito numero negativo o uguale a 0 per la creazione di uno o più animali.");
			} catch (EccezioneGrigliaPiena e) {
				System.out.println(griglia);
				System.out.println("Fine del gioco: griglia piena.");
				System.out.println("\n" + "Sono rimasti "+griglia.getListaAnimaleAcc().size()+" animali che si accoppiano."+"\n"+"Sono rimasti "+griglia.getListaAnimaleClon().size()+" animali che si clonano.");
			}

		} catch (NumberFormatException e) {
			System.out.println(
					"Errore: uno o più dati non inseriti o inseriti non correttamente nel file di configurazione.");
		}
	}
}
