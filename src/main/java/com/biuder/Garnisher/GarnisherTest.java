package com.biuder.Garnisher;

/**
 * 装饰着
 */
public class GarnisherTest {

    public static void main(String[] args) {
        Compoent compoentBeauty = new CompoentBeauty(new ConcreteCompoent());
        Compoent concreteCompoent = new ComponentFilter(compoentBeauty);
        concreteCompoent.operation();
    }
}


interface Compoent{
    void operation();
}

class ConcreteCompoent implements Compoent{

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class abstractCompoent implements Compoent{
    Compoent compoent;

    public abstractCompoent(Compoent compoent) {
        this.compoent = compoent;
    }
}

class CompoentBeauty extends abstractCompoent{

    public CompoentBeauty(Compoent compoent) {
        super(compoent);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        compoent.operation();
    }
}

class ComponentFilter extends abstractCompoent{

    public ComponentFilter(Compoent compoent) {
        super(compoent);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        compoent.operation();
    }
}