import java.util.ArrayList;
import java.util.Random;

public class GenerazioneGriglia {
	private int righe;
	private int colonne;
	private Pedina[][] griglia;
	private ArrayList<Cibo> listaCibo = new ArrayList<Cibo>();
	private ArrayList<AnimaleAccoppiamento> listaAnimaleAcc = new ArrayList<AnimaleAccoppiamento>();
	private ArrayList<AnimaleClonazione> listaAnimaleClon = new ArrayList<AnimaleClonazione>();
	private Random rnd = new Random();

	// costruttore della griglia (minimo 5x5)
	public GenerazioneGriglia(int righe, int colonne) throws EccezioneGrigliaInferiore5x5 {

		if (righe >= 5 && colonne >= 5) {
			griglia = new Pedina[righe][colonne];

			this.righe = righe;
			this.colonne = colonne;
		} else
			throw new EccezioneGrigliaInferiore5x5();
	}

	// fa spawnare nella griglia gli oggetti
	public void inserisciNellaGriglia(GenerazioneGriglia s, int n, int m)
			throws EccezioneGrigliaPienaAInizioGioco, EccezioneAnimaliNegativi {

		int caselle = righe * colonne;
		int met‡Griglia = caselle / 2;

		// cibo (al massimo la met‡ della griglia)
		for (int i = 0; i < met‡Griglia; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				Cibo cibo = new Cibo(x, y);
				listaCibo.add(cibo);
				griglia[x][y] = cibo;
			}
		}

		// animali che si accoppiano
		if (n >= 0) {
			for (int i = 0; i < n; i++) {
				boolean check = false;
				do {
					int x = rnd.nextInt(righe);
					int y = rnd.nextInt(colonne);
					if (griglia[x][y] == null) {
						AnimaleAccoppiamento animaleAcc = new AnimaleAccoppiamento(x, y);
						listaAnimaleAcc.add(animaleAcc);
						griglia[x][y] = animaleAcc;
						check = true;
						break;
					}
					if (s.checkGrigliaPienaPerPopolamento()) {
						check = true;
						throw new EccezioneGrigliaPienaAInizioGioco();
					}
				} while (check == false);
			}
		} else {
			throw new EccezioneAnimaliNegativi();
		}

		// animali che si clonano
		if (m >= 0) {
			for (int j = 0; j < m; j++) {
				boolean check = false;
				do {
					int x = rnd.nextInt(righe);
					int y = rnd.nextInt(colonne);
					if (griglia[x][y] == null) {
						AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
						listaAnimaleClon.add(animaleClon);
						griglia[x][y] = animaleClon;
						check = true;
						break;
					}
					if (s.checkGrigliaPienaPerPopolamento()) {
						check = true;
						throw new EccezioneGrigliaPienaAInizioGioco();
					}
				} while (check == false);
			}
		} else {
			throw new EccezioneAnimaliNegativi();
		}
	}

	public boolean checkGrigliaPiena() {
		boolean check = false;
		int caselle = righe * colonne;

		if (caselle == listaAnimaleAcc.size() + listaAnimaleClon.size()) {
			check = true;
		}
		return check;
	}

	public boolean checkGrigliaPienaPerPopolamento() {
		boolean check = true;

		for (int i = 0; i < righe; i++) {
			for (int j = 0; j < colonne; j++) {

				if (griglia[i][j] == null) {
					check = false;
					break;
				}
			}
			if (check == false)
				break;
		}
		return check;
	}

	// metodi Get()

	public Pedina[][] getGriglia() {
		return griglia;
	}

	public ArrayList<Cibo> getListaCibo() {
		return listaCibo;
	}

	public ArrayList<AnimaleAccoppiamento> getListaAnimaleAcc() {
		return listaAnimaleAcc;
	}

	public ArrayList<AnimaleClonazione> getListaAnimaleClon() {
		return listaAnimaleClon;
	}

	public int getRighe() {
		return righe;
	}

	public int getColonne() {
		return colonne;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < righe; i++) {
			for (int j = 0; j < colonne; j++) {
				if (griglia[i][j] == null)
					temp += "[ ]" + " ";
				else
					temp += griglia[i][j] + " ";

			}
			temp += "\n";
		}
		return temp;
	}
}
