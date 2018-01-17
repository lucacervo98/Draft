import java.util.Random;

public class AnimaleClonazione extends Animale {
	private Random rnd = new Random();
	
	public AnimaleClonazione(int x, int y) {
		super (x, y);
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
					s.getListaAnimaleClon().get(i).setX(s.getListaAnimaleClon().get(i).getX()+k);
					s.getListaAnimaleClon().get(i).setY(s.getListaAnimaleClon().get(i).getY()+z);
					/*problema*/if (s.getListaAnimaleClon().get(i).getSpostamenti() == 0) { 
						s.getGriglia()[s.getListaAnimaleClon().get(i).getX()+k][s.getListaAnimaleClon().get(i).getY()+z] = null;
						s.getListaAnimaleClon().remove(i);
					}
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
						s.getListaAnimaleClon().get(i).setX(s.getListaAnimaleClon().get(i).getX()+k);
						s.getListaAnimaleClon().get(i).setY(s.getListaAnimaleClon().get(i).getY()+z);
						check = true;
					}
				}
			} while (check == false);
		}

	public String toString() {
		String temp;
		return temp = "[c]";
	}

}
