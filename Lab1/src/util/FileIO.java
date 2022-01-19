package util;
import java.io.*;

import model.Automotive;

public class FileIO {
	public Automotive buildAutoObject(String fileName) {
		Automotive automotive = new Automotive();
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			//initialize
			automotive.setName(buff.readLine());
			automotive.setBasePrice(Float.parseFloat(buff.readLine()));
			int optsetSize = Integer.parseInt(buff.readLine());
			automotive.setOptionSetArray(optsetSize);
			for (int i = 0; i < optsetSize; i++) {
				int optSize = Integer.parseInt(buff.readLine());
				automotive.setOptionArray(automotive.getOptionSet(i), optSize);
			}
			//fill in information
			for(int i = 0; i < optsetSize; i++) {
				String optsetName = buff.readLine();
				for (int j = 0; j < automotive.getOptionSize(i); j++) {
					//set name and price for each option within 1 option set(e.g. color)
					String curName = buff.readLine();
					float curPrice = Float.parseFloat(buff.readLine());
					automotive.setOption(i, j, curName, curPrice);
				}
				automotive.setOptionSet(i, optsetName, automotive.getOptionArray(i));
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
		return automotive;
	}
	
	public void serializeAuto(Automotive automotive, String fileName) {
		try {
			FileOutputStream a1 = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(a1); 
			out.writeObject(automotive);
			out.close();
		} catch(Exception e) { 
			System.out.print("Error:" + e);
			System.exit(1); 
		}
		System.out.println("serializeAuto success");
	}
	
	public Automotive deserializeAuto(String fileName) {
		Automotive automotiveReplica = null;
		try {
			FileInputStream a1 = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(a1);
			automotiveReplica = (Automotive) in.readObject(); 
			in.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1); 
		}
		System.out.println("deserializeAuto success");
		return automotiveReplica;
	}
}
