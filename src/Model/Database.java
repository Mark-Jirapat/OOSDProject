package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    
    private Connection connection;
    private Statement statement;
    
    public Database(String text){
        System.out.println("----- " + text + " -----");
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://127.0.0.1/seproject";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(host, user, pass);
            System.out.println("Database : Connect Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Database : Connect Fail");
        }

    }
    
    public void disconnect(){
        try {
            statement.close();
            connection.close();
            System.out.println("Database : Disconnect Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Database : Disconnect Fail");
        }
    }
    
    public void createStatement(){
        try {
            statement = getConnection().createStatement();
            System.out.println("Database : Create Statement Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Database : Create Statement Fail");
        }
    }
    
    public void execute(String sql){ // INSERT, UPDATE, DELETE
        try {
            getStatement().execute(sql);
            System.out.println("Database : Execute Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Database : Execute Fail");
        }
    }
    
    public ResultSet executeQuery(String sql){ // SELECT
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            System.out.println("Database : ExecuteQuery Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Database : ExecuteQuery Fail");
        }
        return rs;
    }
    
    public void doExecute(String sql){
        connect();
        createStatement();
        execute(sql);
        disconnect();
    }
    
    public ResultSet doExecuteQuery(String sql){
        connect();
        createStatement();
        ResultSet resultSet = executeQuery(sql);
        disconnect();
        return resultSet;
    }
}
