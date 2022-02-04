package exception;
import model.*;


public class Fix1to100 {
	//1. Missing Automobile name
	public void fixMissingAutomobileName(Automobile auto) {
		auto.setName("Possibly Missing");
		auto.setMake("Possibly Missing");
		auto.setModel("Possibly Missing");
		System.out.println("Automobile make or model is missing");
	}
	//2. Missing price for Automobile price in text file (First line is not a number)
	public void fixMissingBasePrice(Automobile auto) {
		auto.setBasePrice(0);
		System.out.println("Base Price is missing, and is therefore set to 0");
	}
	
	//3. Missing both price and name
	public void fixMissingAutomobileNameAndPrice(Automobile auto) {
		auto.setBasePrice(0);
		auto.setName("Possibly Missing");
		auto.setMake("Possibly Missing");
		auto.setModel("Possibly Missing");
		System.out.println("Please check your input file format, the first 4 lines should be (in order): name, make, model, base price");
	}
	//4. Dimension section empty	
	//	 - make OptionSet array empty and just print "Option set dimension is missing"
	public void fixDimensionMissing(Automobile auto) {
		auto.setOptionSetArrayList(0);
		System.out.println("Option Set Dimension is Missing");
	}
	//5. Check the lines after OptionSetDimension line: 
		//1. more is provided
		//	 - enlarge capacity
		//2. less is provided
		//   - fill the unprovided elements with name "Missing dimensions for this OptionSet's Options" and empty Option array
	//Fixing OptionSetDimension covers the fix for OptionDimension
	//Because all dimension information are at together 
	public void fixDimension(Automobile auto, int endAt) {
		if(endAt == 0) {
			//enlarge capacity by 1
			auto.setOptionSetArrayList(auto.getOptionSetSize() + 1, auto.getOptionSetArrayList());
			System.out.println("Wrong OptionSet Array size. Size of OptionSet Array is enlarged by 1");
		} else {
			//fill elements starting from endAt with name "Missing dimensions for this Option Array" and null Option array
			for (int i = endAt; i < auto.getOptionSetSize(); i++) {
				auto.setOptionSet(i, "Missing Dimensions for this OptionSet's Option Array", null);
			}
			System.out.println("Wrong OptionSet Array size. Exceding elements are filled with null Option arrays");
		}
	}
	
	public void fixOptionData(Automobile auto) {
		System.out.println("Because of bad input data, program ended half way through instantiating the Automobile object: " + auto.getMake() + ", " + auto.getModel());
	}
}
