package driver;

import model.*;
import util.*;
import exception.*;

public class Driver {
	
	public static void main(String[] args) {
		try {
			FileIO Lab1 = new FileIO();
			Automobile FordZTW = Lab1.buildAutoObject("FordZTW.txt");
			FordZTW.print();
			Lab1.serializeAuto(FordZTW, "serializedFordZTW.ser");
			Automobile newFordZTW = Lab1.deserializeAuto("serializedFordZTW.ser");
			newFordZTW.print();
		} catch (AutoException a) {
			
		}
	}

}
