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
			if (s.getListaAnimaleClon().get(i).checkEstremiAnimClon(s, i, x, y)
					&& s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i).getY()
							+ y] instanceof Cibo) {
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX() + x][s.getListaAnimaleClon().get(i).getY() + y] = s
						.getListaAnimaleClon().get(i);
				s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
				s.getListaAnimaleClon().get(i).setSpostamenti(s.getListaAnimaleClon().get(i).getSpostamenti() + 1);
				s.getListaAnimaleClon().get(i).setX(s.getListaAnimaleClon().get(i).getX() + x);
				s.getListaAnimaleClon().get(i).setY(s.getListaAnimaleClon().get(i).getY() + y);
				check = true;
				break;
			}
			if (x == 0 && y == 0) {
				check = true;
			}
			
		} while (check == false);

		// check clonazione
		if (s.getListaAnimaleClon().get(i).getSpostamenti() > 20) {
			boolean check2 = false;
			do {
				int k = rnd.nextInt(3) - 1;
				int z = rnd.nextInt(3) - 1;
				int x = s.getListaAnimaleClon().get(i).getX() + k;
				int y = s.getListaAnimaleClon().get(i).getY() + z;

				if (x >= 0 && x < s.getRighe() && y >= 0 && y < s.getColonne() && s.getGriglia()[x][y] == null
						&& (k != 0 || z != 0)) {
					AnimaleClonazione animaleClon = new AnimaleClonazione(x, y);
					s.getGriglia()[x][y] = animaleClon;
					s.getListaAnimaleClon().get(i).setSpostamenti(10);
					s.getListaAnimaleClon().add(animaleClon);
					check2 = true;
				}
			} while (check2 == false);
		}

		// check morte
		if (s.getListaAnimaleClon().get(i).getSpostamenti() == 0) {
			s.getGriglia()[s.getListaAnimaleClon().get(i).getX()][s.getListaAnimaleClon().get(i).getY()] = null;
			s.getListaAnimaleClon().remove(i);
		}
	}

	public String toString() {
		return "[c]";
	}

}
