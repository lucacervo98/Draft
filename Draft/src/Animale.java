import java.util.Random;

public class Animale extends Pedina {
	private int spostamenti;
	private Random rnd = new Random();

	public Animale(int x, int y) {
		super(x, y);
		spostamenti = 10;
	}

	public void movimento(GenerazioneGriglia s) {
		for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
			// while ()
			switch (rnd.nextInt(8)) {
			case 0:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i)
						.getY()] == null && s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() >= 0
						&& s.getListaAnimaleAcc().get(i).getY() < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() - 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 1:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i)
						.getY()] == null && s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() >= 0
						&& s.getListaAnimaleAcc().get(i).getY() < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 2:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
						- 1] == null && s.getListaAnimaleAcc().get(i).getX() >= 0
						&& s.getListaAnimaleAcc().get(i).getX() < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() - 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 3:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
						+ 1] == null && s.getListaAnimaleAcc().get(i).getX() >= 0
						&& s.getListaAnimaleAcc().get(i).getX() < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 4:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i).getY()
						- 1] == null && s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() - 1);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() - 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 5:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i).getY()
						+ 1] == null && s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + 1);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 6:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i).getY()
						- 1] == null && s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() + 1);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() - 1);
					spostamenti = spostamenti - 1;
				}
				break;
			case 7:
				if (s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i).getY()
						+ 1] == null && s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
						&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
						&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()) {
					s.getListaAnimaleAcc().get(i).setX(s.getListaAnimaleAcc().get(i).getX() - 1);
					s.getListaAnimaleAcc().get(i).setY(s.getListaAnimaleAcc().get(i).getY() + 1);
					spostamenti = spostamenti - 1;
				}
				break;
			}

		}

	}

	public static void turno(GenerazioneGriglia s) {
		
		for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
			s.getListaAnimaleAcc().get(i).movimento(s); 
		}

	}
}
