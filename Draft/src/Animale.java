import java.util.Random;

public class Animale extends Pedina {
	private int spostamenti;
	private Random rnd = new Random();

	public Animale(int x, int y) {
		super(x, y);
		spostamenti = 10;
	}

	// check estremi per animale che si accoppia
	public boolean checkEstremiAnimAcc(GenerazioneGriglia s, int i, int k, int z) {
		boolean estremiGrigliaAnimAcc = false;

		if (s.getListaAnimaleAcc().get(i).getX() + k >= 0 && s.getListaAnimaleAcc().get(i).getX() + k < s.getRighe()
				&& s.getListaAnimaleAcc().get(i).getY() + z >= 0
				&& s.getListaAnimaleAcc().get(i).getY() + z < s.getColonne()) {
			estremiGrigliaAnimAcc = true;
		}

		return estremiGrigliaAnimAcc;
	}

	// check estremi per animale che si clona
	public boolean checkEstremiAnimClon(GenerazioneGriglia s, int i, int k, int z) {
		boolean estremiGrigliaAnimClon = false;

		if (s.getListaAnimaleClon().get(i).getX() + k >= 0 && s.getListaAnimaleClon().get(i).getX() + k < s.getRighe()
				&& s.getListaAnimaleClon().get(i).getY() + z >= 0
				&& s.getListaAnimaleClon().get(i).getY() + z < s.getColonne()) {
			estremiGrigliaAnimClon = true;
		}
		return estremiGrigliaAnimClon;
	}

	/*
	 * public static boolean checkCibo(GenerazioneGriglia s) { boolean cibo = false;
	 * for (int i = 0; i < s.getListaCibo().size(); i++) {
	 * 
	 * }
	 * 
	 * }
	 */
	
	// movimento animale che si accoppia (casella vuota o casella col cibo)
	public void movimentoAnimaleAcc(GenerazioneGriglia s, int i) {
		boolean check = false;
		do {
			int k = rnd.nextInt(3) - 1;
			int z = rnd.nextInt(3) - 1;
			if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, k, z) && (k != 0 || z != 0)
					&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY()
							+ z] == null) {
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY() + z] = s
						.getListaAnimaleAcc().get(i);
				s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() - 1);
				check = true;
				break;
			}
			for (int j = 0; j < s.getListaCibo().size(); j++) {
				if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, k, z) && (k != 0 || z != 0)
						&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc().get(i).getY()
								+ z] == s.getListaCibo().get(j)) {
					s.getGriglia()[s.getListaCibo().get(j).getX()][s.getListaCibo().get(j)
							.getY()] = s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc()
									.get(i).getY()];
					s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
					s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() + 1);
					check = true;
				}
			}
		} while (check == false);

	}

	// movimento animale che si clona (casella vuota o casella col cibo)
	public void movimentoAnimaleClon(GenerazioneGriglia s, int i) {
		boolean check = false;
		do {
			int k = rnd.nextInt(3) - 1;
			int z = rnd.nextInt(3) - 1;
			if (s.getListaAnimaleClon().get(i).checkEstremiAnimClon(s, i, k, z) && (k != 0 || z != 0)
					&& s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + k][s.getListaAnimaleClon().get(i).getY()
							+ z] == null) {
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + k][s.getListaAnimaleClon().get(i).getY() + z] = s
						.getListaAnimaleClon().get(i);
				s.getListaAnimaleClon().get(i).setSpostamenti(s.getListaAnimaleClon().get(i).getSpostamenti() - 1);
				check = true;
				break;
			}
			for (int j = 0; j < s.getListaCibo().size(); j++) {
				if (s.getListaAnimaleClon().get(i).checkEstremiAnimClon(s, i, k, z) && (k != 0 || z != 0)
						&& s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + k][s.getListaAnimaleClon().get(i)
								.getY() + z] == s.getListaCibo().get(j)) {
					s.getGriglia()[s.getListaCibo().get(j).getX()][s.getListaCibo().get(j)
							.getY()] = s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon()
									.get(i).getY()];
					s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
					s.getListaAnimaleClon().get(i).setSpostamenti(s.getListaAnimaleClon().get(i).getSpostamenti() + 1);
					check = true;
				}
			}
		} while (check == false);

	}

	// metodi get e set

	public int getSpostamenti() {
		return spostamenti;
	}

	public void setSpostamenti(int spostamenti) {
		this.spostamenti = spostamenti;
	}
}
