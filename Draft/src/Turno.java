
public class Turno {
	
	// fa più turni
		public void faiTurni(GenerazioneGriglia s, Turno t, int n) {
			while (n > 0) {
				t.faiUnTurno(s);
				n = n - 1;
			}
		}

		// fa un turno, ovvero fa spostare ogni animale presente nelle liste
		public void faiUnTurno(GenerazioneGriglia s) {
			for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
				s.getListaAnimaleAcc().get(i).movimentoAnimaleAcc(s, i);
			}
			for (int j = 0; j < s.getListaAnimaleClon().size(); j++) {
				s.getListaAnimaleClon().get(j).movimentoAnimaleClon(s, j);
				// mancano gli altri animali
			}
			System.out.println(s);
		}

}
