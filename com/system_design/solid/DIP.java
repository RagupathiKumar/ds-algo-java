package system_design.solid;


/*
* Dependency Inversion Principle
* */
public class DIP {}

// Below example violates
class MySQLDatabase {
    void save(String data) {}
}

class UserService2 {
    MySQLDatabase db = new MySQLDatabase();
    void saveUser() {
        db.save("user");
    }
}
// UserService is tightly coupled to MySqlDatabase.
// Switching to PostgresSQL requires changing UserService.

// Below example follows
interface Database {
    void save(String data);
}

class MySQLDatabase1 implements Database {
    @Override public void save(String data) {}
}
class PostgresDatabase implements Database {
    @Override public void save(String data) {}
}

class UserService3 {
    Database db; // depends on abstraction
    UserService3(Database db) { this.db = db; } // injected
    void saveUser() {
        db.save("user");
    }
}
// Enables easy testing (mock) and swapping implementations.