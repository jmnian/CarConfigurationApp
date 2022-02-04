package driver;

import model.*;
import adapter.*;
import exception.*;

public class AutoStorageDriver {
	public static void main(String[] args) {
		try {
			AutoStorage garage = new AutoStorage();
			garage.setMap(2);
			CreateAuto a1 = new BuildAuto();
			a1.setAutoStorage(garage);
			a1.buildAuto("FordZTW.txt");
			garage.addAutomobile(a1.getAuto().getName(), a1.getAuto());
			a1.buildAuto("LexusES350.txt");
			garage.addAutomobile(a1.getAuto().getName(), a1.getAuto());
			garage.iterateAutomobileNames();
			a1.printAuto("Lexus ES350");
		} catch (AutoException a) {
			
		}
	}
}
