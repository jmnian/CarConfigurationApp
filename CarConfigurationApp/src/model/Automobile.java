package model;

import java.io.*;
import java.util.*;
import model.OptionSet.Option;

public class Automobile implements Serializable{
	private String name;
	private String make; //brand
	private String model;//specific model
	private float basePrice;
	private ArrayList<OptionSet> optset;
	private ArrayList<Option> choice;
	
	public Automobile(){}
	public Automobile(String make, String model) {
		super();
		this.make = make;
		this.model = model;
	}
	public Automobile(String make, String model, float basePrice) {
		super();
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
	}
	public Automobile(String make, String model, float basePrice, int optionSetSize) {
		super();
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		this.optset = new ArrayList<OptionSet>(optionSetSize); 
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public OptionSet getOptionSet(int index) {
		if (!isValid(index)) {
			return null;
		}
		return optset.get(index);
	}
	public int getOptionSetIndex(String name) {
		if (!isValid(name)) {
			return -1;
		}
		int index = 0;
		for (int i = 0; i < optset.size(); i++) {
			if (optset.get(i).getName().equals(name)) {
				break;
			} else {
				index++;
			}
		}
		return index;
	}
	public OptionSet getOptionSet(String name) {
		int index = getOptionSetIndex(name);
		return optset.get(index);
	}
	public ArrayList<OptionSet> getOptionSetArrayList() {
		return optset;
	}
	public int getOptionSetSize() {
		return optset.size();
	}
	
	public Option getOption(int optsetIndex, int optIndex) {
		if (!isValid(optsetIndex, optIndex)) {
			return null;
		}
		return optset.get(optsetIndex).getOption(optIndex);
	}
	public Option getOption(String optsetName, int optIndex) {
		OptionSet set = getOptionSet(optsetName);
		return set.getOption(optIndex);
	}
	public Option getOption(int optsetIndex, String optName) {
		if (!isValid(optsetIndex)) {
			return null;
		}
		return optset.get(optsetIndex).getOption(optName);
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
	public ArrayList<Option> getOptionArrayList(int optsetIndex) {
		if (!isValid(optsetIndex)) {
			return null;
		}
		return optset.get(optsetIndex).getOptionArrayList();
	}
	public int getOptionSize(int optsetIndex) {
		if (!isValid(optsetIndex)) {
			return -1;
		}
		return optset.get(optsetIndex).getOptionArrayListLength();
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	public void setOptionSet(String name, String newName, ArrayList<Option> newOpt) {
		OptionSet optset = getOptionSet(name);
		optset.setName(newName);
		optset.setOption(newOpt);
	}
	public void setOptionSet(int index, String newName, ArrayList<Option> newOpt) {
		if (!isValid(index)) {
			return;
		}
		optset.get(index).setName(newName);
		optset.get(index).setOption(newOpt);
	}
	public void setOptionSetName(String name, String newName) {
		OptionSet optset = getOptionSet(name);
		optset.setName(newName);
	}
	public void setOptionSetArrayList(int size) {
		this.optset = new ArrayList<OptionSet>(size);
		for (int i = 0; i < size; i++) {
			this.optset.add(new OptionSet());
		}
	}
	public void setOptionSetArrayList(int size, ArrayList<OptionSet> optset) {
		ArrayList<OptionSet> newOptset = new ArrayList<OptionSet>(size);
		for (int i = 0; i < optset.size(); i++) {
			newOptset.set(i, optset.get(i));
		}
		this.optset = newOptset;
	}
	public void setChoiceArrayList(int size) {
		this.choice = new ArrayList<Option>(size);
		//x is a dummy object, for enabling x.new Option()
		OptionSet x = new OptionSet();
		for (int i = 0; i < size; i++) {
			this.choice.add(x.new Option());
		}
	}
	public void setOption(int optsetIndex, int optIndex, String name, float price) {
		if (!isValid(optsetIndex, optIndex)) {
			return;
		}
		optset.get(optsetIndex).getOption(optIndex).setName(name);
		optset.get(optsetIndex).getOption(optIndex).setPrice(price);
	}
	public void setOption(String optsetName, int optIndex, String name, float price) {
		if (!isValid(optsetName, optIndex)) {
			return;
		}
		getOptionSet(optsetName).getOption(optIndex).setName(name);
		getOptionSet(optsetName).getOption(optIndex).setPrice(price);
	}
	public void setOptionArrayList(OptionSet optset, int size) {
		optset.setOptionArrayList(size);
	}
	public void setOptionArrayList(int optIndex, int size) {
		getOptionSet(optIndex).setOptionArrayList(size);
	}
	public void setOptionArrayList(String optName, int size) {
		getOptionSet(optName).setOptionArrayList(size);
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
		this.optset.remove(index);
	}
	public void deleteOptionSet(String name) {
		if (!isValid(name)) {
			return;
		}
		OptionSet delete = getOptionSet(name);
		int deleteIndex = 0;
		for (int i = 0; i < this.optset.size(); i++) {
			if (this.optset.get(i).equals(delete)) {
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
		ArrayList<Option> opt = set.getOptionArrayList();
		opt.remove(optIndex);
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
	public void updateOptionSet(String name, String newName, ArrayList<Option> newOpt) {
		OptionSet set = getOptionSet(name);
		set.setName(newName);
		set.setOption(newOpt);
	}
	public void updateOptionSet(int index, String newName, ArrayList<Option> newOpt) {
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
		if (setIndex < 0 || setIndex >= this.optset.size()) {
			System.out.println("Input Option)Set index is invalid");
			return false;
		}
		return true;
	}
	public boolean isValid(String setName) {
		for(int i = 0; i < this.optset.size(); i++) {
			if(this.optset.get(i).getName().equals(setName)) {
				return true;
			}
		}
		System.out.println("Input OptionSet name is invalid");
		return false;
	}
	public boolean isValid(int setIndex, int optIndex) {
		if (!isValid(setIndex) || optIndex < 0 || optIndex >= getOptionSet(setIndex).getOptionArrayListLength()) {
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
		for (int i = 0; i < set.getOptionArrayListLength(); i++) {
			if (set.getOption(i).getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	public boolean isValid(String setName, int optIndex) {
		if (!isValid(setName) || optIndex < 0 || optIndex >= getOptionSet(setName).getOptionArrayListLength()) {
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
		for (int i = 0; i < set.getOptionArrayListLength(); i++) {
			if (set.getOption(i).getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	
	//User choices
	public String getOptionChoice(String optsetName) {
		OptionSet set = getOptionSet(optsetName);
		for (int i = 0; i < choice.size(); i++) {
			if (set.contains(choice.get(i))) {
				return choice.get(i).getName();
			}
		}
		return "Option Choice Not Found";
	}
	
	public float getOptionChoicePrice(String optsetName) {
		OptionSet set = getOptionSet(optsetName);
		for (int i = 0; i < choice.size(); i++) {
			if (set.contains(choice.get(i))) {
				return choice.get(i).getPrice();
			}
		}
		return -1;
	}
	
	public void setOptionChoice(String optsetName, String optName) {
		Option opt = getOption(optsetName, optName);
		this.choice.add(opt);
	}
	
	public float getTotalPrice() {
		float total = this.basePrice;
		for (int i = 0; i < choice.size(); i++) {
			total += choice.get(i).getPrice();
		}
		return total;
	}
	
	
	//Utility
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Automitive Make and Model: ");
		sb.append(this.make);
		sb.append(", ");
		sb.append(this.model);
		sb.append("\tBase Price: $");
		sb.append(this.basePrice);
		System.out.println(sb.toString());
		for (int i = 0; i < optset.size(); i++) {
			System.out.print("\s\s");
			optset.get(i).print();
		}
		System.out.println("-------------End of Automobile print function--------------");
	}
}
