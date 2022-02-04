package model;

import java.util.*;
import adapter.*;

public class AutoStorage{
	private LinkedHashMap<String, Automobile> map;
	
	public AutoStorage(){}
	public AutoStorage(LinkedHashMap<String, Automobile> map) {
		this.map = map;
	}
	public LinkedHashMap<String, Automobile> getMap() {
		return this.map;
	}
	public Automobile getAutomobile(String name) {
		return this.map.get(name);
	}
	public void setMap(int size) {
		this.map = new LinkedHashMap<String, Automobile>(size);
	}
	public void addAutomobile(String name, Automobile auto) {
		map.put(name, auto);
	}
	public void removeAutomobile(String name) {
		map.remove(name);
	}
	public void iterateAutomobileNames() {
		Collection c = this.map.values();
		Iterator itr = c.iterator();
		while (itr.hasNext()) {
			Automobile cur = (Automobile) itr.next();
			System.out.println(cur.getName());
		}
	}
}
