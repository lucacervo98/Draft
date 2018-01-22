import java.util.Random;

public class AnimaleClonazione extends Animale {
	private Random rnd = new Random();

	public AnimaleClonazione(int x, int y) {
		super(x, y);
	}

	// check estremi per animale che si clona
	public boolean checkEstremiAnimClon(GenerazioneGriglia s, int i, int x, int y) {
		boolean estremiGrigliaAnimClon = false;

		if (s.getListaAnimaleClon().get(i).getX() + x >= 0 && s.getListaAnimaleClon().get(i).getX() + x < s.getRighe()
				&& s.getListaAnimaleClon().get(i).getY() + y >= 0
				&& s.getListaAnimaleClon().get(i).getY() + y < s.getColonne()) {
			estremiGrigliaAnimClon = true;
		}
		return estremiGrigliaAnimClon;
	}

	// movimento animale che si clona (casella vuota o casella col cibo)
	public void movimentoAnimaleClon(GenerazioneGriglia s, int i) {
		boolean check = false;
		do {
			int x = rnd.nextInt(3) - 1;
			int y = rnd.nextInt(3) - 1;

			if (s.getListaAnimaleClon().get(i).checkEstremiAnimClon(s, i, x, y)
					&& s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i).getY()
							+ y] == null) {
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i).getY() + y] = s
						.getListaAnimaleClon().get(i);
				s.getListaAnimaleClon().get(i).setSpostamenti(s.getListaAnimaleClon().get(i).getSpostamenti() - 1);
				s.getListaAnimaleClon().get(i).setX(s.getListaAnimaleClon().get(i).getX() + x);
				s.getListaAnimaleClon().get(i).setY(s.getListaAnimaleClon().get(i).getY() + y);
				check = true;
				break;
			}
			for (int j = 0; j < s.getListaCibo().size(); j++) {
				if (s.getListaAnimaleClon().get(i).checkEstremiAnimClon(s, i, x, y)
						&& s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i)
								.getY() + y] == s.getListaCibo().get(j)) {
					s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i).getY()
							+ y] = s.getListaAnimaleClon().get(i);
					s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
					s.getListaAnimaleClon().get(i).setSpostamenti(s.getListaAnimaleClon().get(i).getSpostamenti() + 1);
					s.getListaAnimaleClon().get(i).setX(s.getListaAnimaleClon().get(i).getX() + x);
					s.getListaAnimaleClon().get(i).setY(s.getListaAnimaleClon().get(i).getY() + y);
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
		if (s.getListaAnimaleClon().get(i).getSpostamenti() == 0) {
			s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
			s.getListaAnimaleClon().remove(i);
		}
	}

	// check clonazione
	public void checkClonazione(GenerazioneGriglia s, int i) throws EccezioneGrigliaPiena {
		if (s.getListaAnimaleClon().get(i).getSpostamenti() > 20) {
			boolean check = false;

			do {
				int x = rnd.nextInt(s.getRighe());
				int y = rnd.nextInt(s.getColonne());

				if (s.getGriglia()[x][y] == null) {
					AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
					s.getGriglia()[x][y] = animaleClon;
					s.getListaAnimaleClon().get(i).setSpostamenti(10);
					s.getListaAnimaleClon().add(animaleClon);
					check = true;
					break;
				}

				for (int j = 0; j < s.getListaCibo().size(); j++) {
					if (s.getGriglia()[x][y] == s.getListaCibo().get(j)) {
						AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
						animaleClon.setSpostamenti(12);
						s.getGriglia()[x][y] = animaleClon;
						s.getListaAnimaleClon().get(i).setSpostamenti(10);
						s.getListaAnimaleClon().add(animaleClon);
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

	public String toString() {
		return "[c]";
	}

}
