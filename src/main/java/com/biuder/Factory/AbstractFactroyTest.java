package com.biuder.Factory;

/**
 * 抽象工厂模式
 */
public class AbstractFactroyTest {

    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new MysqlDatabaseUtils();
        IConnection connection = databaseUtils.createConnection();
        connection.connect();
        ICommand command = databaseUtils.createCommand();
        command.command();
    }

}


interface IConnection{
    void connect();
}

class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("MysqlConnection.connect");
    }
}

interface ICommand{
    void command();
}

class MysqlCommand implements ICommand{
    @Override
    public void command() {
        System.out.println("MysqlCommand.command");
    }
}

interface IDatabaseUtils{
    IConnection createConnection();
    ICommand createCommand();
}


class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection createConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand createCommand() {
        return new MysqlCommand();
    }
}