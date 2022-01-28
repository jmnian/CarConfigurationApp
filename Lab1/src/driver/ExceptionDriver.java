package driver;

import exception.*;
import adapter.*;

public class ExceptionDriver {
	public static void main(String[] args) throws AutoException {
		AutoException a1 = new AutoException();
		BuildAuto auto = new BuildAuto();
		//Please try these three error-prone test files by uncommenting them
		auto.buildAuto("ErrorNameAndPriceFordZTW.txt");
		//auto.buildAuto("ErrorDimensionsFordZTW.txt");
		//auto.buildAuto("ErrorOptionDataFordZTW.txt");
		
		auto.printAuto("Focus Wagon ZTW");
	}
}
