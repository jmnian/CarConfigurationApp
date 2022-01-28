package util;
import java.io.*;

import model.Automobile;
import exception.*;

public class FileIO {
	public Automobile buildAutoObject (String fileName) throws AutoException{
		Automobile automobile = new Automobile();
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			//initialize
			//Car name missing
			//Car base price missing
			try { 
				String name = buff.readLine();
				String price = buff.readLine();
				if (!isNumeric(name) && isNumeric(price)) {
					automobile.setName(name);
					automobile.setBasePrice(Float.parseFloat(price));
				} else if (isNumeric(name) && !isNumeric(price)){
					throw new AutoException(3, automobile);
				} else if (isNumeric(name) && isNumeric(price)) {
					throw new AutoException(1, automobile);
				} else {
					throw new AutoException(2, automobile);
				}
			} catch (AutoException a) {
				a.fix();
			} 
			
			//OptionSet Size is missing(no numbers after Automobile's name and base price)
			try { 
				String optsetSizeString = buff.readLine();
				if (optsetSizeString == null || !isPositiveInteger(optsetSizeString)) {
					throw new AutoException(4, automobile);
				} else {
					automobile.setOptionSetArray(Integer.parseInt(optsetSizeString));
				}
			} catch (AutoException a) {
				a.fix();
			} 
			
			int optsetSize = automobile.getOptionSetSize();
			for (int i = 0; i < optsetSize; i++) {
				//OptionSet Size is not correct, as wrong number of option sizes are provided
				try { 
					String optSizeString = buff.readLine();
					if (optSizeString == null || !isPositiveInteger(optSizeString)) {
						throw new AutoException(5, automobile, i);
					} else {
						automobile.setOptionArray(automobile.getOptionSet(i), Integer.parseInt(optSizeString));
					}
				} catch (AutoException a) {
					a.fix();
				}
			}
			
			//fill in information
			for(int i = 0; i < optsetSize; i++) {
				String optsetName = buff.readLine();
				//Extra Option array dimensions are provided
				while (isPositiveInteger(optsetName)) {
					try {
						throw new AutoException(5, automobile);
					} catch (AutoException a) {
						a.fix();
					} 
					optsetName = buff.readLine();
				}
				for (int j = 0; j < automobile.getOptionSize(i); j++) {
					//set name and price for each option within 1 option set(e.g. color)
					try {
						String curName = buff.readLine();
						String curPrice = buff.readLine();
						if (isNumeric(curName) || !isNumeric(curPrice)) {
							throw new AutoException(6, automobile);
						}
						automobile.setOption(i, j, curName, Float.parseFloat(curPrice));
					} catch (AutoException a) {
						a.fix();
						System.out.println("Before exiting, program tried to fill information for OptionSet: " + optsetName);
						return automobile;
					}
				}
				automobile.setOptionSet(i, optsetName, automobile.getOptionArray(i));
			}
			
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
				} else {
					System.out.println("Here's a line you missed: " + line);
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return automobile;
	}
	
	public void serializeAuto(Automobile automobile, String fileName) {
		try {
			FileOutputStream a1 = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(a1); 
			out.writeObject(automobile);
			out.close();
		} catch(Exception e) { 
			System.out.print("Error:" + e);
			System.exit(1); 
		}
		System.out.println("Reached the end of serializeAuto");
	}
	
	public Automobile deserializeAuto(String fileName) {
		Automobile automotiveReplica = null;
		try {
			FileInputStream a1 = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(a1);
			automotiveReplica = (Automobile) in.readObject(); 
			in.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1); 
		}
		System.out.println("Reached the end of deserializeAuto");
		return automotiveReplica;
	}
	
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	public static boolean isPositiveInteger(String str) {
		  return str.matches("\\d+"); 
	}
}
