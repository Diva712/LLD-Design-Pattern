package CreationalDesignPattern.ObjectPoolDesignPattern.DBConnectionExample;
//Resource

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

class DbConnection {
  Connection mySqlConnection;

  DbConnection() {
    try {
      mySqlConnection = DriverManager.getConnection("url", "user", "password");
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}

// Resource Manager
class DbConnectionPoolManager {
  List<DbConnection> freeConnectionPool = new ArrayList<>();
  List<DbConnection> connectionInUsePool = new ArrayList<>();
  int MAX_POOL_SIZE = 6;
  int INITIAL_POOL_SIZE = 3;

  // private Constructor
  private DbConnectionPoolManager() {
    for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
      freeConnectionPool.add(new DbConnection());
    }
  }

  // create singleton object
  private static DbConnectionPoolManager dbConnectionPoolManagerInstance = null;

  // getinstance method
  public static DbConnectionPoolManager getInstance() {
    if (dbConnectionPoolManagerInstance == null) {
      synchronized (DbConnectionPoolManager.class) {
        if (dbConnectionPoolManagerInstance == null) {
          dbConnectionPoolManagerInstance = new DbConnectionPoolManager();
        }
      }
    }
    return dbConnectionPoolManagerInstance;
  }

  // get dB connectio using DBconnection Pool Manager
  synchronized DbConnection getDBConnection() {
    if (freeConnectionPool.isEmpty() && connectionInUsePool.size() < MAX_POOL_SIZE) {
      freeConnectionPool.add(new DbConnection());
      System.out.println(
          "Creating a new Dbconnection object and size of freeDBconnection Pool is : " + freeConnectionPool.size());
    } else if (freeConnectionPool.isEmpty() && connectionInUsePool.size() >= MAX_POOL_SIZE) {
      System.out.println("You can not create a DB connection object because Limit is full !! ");
      return null;
    }

    DbConnection db = freeConnectionPool.remove(freeConnectionPool.size() - 1);
    connectionInUsePool.add(db);
    System.out.println(
        "One Connection Is in use and add to connectionInUSe Pool and it size is : " + connectionInUsePool.size());

    return db;

  }

  // Release DB Connection using DBConnection Pool Manager
  synchronized void releaseDBConnection(DbConnection db) {
    if (db != null) {
      connectionInUsePool.remove(db);
      System.out.println(
          "Db connection object is removed form the connectionInUsePool and its size is " + connectionInUsePool.size());
      freeConnectionPool.add(db);
      System.out.println("Db connect is add in to free connection pool and its size is " + freeConnectionPool.size());
    }
  }
}

public class Main {
  public static void main(String[] args) {
    DbConnectionPoolManager dbConnectionPoolManager = DbConnectionPoolManager.getInstance();
    DbConnection db1 = dbConnectionPoolManager.getDBConnection();
    DbConnection db2 = dbConnectionPoolManager.getDBConnection();
    DbConnection db3 = dbConnectionPoolManager.getDBConnection();
    DbConnection db4 = dbConnectionPoolManager.getDBConnection();
    DbConnection db5 = dbConnectionPoolManager.getDBConnection();
    DbConnection db6 = dbConnectionPoolManager.getDBConnection();
    DbConnection db7 = dbConnectionPoolManager.getDBConnection();
    System.out.println("value of db7 is " + db7);
    dbConnectionPoolManager.releaseDBConnection(db6);

  }
}
