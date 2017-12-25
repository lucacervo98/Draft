import java.util.Random;

public class Animale extends Pedina {
	private int spostamenti;
	private Random rnd = new Random();
	private int k = rnd.nextInt(3) - 1;
	private boolean check = false;

	public Animale(int x, int y) {
		super(x, y);
		spostamenti = 10;
	}

	// check estremi per animale che si accoppia
	public boolean checkEstremiAnimAcc(GenerazioneGriglia s, int i) {
		boolean estremiGrigliaAnimAcc = false;

		if (s.getListaAnimaleAcc().get(i).getX() + k >= 0 && s.getListaAnimaleAcc().get(i).getX() + k < s.getRighe()
				&& s.getListaAnimaleAcc().get(i).getY() + k >= 0
				&& s.getListaAnimaleAcc().get(i).getY() + k < s.getColonne()) {
			estremiGrigliaAnimAcc = true;
		}

		return estremiGrigliaAnimAcc;
	}

	/*
	 * public static boolean checkCibo(GenerazioneGriglia s) { boolean cibo = false;
	 * for (int i = 0; i < s.getListaCibo().size(); i++) {
	 * 
	 * }
	 * 
	 * }
	 */

	public void movimento(GenerazioneGriglia s, int i) {

		// while (check = true) {
		if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i)
				&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY()
						+ k] == null) {
			s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;  // svuota la casella in cui era l'animale
			s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY() + k] = s
					.getListaAnimaleAcc().get(i);     															// mette l'animale nella casella vicina random
			s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() - 1);   // diminuisce gli spostamenti dell'animale di 1
			check = true;
		}
		for (int j = 0; j < s.getListaCibo().size(); j++) {
			if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i)
					&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY()  // controlla se nella casella dove vuole andare c'è un cibo (lo cerco tramite listaCibo)
							+ k] == s.getListaCibo().get(j)) {
				s.getGriglia()[s.getListaCibo().get(j).getX()][s.getListaCibo().get(j)
						.getY()] = s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()];																				// mette nella casella dov'è il cibo l'animale
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;		// svuota la casella in cui era l'animale
				s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() + 1);		// diminuisce gli spostamenti dell'animale di 1 e li aumenta di 2 perché mangia il cibo
				check = true;
			}
		}
	}

	// }

	// metodi get e set

	public int getSpostamenti() {
		return spostamenti;
	}

	public void setSpostamenti(int spostamenti) {
		this.spostamenti = spostamenti;
	}
}
