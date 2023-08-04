package com.biuder.Factory;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConcreteProductB();
        Product product = application.getObject();
        product.method1();
    }
}

interface  Product{
        void method1();
}
class ProductA implements Product{

    public void method1(){
        //业务逻辑处理
        System.out.println("ProductA.method1 execute");
    }

}
class ProductA1 implements Product{

    public void method1(){
        //业务逻辑处理
        System.out.println("ProductA1.method1 execute");
    }

}

abstract class Application{
    abstract Product createProduct();

    Product getObject(){
        Product product = createProduct();
        // 业务处理
        return product;
    }
}


class ConcreteProductA extends Application{

    @Override
    ProductA createProduct() {
        return new ProductA();
    }
}

class ConcreteProductB extends Application{

    @Override
    ProductA1 createProduct() {
        return new ProductA1();
    }
}