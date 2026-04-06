package system_design.solid;

/*
* Open Closed Principle
* */
public class OCP {}

// Below example violates
class PaymentProcessor {

    void pay(String type) {
        if (type.equals("credit")) {
            /* credit logic */
        } else if (type.equals("paypal")) {
            /* paypal logic */
        }
        // Adding new payment - modify this class
    }

}

// Below example follows
interface Payment { void pay(); }

class CreditPayment implements Payment {
    @Override
    public void pay() {}
}
class PaypalPayment implements Payment {
    @Override
    public void pay() {}
}
class UpiPayment implements Payment {
    @Override
    public void pay() {}
}
// new type, no change to existing code

class PaymentProcessor1 {
    void process(Payment p) {
        p.pay();
    }
}
// Adding a new payment type - add a new class, no modification to existing code
