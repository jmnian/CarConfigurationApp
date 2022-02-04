package adapter;

import exception.AutoException;
import model.*;
import util.*;

public abstract class proxyAutomobile{
	private static Automobile a1;
	private static AutoException e1;
	private static AutoStorage s1;
	
	public void buildAuto(String fileName) throws AutoException {
		FileIO io = new FileIO();
		a1 = io.buildAutoObject(fileName);
	}
	public void printAuto(String modelName) {
		Automobile a2 = s1.getAutomobile(modelName);
		a2.print();
	}
	public void setAutoStorage(AutoStorage storage) {
		proxyAutomobile.s1 = storage;
	}
	public Automobile getAuto() {
		return a1;
	}
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		Automobile a2 = s1.getAutomobile(modelName);
		a2.setOptionSetName(optionSetName, newName);
	}
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, float newPrice) {
		Automobile a2 = s1.getAutomobile(modelName);
		a2.updateOptionPrice(a2.getOptionSet(optionSetName), optionName, newPrice);
	}
	public void fix() {
		e1.fix();
	}
	public void setOptionChoice(String setName, String optionName) {
		a1.setOptionChoice(setName, optionName);
		System.out.println("Selected Option \"" + setName + "\" : " + optionName);
	}
	public float getTotalPrice() {
		return a1.getTotalPrice();
	}
}
