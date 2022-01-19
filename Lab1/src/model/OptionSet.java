package model;

import java.io.*;

public class OptionSet implements Serializable{
	private String name;
	private Option[] opt;
	
	protected OptionSet(){};
	protected OptionSet(String name, Option[] opt) {
		super();
		this.name = name;
		this.opt = opt;
	}

	protected String getName() {
		return name;
	}
	protected Option getOption(int index) {
		if (index < 0 || index >= opt.length) {
			System.out.println("Can't getOption() becasue your input index for the Option array is not valid.");
			return null;
		}
		return opt[index];
	}
	protected Option getOption(String name) {
		int index = getOptionIndex(name);
		return opt[index];
	}
	protected int getOptionIndex(String optName) {
		if (!isValid(optName)) {
			return -1;
		}
		int index = 0;
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName().equals(optName)) {
				break;
			} else {
				index++;
			}
		}
		return index;
	}
	protected Option[] getOptionArray() {
		return opt;
	}
	protected int getOptionArrayLength() {
		return opt.length;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected void setOption(Option[] opt) {
		this.opt = opt;
	}
	protected void setOptionArray(int size) {
		Option[] opt = new Option[size];
		for (int i = 0; i < size; i++) {
			opt[i] = new Option();
		}
		this.opt = opt;
	}

	protected boolean isValid(String optName) {
		for(int i = 0; i < this.opt.length; i++) {
			if(this.opt[i].getName().equals(optName)) {
				return true;
			}
		}
		System.out.println("Input Option name is invalid");
		return false;
	}
	
	protected void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Option Set Name: ");
		sb.append(this.name);
		System.out.println(sb.toString());
		for (int i = 0; i < opt.length; i++) {
			System.out.print("\s\s\s\s");
			opt[i].print();
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