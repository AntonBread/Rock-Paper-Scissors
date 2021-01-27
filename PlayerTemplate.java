package codinghw.rock_paper_scissors;

public abstract class PlayerTemplate {
	private State move = State.NONE;
	boolean won = false;
	
	public State getMove() {
		return move;
	}
	
	public void setMove(State move) {
		this.move = move;
	}
}
