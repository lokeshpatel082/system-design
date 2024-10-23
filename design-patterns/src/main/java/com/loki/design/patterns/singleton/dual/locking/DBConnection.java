package com.loki.design.patterns.singleton.dual.locking;

public class DBConnection {
    private static DBConnection dbConnection;
    private DBConnection(){

    }

    public static DBConnection getInstance() {
        if(dbConnection == null){
            synchronized (DBConnection.class){
                if(dbConnection == null){
                    dbConnection = new DBConnection();
                }
            }
        }
        return dbConnection;
    }
}
