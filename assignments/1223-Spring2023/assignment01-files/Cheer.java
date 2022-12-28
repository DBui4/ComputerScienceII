package unl.soc;

import java.util.List;

/**
 *
 * TODO: author/overall purpose documentation
 *
 * TODO: detail the rules here
 *
 */
public class Cheer {

	/**
	 * Calculates the Husker score of the list of given elements based
	 * on the rules above.
	 * @param elements
	 * @return
	 */
	public static int getHuskerScore(List<Integer> elements) {
		//TODO: implement
	}

	/**
	 * Calculates the Mavericks score of the list of given elements based
	 * on the rules above.
	 * @param elements
	 * @return
	 */
	public static int getMavScore(List<Integer> elements) {
		//TODO: implement
	}

	/**
	 * Calculates the winner of the game based on the rules above.  Returns
	 * a negative value if the Huskers win (have a greater score than the Mavericks),
	 * a positive value if the Mavericks win, and zero if the game is a tie.
	 * @param elements
	 * @return
	 */
	public static int getWinner(List<Integer> elements) {
		//TODO: implement
	}

	public static void main(String args[]) {

		// ad-hoc testing...
		List<Integer> a = List.of(2, 9, 4, 25, 57, 45, 53);

		int huskerScore = getHuskerScore(a);
		int mavScore = getMavScore(a);
		System.out.println("husker score = " + huskerScore);
		System.out.println("mav score    = " + mavScore);

	}

}
