package driver;

import adapter.*;
import exception.AutoException;
import model.AutoStorage;

public class ChoiceDriver {
	public static void main(String[] args) {
		try {
			AutoStorage garage = new AutoStorage();
			garage.setMap(1);
			CreateAuto a1 = new BuildAuto();
			a1.setAutoStorage(garage);
			a1.buildAuto("LexusES350.txt");
			garage.addAutomobile(a1.getAuto().getName(), a1.getAuto());
			a1.printAuto("Lexus ES350");
			a1.setOptionChoice("Color", "Eminent White Pearl");
			a1.setOptionChoice("Wood Trim with Ambient Lighting", "Present");
			a1.setOptionChoice("Interior Colors", "Black NuLuxe with Striated Black Film trim");
			a1.setOptionChoice("Paint Protection Film", "Present");
			a1.setOptionChoice("Premium Audio Package (Mark Levinson)", "Present");
			System.out.println();
			System.out.println("Total price after the selection is: $" + a1.getTotalPrice());
		} catch (AutoException a) {
			
		}
	}
}
