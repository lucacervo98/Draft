import java.util.Random;

public class AnimaleAccoppiamento extends Animale {
	private Random rnd = new Random();
	private boolean accoppiato;

	public AnimaleAccoppiamento(int x, int y) {
		super(x, y);
		accoppiato = false;
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
			for (int j = 0; j < s.getListaCibo().size(); j++) {
				if (s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, x, y)
						&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY()
								+ y] == s.getListaCibo().get(j)) {
					s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + x][s.getListaAnimaleAcc().get(i).getY()
							+ y] = s.getListaAnimaleAcc().get(i);
					s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()] = null;
					s.getListaAnimaleAcc().get(i).setSpostamenti(s.getListaAnimaleAcc().get(i).getSpostamenti() + 1);
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + x);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + y);
					s.getListaCibo().remove(j);
					check = true;
					break;
				}
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
	}

	public void checkAccoppiamento(GenerazioneGriglia s, int i) throws EccezioneGrigliaPiena {

		if (s.getListaAnimaleAcc().get(i).getSpostamenti() > 5 && s.getListaAnimaleAcc().get(i).getSpostamenti() < 20
				&& !s.getListaAnimaleAcc().get(i).isAccoppiato()) {

			for (int k = -1; k <= 1; k++) {
				for (int z = -1; z <= 1; z++) {
					for (int q = 0; q < s.getListaAnimaleAcc().size(); q++) {
						if ((k != 0 || z != 0) && s.getListaAnimaleAcc().get(i).checkEstremiAnimAcc(s, i, k, z)
								&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + k][s.getListaAnimaleAcc()
										.get(i).getY() + z] == s.getListaAnimaleAcc().get(q)
								&& !s.getListaAnimaleAcc().get(q).isAccoppiato()) {

							boolean check = false;

							do {
								int x = rnd.nextInt(s.getRighe());
								int y = rnd.nextInt(s.getColonne());
								if (s.getGriglia()[x][y] == null) {
									AnimaleAccoppiamento animaleAcc = new AnimaleAccoppiamento(x, y);
									s.getListaAnimaleAcc().get(i).setAccoppiato(true);
									s.getListaAnimaleAcc().get(q).setAccoppiato(true);
									animaleAcc.setAccoppiato(true);
									s.getGriglia()[x][y] = animaleAcc;
									s.getListaAnimaleAcc().add(animaleAcc);
									check = true;
									break;
								}
								for (int j = 0; j < s.getListaCibo().size(); j++) {
									if (s.getGriglia()[x][y] == s.getListaCibo().get(j)) {
										AnimaleAccoppiamento animaleAcc = new AnimaleAccoppiamento(x, y);
										s.getListaAnimaleAcc().get(i).setAccoppiato(true);
										s.getListaAnimaleAcc().get(q).setAccoppiato(true);
										animaleAcc.setAccoppiato(true);
										animaleAcc.setSpostamenti(12);
										s.getGriglia()[x][y] = animaleAcc;
										s.getListaAnimaleAcc().add(animaleAcc);
										s.getListaCibo().remove(j);
										check = true;
										break;
									}
								}

								if (s.checkGrigliaPiena()) {
									check = true;
									throw new EccezioneGrigliaPiena();
								}
							} while (check == false);
						}
					}
				}
			}
		}
	}

	// metodi get e set

	public boolean isAccoppiato() {
		return accoppiato;
	}

	public void setAccoppiato(boolean accoppiato) {
		this.accoppiato = accoppiato;
	}

	public String toString() {
		return "[a]";
	}
}
