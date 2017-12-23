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
	private Random rndSeed = new Random(5); //oppure rnd.ints(numero origine, numero massimo+1) ???

	//costruttore della griglia (minimo 5x5)
	public GenerazioneGriglia(int righe, int colonne) {

		if (righe >= 5 && colonne >= 5)
			griglia = new Pedina[righe][colonne];

		this.righe = righe;
		this.colonne = colonne;

	}

	//fa spawnare nella griglia gli oggetti
	public void inserisciNellaGriglia() {

		int caselle = righe * colonne;
		int met‡Griglia = caselle / 2;
		int randomAnimali = rndSeed.nextInt(met‡Griglia);

		//cibo (al massimo la met‡ della griglia)
		for (int i = 0; i < met‡Griglia; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				Cibo cibo = new Cibo(x, y);
				listaCibo.add(cibo);
				griglia[x][y] = cibo;
			}
		}

		//animale che si accoppia (min 5, se non trova nessuno nelle caselle, al max met‡ griglia) 
		for (int i = 0; i < randomAnimali; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				AnimaleAccoppiamento animaleAcc = new AnimaleAccoppiamento(x, y);
				listaAnimaleAcc.add(animaleAcc);
				griglia[x][y] = animaleAcc;
			}
		}

		//animale che si clona (min 5, se non trova nessuno nelle caselle, al max met‡ griglia)
		for (int i = 0; i < randomAnimali; i++) {
			int x = rnd.nextInt(righe);
			int y = rnd.nextInt(colonne);
			if (griglia[x][y] == null) {
				AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
				listaAnimaleClon.add(animaleClon);
				griglia[x][y] = animaleClon;
			}
		}
	}

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
	
	public void svolgereTurno() {
		
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
