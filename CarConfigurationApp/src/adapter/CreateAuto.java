package adapter;
import exception.*;
import model.AutoStorage;
import model.Automobile;

public interface CreateAuto {
	public void buildAuto(String fileName) throws AutoException;
	public void printAuto(String modelName);
	public void setOptionChoice(String setName, String optionName);
	public float getTotalPrice();
	public Automobile getAuto();
	public void setAutoStorage(AutoStorage storage);
}
