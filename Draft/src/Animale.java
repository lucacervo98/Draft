
public class Animale extends Pedina {
	private int spostamenti;
	
	public Animale(int x, int y) {
		super (x, y);
		spostamenti = 10;
	}
	
	// metodi get e set

	public int getSpostamenti() {
		return spostamenti;
	}

	public void setSpostamenti(int spostamenti) {
		this.spostamenti = spostamenti;
	}
}
