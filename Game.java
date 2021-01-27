package codinghw.rock_paper_scissors;

import java.util.*;

public class Game {

	public static void main(String[] args) {
		PlayerUser user = new PlayerUser();
		PlayerBot computer = new PlayerBot();
		Scanner in = new Scanner(System.in);
		
		while (!Thread.currentThread().isInterrupted()) {
			computer.generate();
			user.setMove(State.NONE);
			while (user.getMove() == State.NONE) {
				System.out.print("0 = ROCK, 1 = PAPER, 2 = SCISSORS\nInput your choice: ");
				user.setCode(in.nextInt());
				user.pickMove();
			}
			
			compete(user, computer);
			
			System.out.print("\nPLAY AGAIN? (Y/N) ");
			String again = "";
			while (!again.equals("y") && !again.equals("n")) {
				again = in.nextLine();
				again = again.toLowerCase();
			}
			if (again.equals("n"))
				Thread.currentThread().interrupt();
			else
				System.out.println();
		}
		in.close();
	}
	
	public static void compete(PlayerUser user, PlayerBot computer) {
		// Reset victory flag
		user.won = false;
		computer.won = false;
		
		// User chose Rock
		if (user.getMove() == State.ROCK) {
			if (computer.getMove() == State.ROCK) {
				user.won = true;
				computer.won = true;
			}
			else if (computer.getMove() == State.PAPER)
				computer.won = true;
			else if (computer.getMove() == State.SCISSORS)
				user.won = true;
		}
		
		// User chose Paper
		else if (user.getMove() == State.PAPER) {
			if (computer.getMove() == State.ROCK)
				user.won = true;
			else if (computer.getMove() == State.PAPER) {
				user.won = true;
				computer.won = true;
			}
			else if (computer.getMove() == State.SCISSORS)
				computer.won = true;
		}
		
		// User chose Scissors
		else if (user.getMove() == State.SCISSORS) {
			if (computer.getMove() == State.ROCK)
				computer.won = true;
			else if (computer.getMove() == State.PAPER)
				user.won = true;
			else if (computer.getMove() == State.SCISSORS) {
				user.won = true;
				computer.won = true;
			}
		}
		
		if (user.won == true && computer.won == false) {
			System.out.printf("YOU: %s\tCOMPUTER: %s\nYOU WON\n", user.getMove(), computer.getMove());
			return;
		}
		else if (user.won == false && computer.won == true) {
			System.out.printf("YOU: %s\tCOMPUTER: %s\nYOU LOST\n", user.getMove(), computer.getMove());
			return;
		}
		else if (user.won == true && computer.won == true) {
			System.out.printf("YOU: %s\tCOMPUTER: %s\nSTALEMATE\n", user.getMove(), computer.getMove());
			return;
		}
	}

}
