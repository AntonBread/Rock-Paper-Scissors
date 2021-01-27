package codinghw.rock_paper_scissors;

public class PlayerUser extends PlayerTemplate {
	private int code;
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public void pickMove() {
		switch (code) {
			case 0:
				setMove(State.ROCK);
				break;
			case 1:
				setMove(State.PAPER);
				break;
			case 2:
				setMove(State.SCISSORS);
				break;
			default:
				setMove(State.NONE);
				System.out.println("Invalid input");
		}
	}
}
