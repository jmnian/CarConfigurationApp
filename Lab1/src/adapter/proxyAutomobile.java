package adapter;

import exception.AutoException;
import model.*;
import util.*;

public abstract class proxyAutomobile {
	private static Automobile a1;
	private static AutoException e1;
	
	public void buildAuto(String fileName) throws AutoException {
		FileIO io = new FileIO();
		a1 = io.buildAutoObject(fileName);
	}
	public void printAuto(String modelName) {
		//Where are we searching different Automobile objects from? 
		//In other words, where are we storing all the Automobile objects?
		
		// *Here should be some searching mechanics*
		a1.print();
	}
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		// *Here should be some searching mechanics*
		a1.setOptionSetName(optionSetName, newName);
	}
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, float newPrice) {
		// *Here should be some searching mechanics*
		a1.updateOptionPrice(a1.getOptionSet(optionSetName), optionName, newPrice);
	}
	public void fix() {
		e1.fix();
	}
}
