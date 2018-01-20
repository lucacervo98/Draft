import java.util.Random;
import java.util.ArrayList;

public class GenerazioneGriglia {
	private int righe;
	private int colonne;
	private Pedina[][] griglia;
	private ArrayList<Cibo> listaCibo = new ArrayList();
	private ArrayList<AnimaleAccoppiamento> listaAnimaleAcc = new ArrayList();
	private ArrayList<AnimaleClonazione> listaAnimaleClon = new ArrayList();
	private Random rnd = new Random();

	// costruttore della griglia (minimo 5x5)
	public GenerazioneGriglia(int righe, int colonne) /*throws Exception*/ {

		if (righe >= 5 && colonne >= 5) {
			griglia = new Pedina[righe][colonne];

			this.righe = righe;
			this.colonne = colonne;
		} else
			new Exception();
	}

	// fa spawnare nella griglia gli oggetti
	public void inserisciNellaGriglia() {

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

		// animale che si accoppia (al massimo la met‡ della met‡ della griglia + 1)
		for (int i = 0; i < met‡Griglia / 2 + 1; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				AnimaleAccoppiamento animaleAcc = new AnimaleAccoppiamento(x, y);
				listaAnimaleAcc.add(animaleAcc);
				griglia[x][y] = animaleAcc;
			}
		}

		// animale che si clona (al massimo la met‡ della met‡ della griglia + 1)
		for (int i = 0; i < met‡Griglia / 2 + 1; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
				listaAnimaleClon.add(animaleClon);
				griglia[x][y] = animaleClon;
			}
		}
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
