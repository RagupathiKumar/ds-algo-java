package system_design.solid;

/*
* Single Responsibility Principle
* */
public class SRP {}

// Below example violates
class UserService {
    void createUser() {}    // business logic
    void sendEmail() {}     // notification logic
    void saveToDb() {}      // persistence logic
}

// Below example follows
class UserService1 { void createUser() {} }
class EmailService { void sendEmail() {} }
class UserRepository { void save() {} }

// Each class now has one job and one reason to change