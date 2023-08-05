package com.biuder.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class ObserverTest {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Subject subject = new Subject();
        subject.add(task1);
        Task2 task2 = new Task2();
        subject.add(task2);
        subject.notifyObserver("xxx");
        subject.remove(task1);
        System.out.println("-------------------------");
        subject.notifyObserver("yyy");
    }
}

class Subject{
    //容器
    private List<Observer> container = new ArrayList<>();
    //add
    public void add(Observer observer){
        if (!container.contains(observer)) {
            container.add(observer);
        }
    }
    //remove
    public void remove(Observer observer){
        if(container.contains(observer)){
            container.remove(observer);
        }
    }

    public void notifyObserver(Object object){
        for (Observer observer : container) {
            observer.update(object);
        }
    }
}

interface Observer{
    void update(Object object);
}


class Task1 implements Observer{


    @Override
    public void update(Object object) {
        System.out.println("Task1.update"+object);
    }
}


class Task2 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task2.update"+object);
    }
}