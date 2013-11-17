package drumPro;

public class DrumProThread extends Thread {
	DrumPro drumPro;
	
	public DrumProThread(String[] lines, int bpm) {
		drumPro = new DrumPro(lines, bpm);
	}
	
	@Override
	public void run() { 
		while(drumPro.board.initCount < 136) { }
		drumPro.setVisible(false);
		drumPro.dispose();
	}
}
