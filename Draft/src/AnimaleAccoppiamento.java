import java.util.Random;

public class AnimaleAccoppiamento extends Animale {
	private Random rnd = new Random();

	public AnimaleAccoppiamento(int x, int y) {
		super(x, y);
	}

	// check estremi per animale che si accoppia
	public boolean checkEstremiAnimAcc(GenerazioneGriglia s, int i, int x, int y) {
		boolean estremiGrigliaAnimAcc = false;

		if (s.getListaAnimaleAcc().get(i).getX() + x >= 0 && s.getListaAnimaleAcc().get(i).getX() + x < s.getRighe()
				&& s.getListaAnimaleAcc().get(i).getY() + y >= 0
				&& s.getListaAnimaleAcc().get(i).getY() + y < s.getColonne()) {
			estremiGrigliaAnimAcc = true;
		}

		return estremiGrigliaAnimAcc;
	}

	// movimento animale che si accoppia (casella vuota o casella col cibo)
	public void movimentoAnimaleAcc(GenerazioneGriglia s, int i) {
		boolean check = false;

		do {
			int x = rnd.nextInt(3) - 1;
			int y = rnd.nextInt(3) - 1;

			if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, x, y)
					&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY()
							+ y] == null) {
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY() + y] = s
						.getListaAnimaleAcc().get(i);
				s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() - 1);
				s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + x);
				s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + y);
				check = true;
				break;
			}
			if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, x, y)
					&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY()
							+ y] instanceof Cibo) {
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY() + y] = s
						.getListaAnimaleAcc().get(i);
				s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
				s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() + 1);
				s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + x);
				s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + y);
				check = true;
				break;
			}
			if (x == 0 && y == 0) {
				check = true;
			}

		} while (check == false);

		// check morte
		if (s.getListaAnimaleAcc().get(i).getSpostamenti() == 0) {
			s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
			s.getListaAnimaleAcc().remove(i);
		}

		/*
		 * if (s.getListaAnimaleAcc().get(i).getSpostamenti() > 5 &&
		 * s.getListaAnimaleAcc().get(i).getSpostamenti() < 20) { boolean check2 =
		 * false; int k = rnd.nextInt(3) - 1; int z = rnd.nextInt(3) - 1; int x =
		 * s.getListaAnimaleAcc().get(i).getX() + k; int y =
		 * s.getListaAnimaleAcc().get(i).getY() + z;
		 * 
		 * // do { if (x >= 0 && x <= s.getRighe() - 1 && y >= 0 && y <= s.getColonne()
		 * - 1 && s.getGriglia()[x][y] == null && (k != 0 || z != 0)) { for (int q = -1;
		 * q < 2; q++) { for (int w = -1; w < 2; w++) { if
		 * (s.getListaAnimaleAcc().get(i).getX() + q >= 0 &&
		 * s.getListaAnimaleAcc().get(i).getX() + q < s.getRighe() - 1 &&
		 * s.getListaAnimaleAcc().get(i).getY() + w >= 0 &&
		 * s.getListaAnimaleAcc().get(i).getY() + w < s.getColonne() - 1 &&
		 * s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() +
		 * q][s.getListaAnimaleAcc() .get(i).getY() + w] instanceof
		 * AnimaleAccoppiamento) { AnimaleAccoppiamento animaleAcc = new
		 * AnimaleAccoppiamento(x, y);
		 * s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() +
		 * x][s.getListaAnimaleAcc().get(i) .getY() + y] = animaleAcc; check2 = true; }
		 * } } } }
		 */
		// } while (check2 == false);
	}

	public String toString() {
		return "[a]";
	}
}
