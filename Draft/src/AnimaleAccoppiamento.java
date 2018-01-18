import java.util.Random;

public class AnimaleAccoppiamento extends Animale {
	private Random rnd = new Random();

	public AnimaleAccoppiamento(int x, int y) {
		super(x, y);
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
				s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + k);
				s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + z);
				if (s.getListaAnimaleAcc().get(i).getSpostamenti() == 0) {
					s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
					s.getListaAnimaleAcc().remove(i);
				}
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
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + k);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + z);
					check = true;
				}
			}
		} while (check == false);
	}

	public String toString() {
		String temp;
		return temp = "[a]";
	}
}
