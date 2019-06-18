package com.example.ex2;

public interface ObservableInterface {
    void addToObserver(ObserverInterface obs);
    void notifyObservers(String s);
}
