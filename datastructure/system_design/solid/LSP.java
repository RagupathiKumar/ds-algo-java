package system_design.solid;

/*
* Liskov Substitution Principle
* */
public class LSP {}

// Below example violates
class Bird {
    void fly() {}
}

class Penguin extends Bird {
    @Override
    void fly() {
        throw new RuntimeException("Cant fly!"); // breaks expectation
    }
}

// Below example follows
class Bird1 {
    void eat() {}
}

class FlyingBird extends Bird1 {
    void fly() {}
}
class Sparrow extends FlyingBird {
    @Override void eat() {}
    @Override void fly() {}
}

class NonFlyingBird extends Bird1 {}
class Penguin1 extends NonFlyingBird {
    @Override void eat() {}
}

// Now Substituting any Bird subtype won't break behavior.

