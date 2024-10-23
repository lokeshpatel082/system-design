package com.loki.design.patterns.singleton.synchronize;

public class DBConnection {
    private static DBConnection dbConnection;
    private DBConnection(){

    }

    synchronized public DBConnection getInstance() {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
