package com.biuder.Adapter.v1;

public class AdapterObject {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        System.out.println(target.output5V());

    }
}

class Adaptee{
    int output220V(){
        return 220;
    }
}

interface Target{
    int output5V();
}

class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public int output5V() {
        int i = adaptee.output220V();
        System.out.println(String.format("原始电压：%d v -> 输出电压：%d v",i,5));
        return 5;
    }
}
