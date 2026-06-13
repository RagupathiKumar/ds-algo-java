package system_design.solid;

/*
* Interface Segregation Principle
* */
public class ISP {}

// Below example violates
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker {
    @Override public void work() {}
    @Override public void eat() { /* Robot doesn't eat - forced to implement */ }
    @Override public void sleep() { /* Robot doesn't sleep - forced to implement */ }
}

// Below example follows
interface Workable { void work(); }
interface Eatable { void eat(); }
interface Sleepable { void sleep(); }

class Human implements Workable, Eatable, Sleepable {
    @Override public void eat() {}
    @Override public void sleep() {}
    @Override public void work() {}
}

class Robot1 implements Workable {
    @Override public void work() {}
}

// Split fat interfaces into smaller, focused ones so classes implement only what's relevant to them.