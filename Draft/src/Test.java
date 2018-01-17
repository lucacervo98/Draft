
public class Test {

	public static void main(String[] args) {
		Turno turno = new Turno();
		
		try {
			GenerazioneGriglia griglia = new GenerazioneGriglia(5, 5);
			griglia.inserisciNellaGriglia();
			System.out.println(griglia);
			turno.faiTurni(griglia, turno, 10);
		} catch (Exception e) {
			System.out.println("Errore: inseriti valori per la griglia minori di 5.");
		}

	}
}
