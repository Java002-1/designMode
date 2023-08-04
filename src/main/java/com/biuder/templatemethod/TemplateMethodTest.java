package com.biuder.templatemethod;

/**
 * 模板方法模式
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass = new SubClass();

        abstractClass.operation();
    }
}

abstract class AbstractClass{
    public void operation(){
        System.out.println("操作1");
        System.out.println("操作2");
        System.out.println("操作3");
        System.out.println("操作4");
        System.out.println("操作5");

        templateMethod();
    }

    abstract void templateMethod();
}

class SubClass extends AbstractClass{

    @Override
    void templateMethod() {
        System.out.println("子类实现");
    }
}
