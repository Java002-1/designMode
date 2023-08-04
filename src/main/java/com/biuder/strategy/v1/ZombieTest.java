package com.biuder.strategy.v1;

public class ZombieTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        normalZombie.display();
    }
}

abstract class AbstractZombie{
   public abstract void display();

   public void attack(){
       System.out.println("咬");
   }

   public void move(){
       System.out.println("一步一步移动");
   }

}

class NormalZombie extends AbstractZombie{

    @Override
   public void display() {
        System.out.println("普通僵尸");
    }
}

class FlagZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("旗手僵尸");
    }
}

class BigHeadZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("大头");
    }

    @Override
    public void attack() {
        System.out.println("头撞");
    }
}


class xxxZombie extends BigHeadZombie {
    @Override
    public void display() {
        System.out.println("xxx");
    }
}