
public class Test {

	public static void main(String[] args) {
		GenerazioneGriglia griglia = new GenerazioneGriglia (10, 10);
		griglia.inserisciNellaGriglia();
		System.out.println(griglia);
		GenerazioneGriglia.faiUnTurno(griglia);
		System.out.println(griglia);
	}
}
