package kauedb.signup.infrastructure.entity;

import java.util.ArrayList;
import java.util.Collection;

public class Person {

    private final String firstName, lastName;

    private final Iterable<Address> addresses;

    private final Login login;

    private final Iterable<PaymentMethod> paymentMethods;

    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.addresses = builder.addresses;
        this.login = builder.login;
        this.paymentMethods = builder.paymentMethods;
    }

    public static class Builder {
        private String firstName, lastName;

        private final Collection<Address> addresses = new ArrayList<>();

        private Login login;

        private final Collection<PaymentMethod> paymentMethods = new ArrayList<>();

        public Builder(String firstName, String lastName, Login login) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
        }


        public Builder addAddress(final Address address) {
            this.addresses.add(address);
            return this;
        }

        public Builder addPaymentMethod(final PaymentMethod paymentMethod) {
            this.paymentMethods.add(paymentMethod);
            return this;
        }

        public static Builder personBuilder(final String firstName, final String lastName, final Login login) {
            return new Builder(firstName, lastName, login);
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Iterable<Address> getAddresses() {
        return addresses;
    }

    public Login getLogin() {
        return login;
    }

    public Iterable<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }
}
