package kauedb.signup.infrastructure.entity;

public class PaymentMethod {

    private final String paymentMethod;

    private PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static PaymentMethod paymentMethod(final String paymentMethod) {
        return new PaymentMethod(paymentMethod);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
