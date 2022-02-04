package model;

import java.io.*;
import java.util.*;

public class OptionSet implements Serializable{
	private String name;
	private ArrayList<Option> opt;
	
	protected OptionSet(){};
	protected OptionSet(String name, ArrayList<Option> opt) {
		super();
		this.name = name;
		this.opt = opt;
	}

	//Getters
	protected String getName() {
		return name;
	}
	protected Option getOption(int index) {
		if (index < 0 || index >= opt.size()) {
			System.out.println("Can't getOption() becasue your input index for the Option array is not valid.");
			return null;
		}
		return opt.get(index);
	}
	protected Option getOption(String name) {
		int index = getOptionIndex(name);
		return opt.get(index);
	}
	protected int getOptionIndex(String optName) {
		if (!isValid(optName)) {
			return -1;
		}
		int index = 0;
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(optName)) {
				break;
			} else {
				index++;
			}
		}
		return index;
	}
	protected ArrayList<Option> getOptionArrayList() {
		return opt;
	}
	protected int getOptionArrayListLength() {
		return opt.size();
	}
	
	//Setters
	protected void setName(String name) {
		this.name = name;
	}
	protected void setOption(ArrayList<Option> opt) {
		this.opt = opt;
	}
	protected void setOptionArrayList(int size) {
		this.opt = new ArrayList<Option>(size);
		for (int i = 0; i < size; i++) {
			this.opt.add(new Option());
		}
	}

//	//Support User Choices
//	// Dont really need these
//	protected Option getOptionChoice() {
//		
//	}
//	protected void setOptionChoice(String optName) {
//		
//	}
	
	//Sanity Check
	protected boolean isValid(String optName) {
		for(int i = 0; i < this.opt.size(); i++) {
			if(this.opt.get(i).getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	
	//Util
	protected boolean contains(Option option) {
		return this.opt.contains(option);
	}
	protected void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Option Set Name: ");
		sb.append(this.name);
		System.out.println(sb.toString());
		for (int i = 0; i < opt.size(); i++) {
			System.out.print("\s\s\s\s");
			opt.get(i).print();
		}
	}
	
	
	public class Option implements Serializable{
		private String name;
		private float price;
		
		protected Option(){}
		protected Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		protected String getName() {
			return name;
		}
		protected float getPrice() {
			return price;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected void setPrice(float price) {
			this.price = price;
		}
		
		protected void print() {
			StringBuilder sb = new StringBuilder();
			sb.append("Option Name: ");
			sb.append(this.name);
			sb.append("\tPrice: $");
			sb.append(this.price);
			System.out.println(sb.toString());
		}
	}
}
