
public class Animale extends Pedina {
	private int spostamenti;
	
	public Animale(int x, int y) {
		super(x, y);
		spostamenti = 10;
	}

	/*
	 * public static boolean checkCibo(GenerazioneGriglia s, int i, int k, int z) { 
	 * boolean cibo = false;
	 * 
	 * for (int i = 0; i < s.getListaCibo().size(); i++) {
	 * 
	 * 
	 * }
	 * 
	 * }
	 */
	
	// metodi get e set

	public int getSpostamenti() {
		return spostamenti;
	}

	public void setSpostamenti(int spostamenti) {
		this.spostamenti = spostamenti;
	}
}
