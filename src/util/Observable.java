package util;

import java.util.ArrayList;

public class Observable<T> {
	
	private ArrayList<Observer<T>> observers = new ArrayList<>();
	
	public void notifyObservers(T t){
		for (Observer<T> observer : observers) {
			observer.update(t);
		}
	}
	
	public void addObserver(Observer<T> observer) {
		observers.add(observer);
	}
}
