package com.biuder.strategy.v2;

/**
 * 策略模式
 */
public class StrategyTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        normalZombie.setAttack(new HitAttack());

        normalZombie.attack();


    }
}

interface Move{
    void move();
}

interface Attack{
    void attack();
}


class StopByStep implements Move{

    @Override
    public void move() {
        System.out.println("一步一步移动");
    }
}

class BiteAttack implements Attack{

    @Override
    public void attack() {
        System.out.println("咬");
    }
}

class HitAttack implements Attack{

    @Override
    public void attack() {
        System.out.println("撞");
    }
}

abstract class AbstractZombie{
    Move move;
    Attack attack;

    public AbstractZombie(Move move, Attack attack) {
        this.move = move;
        this.attack = attack;
    }

    public abstract void display();

    public void move(){
        move.move();
    }

    public void attack(){
        attack.attack();
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }
}



class NormalZombie extends AbstractZombie{

    public NormalZombie() {
        super(new StopByStep(),new BiteAttack());
    }
    public NormalZombie(Move move, Attack attack) {
        super(move, attack);
    }

    @Override
    public void display() {
        System.out.println("普通僵尸");
    }


}
