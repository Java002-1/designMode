package com.biuder.Adapter.v2;

public class AdapterClass {
    public static void main(String[] args) {
        System.out.println(new Adapter().output5V());
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

class Adapter extends Adaptee implements Target{

    @Override
    public int output5V() {
        int i = output220V();
        System.out.println(String.format("原始电压：%d v -> 输出电压：%d v",i,5));
        return 5;
    }
}
