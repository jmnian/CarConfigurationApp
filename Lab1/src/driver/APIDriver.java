package driver;

import adapter.*;
import exception.*;

public class APIDriver {
	public static void main(String[] args) throws AutoException {
		CreateAuto a1 = new BuildAuto();
		UpdateAuto a2 = new BuildAuto();
		a1.buildAuto("FordZTW.txt");
		a1.printAuto("Focus Wagon ZTW");
		a2.updateOptionSetName("Focus Wagon ZTW", "Color", "Paint Color");
		a2.updateOptionPrice("Focus Wagon ZTW", "Power Moonroof", "Present", 600);
		
		a1.printAuto("Focus Wagon ZTW");
		System.out.println("printed again after updates");
	}
}
