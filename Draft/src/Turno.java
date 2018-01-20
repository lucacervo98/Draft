
public class Turno {

	// fa più turni
	public void faiTurni(GenerazioneGriglia s, Turno t, int n) {
		while (n > 0) {
			System.out.println("°°°°°°°°°°°°°°°°°°°");
			t.faiUnTurno(s);
			n = n - 1;
		}
		if (s.getListaAnimaleAcc().size() == 0 && s.getListaAnimaleClon().size() == 0) {
			System.out.println("Tutti gli animali sono morti.");
		} else {
			System.out.println("Gli animali che si accoppiano sono rimasti: " + s.getListaAnimaleAcc().size() + ".\n"
					+ "Gli animali che si clonano sono rimasti: " + s.getListaAnimaleClon().size() + ".");
		}
	}

	// fa un turno, ovvero fa spostare ogni animale presente nelle liste
	public void faiUnTurno(GenerazioneGriglia s) {
		for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
			s.getListaAnimaleAcc().get(i).movimentoAnimaleAcc(s, i);
		}
		for (int j = 0; j < s.getListaAnimaleClon().size(); j++) {
			s.getListaAnimaleClon().get(j).movimentoAnimaleClon(s, j);
		}
		System.out.println(s);
	}

}
