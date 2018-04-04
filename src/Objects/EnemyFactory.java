/**
 * 
 */
package Objects;

/**
 * @author Daniel Acuña Mora
 *
 */
public class EnemyFactory {
	/**
	 * @param string
	 */

	public Enemy make(String b) {
		if (b.equalsIgnoreCase("Boss")) {
			Boss boss = new Boss();
			return boss;
		} else if (b.equalsIgnoreCase("basic")) {
			Basic basic = new Basic();
			return basic;
		} else {
			throw new IllegalArgumentException(
					"You need to insert a type of enemy");
		}

	}
}
