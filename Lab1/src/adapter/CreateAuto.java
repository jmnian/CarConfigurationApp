package adapter;
import exception.*;

public interface CreateAuto {
	public void buildAuto(String fileName) throws AutoException;
	public void printAuto(String modelName);
}
