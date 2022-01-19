package driver;

import model.*;
import util.*;

public class Driver {
	
	public static void main(String[] args) {
		FileIO Lab1 = new FileIO();
		Automotive FordZTW = Lab1.buildAutoObject("FordZTW.txt");
		FordZTW.print();
		Lab1.serializeAuto(FordZTW, "serializedFordZTW.ser");
		Automotive newFordZTW = Lab1.deserializeAuto("serializedFordZTW.ser");
		newFordZTW.print();
	}

}
