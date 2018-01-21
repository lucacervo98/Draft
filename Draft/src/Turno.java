
public class Turno {

	// fa più turni
	public void faiTurni(GenerazioneGriglia s, Turno t, int n) throws EccezioneGrigliaPiena, EccezioneTurniNegativi {
		if (n > 0) {
			while (n > 0) {
				System.out.println("°°°°°°°°°°°°°°°°°°°");
				t.faiUnTurno(s);
				n = n - 1;
			}
			System.out.println("Fine del gioco!" + "\n");
			if (s.getListaAnimaleAcc().size() == 0 && s.getListaAnimaleClon().size() == 0) {
				System.out.println("Tutti gli animali sono morti.");
			} else {
				System.out.println("Gli animali che si accoppiano sono rimasti: " + s.getListaAnimaleAcc().size()
						+ ".\n" + "Gli animali che si clonano sono rimasti: " + s.getListaAnimaleClon().size() + ".");
			}
		}

		else {
			throw new EccezioneTurniNegativi();
		}
	}

	// fa un turno, ovvero fa spostare ogni animale presente nelle liste
	public void faiUnTurno(GenerazioneGriglia s) throws EccezioneGrigliaPiena {
		for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
			s.getListaAnimaleAcc().get(i).movimentoAnimaleAcc(s, i);
			if (s.checkGrigliaPiena())
				throw new EccezioneGrigliaPiena();
		}
		for (int j = 0; j < s.getListaAnimaleClon().size(); j++) {
			s.getListaAnimaleClon().get(j).movimentoAnimaleClon(s, j);
			if (s.checkGrigliaPiena())
				throw new EccezioneGrigliaPiena();
		}
		for (int k = 0; k < s.getListaAnimaleClon().size(); k++) {
			s.getListaAnimaleClon().get(k).checkClonazione(s, k);
			if (s.checkGrigliaPiena())
				throw new EccezioneGrigliaPiena();
		}
		for (int l = 0; l < s.getListaAnimaleAcc().size(); l++) {
			s.getListaAnimaleAcc().get(l).checkAccoppiamento(s, l);
			if (s.checkGrigliaPiena())
				throw new EccezioneGrigliaPiena();
		}
		for (int o = 0; o < s.getListaAnimaleAcc().size(); o++) {
			s.getListaAnimaleAcc().get(o).setAccoppiato(false);
		}
		System.out.println(s);
	}
}
