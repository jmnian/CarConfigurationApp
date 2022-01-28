package model;

import java.io.*;
import model.OptionSet.Option;

public class Automobile implements Serializable{
	private String name;
	private float basePrice;
	private OptionSet[] optset;
	
	public Automobile(){}
	public Automobile(String name) {
		super();
		this.name = name;
	}
	public Automobile(String name, float basePrice) {
		super();
		this.name = name;
		this.basePrice = basePrice;
	}
	public Automobile(String name, float basePrice, int optionSetSize) {
		super();
		this.name = name;
		this.basePrice = basePrice;
		this.optset = new OptionSet[optionSetSize]; 
		for (int i = 0; i < optionSetSize; i++) {
			optset[i] = new OptionSet();
		}
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public OptionSet getOptionSet(int index) {
		if (!isValid(index)) {
			return null;
		}
		return optset[index];
	}
	public int getOptionSetIndex(String name) {
		if (!isValid(name)) {
			return -1;
		}
		int index = 0;
		for (int i = 0; i < optset.length; i++) {
			if (optset[i].getName().equals(name)) {
				break;
			} else {
				index++;
			}
		}
		return index;
	}
	public OptionSet getOptionSet(String name) {
		int index = getOptionSetIndex(name);
		return optset[index];
	}
	public OptionSet[] getOptionSetArray() {
		return optset;
	}
	public int getOptionSetSize() {
		return optset.length;
	}
	
	public Option getOption(int optsetIndex, int optIndex) {
		if (!isValid(optsetIndex, optIndex)) {
			return null;
		}
		return optset[optsetIndex].getOption(optIndex);
	}
	public Option getOption(String optsetName, int optIndex) {
		OptionSet set = getOptionSet(optsetName);
		return set.getOption(optIndex);
	}
	public Option getOption(int optsetIndex, String optName) {
		if (!isValid(optsetIndex)) {
			return null;
		}
		return optset[optsetIndex].getOption(optName);
	}
	public Option getOption(String optsetName, String optName) {
		OptionSet set = getOptionSet(optsetName);
		return set.getOption(optName);
	}
	public Option getOption(OptionSet set, int optIndex) {
		return set.getOption(optIndex);
	}
	public Option getOption(OptionSet set, String optName) {
		return set.getOption(optName);
	}
	public Option[] getOptionArray(int optsetIndex) {
		if (!isValid(optsetIndex)) {
			return null;
		}
		return optset[optsetIndex].getOptionArray();
	}
	public int getOptionSize(int optsetIndex) {
		if (!isValid(optsetIndex)) {
			return -1;
		}
		return optset[optsetIndex].getOptionArrayLength();
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	public void setOptionSet(String name, String newName, Option[] newOpt) {
		OptionSet optset = getOptionSet(name);
		optset.setName(newName);
		optset.setOption(newOpt);
	}
	public void setOptionSet(int index, String newName, Option[] newOpt) {
		if (!isValid(index)) {
			return;
		}
		optset[index].setName(newName);
		optset[index].setOption(newOpt);
	}
	public void setOptionSetName(String name, String newName) {
		OptionSet optset = getOptionSet(name);
		optset.setName(newName);
	}
	public void setOptionSetArray(int size) {
		OptionSet[] optset = new OptionSet[size];
		for (int i = 0; i < size; i++) {
			optset[i] = new OptionSet();
		}
		this.optset = optset;
	}
	public void setOptionSetArray(int size, OptionSet[] optset) {
		OptionSet[] newOptset = new OptionSet[size];
		for (int i = 0; i < size; i++) {
			newOptset[i] = new OptionSet("Empty", new Option[] {});
		}
		for (int i = 0; i < optset.length; i++) {
			newOptset[i] = optset[i];
		}
		this.optset = newOptset;
	}
	public void setOption(int optsetIndex, int optIndex, String name, float price) {
		if (!isValid(optsetIndex, optIndex)) {
			return;
		}
		optset[optsetIndex].getOption(optIndex).setName(name);
		optset[optsetIndex].getOption(optIndex).setPrice(price);
	}
	public void setOption(String optsetName, int optIndex, String name, float price) {
		if (!isValid(optsetName, optIndex)) {
			return;
		}
		getOptionSet(optsetName).getOption(optIndex).setName(name);
		getOptionSet(optsetName).getOption(optIndex).setPrice(price);
	}
	public void setOptionArray(OptionSet optset, int size) {
		optset.setOptionArray(size);
	}
	public void setOptionArray(int optIndex, int size) {
		getOptionSet(optIndex).setOptionArray(size);
	}
	public void setOptionArray(String optName, int size) {
		getOptionSet(optName).setOptionArray(size);
	}
	
	//Finders
	public OptionSet findOptionSet(String name) {
		return getOptionSet(name);
	}
	public OptionSet findOptionSet(int index) {
		return getOptionSet(index);
	}
	public Option findOption(int optsetIndex, int optIndex) {
		OptionSet set = getOptionSet(optsetIndex);
		return set.getOption(optIndex);
	}
	public Option findOption(int optsetIndex, String optName) {
		OptionSet set = getOptionSet(optsetIndex);
		return set.getOption(optName);
	}
	public Option findOption(String optsetName, int optIndex) {
		OptionSet set = getOptionSet(optsetName);
		return set.getOption(optIndex);
	}
	public Option findOption(String optsetName, String name) {
		OptionSet set = getOptionSet(optsetName);
		return set.getOption(name);
	}
		
	//Deleter
	public void deleteOptionSet(int index) {
		if (!isValid(index)) {
			return;
		}
		OptionSet[] old = optset;
		int oldIndex = 0;
		this.optset = new OptionSet[this.optset.length - 1];
		for (int i = 0; i < this.optset.length; i++) {
			if (i == index) {
				oldIndex++;
			}
			this.optset[i] = old[oldIndex];
			oldIndex++;
		}
	}
	public void deleteOptionSet(String name) {
		if (!isValid(name)) {
			return;
		}
		OptionSet delete = getOptionSet(name);
		int deleteIndex = 0;
		for (int i = 0; i < this.optset.length; i++) {
			if (this.optset[i].equals(delete)) {
				break;
			} else {
				deleteIndex++;
			}
		}
		deleteOptionSet(deleteIndex);
	}
	public void deleteOption(int setIndex, int optIndex) {
		if (!isValid(setIndex, optIndex)) {
			return;
		}
		OptionSet set = getOptionSet(setIndex);
		Option[] before = set.getOptionArray();
		Option[] after = new Option[before.length - 1];
		int j = 0;
		for (int i = 0; i < before.length; i++) {
			if (i == optIndex) {
				continue;
			} else {
				after[j] = before[i];
				j++;
			}
		}
	}
	public void deleteOption(int setIndex, String optName) {
		if (!isValid(setIndex, optName)) {
			return;
		}
		int optIndex = getOptionSet(setIndex).getOptionIndex(optName);
		deleteOption(setIndex, optIndex);
	}
	public void deleteOption(String setName, int optIndex) {
		if (!isValid(setName, optIndex)) {
			return;
		}
		int setIndex = getOptionSetIndex(setName);
		deleteOption(setIndex, optIndex);
	}
	public void deleteOption(String setName, String optName) {
		if (!isValid(setName, optName)) {
			return;
		}
		int setIndex = getOptionSetIndex(setName);
		deleteOption(setIndex, optName);
	}
	
	
	//Updater
	public void updateOptionSet(String name, String newName, Option[] newOpt) {
		OptionSet set = getOptionSet(name);
		set.setName(newName);
		set.setOption(newOpt);
	}
	public void updateOptionSet(int index, String newName, Option[] newOpt) {
		OptionSet set = getOptionSet(index);
		set.setName(newName);
		set.setOption(newOpt);
	}
	public void updateOption(OptionSet set, String optName, String newName, float newPrice) {
		Option opt = set.getOption(optName);
		opt.setName(newName);
		opt.setPrice(newPrice);
	}
	public void updateOption(OptionSet set, int optIndex, String newName, float newPrice) {
		Option opt = set.getOption(optIndex);
		opt.setName(newName);
		opt.setPrice(newPrice);
	}
	public void updateOptionPrice(OptionSet set, String optName, float newPrice) {
		Option opt = set.getOption(optName);
		opt.setPrice(newPrice);
	}
	public void updateOptionName(OptionSet set, String optName, String newName) {
		Option opt = set.getOption(optName);
		opt.setName(newName);
	}
	
	// Sanity check
	public boolean isValid(int setIndex) {
		if (setIndex < 0 || setIndex >= this.optset.length) {
			System.out.println("Input OptionSet index is invalid");
			return false;
		}
		return true;
	}
	public boolean isValid(String setName) {
		for(int i = 0; i < this.optset.length; i++) {
			if(this.optset[i].getName().equals(setName)) {
				return true;
			}
		}
		System.out.println("Input OptionSet name is invalid");
		return false;
	}
	public boolean isValid(int setIndex, int optIndex) {
		if (!isValid(setIndex) || optIndex < 0 || optIndex >= getOptionSet(setIndex).getOptionArrayLength()) {
			System.out.println("Input Option index is invalid");
			return false;
		}
		return true;
	}
	public boolean isValid(int setIndex, String optName) {
		if (!isValid(setIndex)) {
			return false;
		}
		OptionSet set = getOptionSet(setIndex);
		for (int i = 0; i < set.getOptionArrayLength(); i++) {
			if (set.getOption(i).getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	public boolean isValid(String setName, int optIndex) {
		if (!isValid(setName) || optIndex < 0 || optIndex >= getOptionSet(setName).getOptionArrayLength()) {
			System.out.println("Input Option index is invalid");
			return false;
		}
		return true;
	}
	public boolean isValid(String setName, String optName) {
		if (!isValid(setName)) {
			return false;
		}
		OptionSet set = getOptionSet(setName);
		for (int i = 0; i < set.getOptionArrayLength(); i++) {
			if (set.getOption(i).getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	
	//Utility
	public void print() {
//			String format = "%-40s%s%n";
//			System.out.printf(format, s, sa); // Is this String concatenation? 
		StringBuilder sb = new StringBuilder();
		sb.append("Automitive Name: ");
		sb.append(this.name);
		sb.append("\tBase Price: $");
		sb.append(this.basePrice);
		System.out.println(sb.toString());
		for (int i = 0; i < optset.length; i++) {
			System.out.print("\s\s");
			optset[i].print();
		}
		System.out.println("-------------End of Automobile print function--------------");
	}
}