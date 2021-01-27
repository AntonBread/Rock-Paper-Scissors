package codinghw.rock_paper_scissors;

import java.util.*;

public class PlayerBot extends PlayerTemplate {
	Random rnd = new Random();
	
	public void generate() {
		int code = rnd.nextInt(3);
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
		}
	}
}