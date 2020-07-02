package ObserverObservable;

import java.util.ArrayList;
/**
 * Implement a modification of the Observer/Observable 
 * Design Pattern. See https://www.oodesign.com/observer-pattern.html 
 *
 
 *
 */
public class Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void attach(Observer o) {
		observers.add(o);
		
	}
	public void detach(Observer o) {
		observers.remove(o);
	}
	public void notifyObservers() {
		//System.out.println("uwu");
		for(Observer o:observers) {
			//System.out.println(11);
			o.update(this);
		}
	}
	
}
