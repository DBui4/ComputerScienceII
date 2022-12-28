package unl.soc;

import org.junit.jupiter.api.Assertions;
import java.util.List;
import org.junit.Test;

/**
 * TODO: author header
 */
public class CheerTests {

	private static final List<Integer> list01 = List.of(2, 9, 4, 25, 57, 45, 53);
	private static final List<Integer> list02 = List.of(5, 3, 45, 10, 1, 2, 0, 4);

	/**
	 * Tests that the {@link Cheer#getHuskerScore(List<Integer>)} method correctly computes
	 * the Husker score of <code>list01</code>.
	 */
	@Test
	public void huskerScoreTest01() {
		int expected = 111;
		int result = Cheer.getHuskerScore(list01);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Cheer#getHuskerScore(List<Integer>)} method correctly computes
	 * the Husker score of <code>list01</code>.
	 */
	@Test
	public void maverickScoreTest01() {
		int expected = 70;
		int result = Cheer.getMavScore(list01);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Cheer#getWinner(List<Integer>)} method correctly computes
	 * the winner of <code>list01</code>.
	 */
	@Test
	public void winnerTest01() {
		int result = Cheer.getWinner(list01);
		Assertions.assertTrue( result < 0 );
	}

	/**
	 * Tests that the {@link Cheer#getHuskerScore(List<Integer>)} method correctly computes
	 * the Husker score of <code>list02</code>.
	 */
	@Test
	public void huskerScoreTest02() {
		int expected = 48;
		int result = Cheer.getHuskerScore(list02);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Cheer#getHuskerScore(List<Integer>)} method correctly computes
	 * the Husker score of <code>list02</code>.
	 */
	@Test
	public void maverickScoreTest02() {
		int expected = 60;
		int result = Cheer.getMavScore(list02);
		Assertions.assertEquals(expected, result);
	}

	/**
	 * Tests that the {@link Cheer#getWinner(List<Integer>)} method correctly computes
	 * the winner of <code>list02</code>.
	 */
	@Test
	public void winnerTest02() {
		int result = Cheer.getWinner(list02);
		Assertions.assertTrue( result > 0 );
	}

	//TODO: additional test cases here

}
