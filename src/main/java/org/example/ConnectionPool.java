package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private Queue<Connection> pool = new LinkedList<>();
    private int max_size =10;

    public ConnectionPool(){
        initializeConnectionPool();
    }

    private void initializeConnectionPool() {
        while(!checkIfConnectionPoolIsFull()){
            pool.add(createNewConnectionForPool());
        }
    }

    public synchronized void connectionToPool(Connection connection){
        pool.add(connection);
    }

    private synchronized boolean checkIfConnectionPoolIsFull() {
        if(pool.size() < max_size) {
            return false;
        }
        return true;
    }

    private Connection createNewConnectionForPool() {
        Connection connection = null;
        try{
            connection= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public synchronized Connection getConnectionFromPool(){
        Connection connection=null;
        if(pool.size()>0){
            connection=pool.poll();
        }
        return connection;
    }

    public void createTable(String tableName, String tableDefinition) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnectionFromPool();
            statement = connection.createStatement();
            String query = String.format("CREATE TABLE %s (%s)", tableName, tableDefinition);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connectionToPool(connection);
            }
        }
    }

    public void insertData(String tableName, String columnNames, String values) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnectionFromPool();
            statement = connection.createStatement();
            String query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnNames, values);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connectionToPool(connection);
            }
        }
    }


}
