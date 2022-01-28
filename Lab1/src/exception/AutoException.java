package exception;
import model.*;

public class AutoException extends Exception{
	private int errNum;
	private String message;
	private int extraInformation;
	private Automobile auto;
	
	public AutoException() {} 
	public AutoException(int errNum) {
		this.errNum = errNum;
	}
	public AutoException(int errNum, String message) {
		this.errNum = errNum;
		this.message = message;
	}
	public AutoException(int errNum, Automobile auto) {
		this.errNum = errNum;
		this.auto = auto;
	}
	public AutoException(int errNum, Automobile auto, int extraInformation) {
		this.errNum = errNum;
		this.auto = auto;
		this.extraInformation = extraInformation;
	}
	
	public AutoException(int errNum, String message, Automobile auto) {
		this.errNum = errNum;
		this.message = message;
		this.auto = auto;
	}
	
	public void fix() {
		switch(errNum) {
			case 1:
				Fix1to100 a1 = new Fix1to100();
				a1.fixMissingAutomobileName(auto);
				break;
			case 2:
				Fix1to100 a2 = new Fix1to100();
				a2.fixMissingBasePrice(auto);
				break;
			case 3:
				Fix1to100 a3 = new Fix1to100();
				a3.fixMissingAutomobileNameAndPrice(auto);
				break;
			case 4:
				Fix1to100 a4 = new Fix1to100();
				a4.fixDimensionMissing(auto);
				break;
			case 5:
				Fix1to100 a5 = new Fix1to100();
				a5.fixDimension(auto, extraInformation);
				break;
			case 6:
				Fix1to100 a6 = new Fix1to100();
				a6.fixOptionData(auto);
		}
	}
}
