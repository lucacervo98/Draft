import java.util.Random;

public class Animale extends Pedina {
	private int spostamenti;
	private Random rnd = new Random();
	boolean PoP = false;

	public Animale(int x, int y) {
		super(x, y);
		spostamenti = 10;
	}

	// movimento per AimaleAccoppiamento
	public void movimento(GenerazioneGriglia s) {
		for (int i = 0; i < s.getListaAnimaleAcc().size(); i++) {
			while (PoP = true) {
				switch (rnd.nextInt(8)) {
				case 0:
					if (s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() >= 0
							&& s.getListaAnimaleAcc().get(i).getY() < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i)
									.getY()] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i)
								.getY()] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 1:
					if (s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() >= 0
							&& s.getListaAnimaleAcc().get(i).getY() < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i)
									.getY()] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i)
								.getY()] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 2:
					if (s.getListaAnimaleAcc().get(i).getX() >= 0 && s.getListaAnimaleAcc().get(i).getX() < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
									- 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
								- 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 3:
					if (s.getListaAnimaleAcc().get(i).getX() >= 0 && s.getListaAnimaleAcc().get(i).getX() < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
									+ 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i).getY()
								+ 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 4:
					if (s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i)
									.getY() - 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i).getY()
								- 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 5:
					if (s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i)
									.getY() + 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i).getY()
								+ 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				case 6:
					if (s.getListaAnimaleAcc().get(i).getX() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() + 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() - 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i)
									.getY() - 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() + 1][s.getListaAnimaleAcc().get(i).getY()
								- 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}	
					break;
				case 7:
					if (s.getListaAnimaleAcc().get(i).getX() - 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getX() - 1 < s.getRighe()
							&& s.getListaAnimaleAcc().get(i).getY() + 1 >= 0
							&& s.getListaAnimaleAcc().get(i).getY() + 1 < s.getColonne()
							&& s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i)
									.getY() + 1] == null) {
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX()][s.getListaAnimaleAcc().get(i)
								.getY()] = null;
						s.getGriglia()[s.getListaAnimaleAcc().get(i).getX() - 1][s.getListaAnimaleAcc().get(i).getY()
								+ 1] = s.getListaAnimaleAcc().get(i);
						spostamenti = spostamenti - 1;
						PoP = true;
					}
					break;
				}

			}
		}

	}

	public int getSpostamenti() {
		return spostamenti;
	}

}
