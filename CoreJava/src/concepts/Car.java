/*
 * Package Name: concepts
 */
package concepts;
/*
 * Class Name: Car
 * Implements interface: VehicleInterface
 * and defines methods: numOfCylinders and numOfTyres.
 */
public class Car implements VehicleInterface {

	@Override
	public int numOfCylinders() {
		return 2;
	}

	@Override
	public int numOfTyres() {
		return 4;
	}
	
}
