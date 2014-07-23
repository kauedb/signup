package kauedb.signup.infrastructure.entity;

import org.testng.annotations.Test;

import static kauedb.signup.infrastructure.entity.Address.Builder.addressBuilder;
import static kauedb.signup.infrastructure.entity.Cep.cep;
import static kauedb.signup.infrastructure.entity.Login.login;
import static kauedb.signup.infrastructure.entity.PaymentMethod.paymentMethod;
import static kauedb.signup.infrastructure.entity.Person.Builder.personBuilder;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BuildPersonTest {

    @Test
    public void buildWithFirstNameWithLastNameWithLogin() {
        final Login login = login("name", "password");
        final Person.Builder builder = personBuilder("first name", "last name", login);
        final Person person = builder.build();
        assertThat(person.getFirstName(), is("first name"));
        assertThat(person.getLastName(), is("last name"));
        assertThat(person.getLogin(), is(sameInstance(login)));
        assertThat(person.getLogin().getLogin(), is("name"));
        assertThat(person.getLogin().getPassword(), is("password"));
    }

    @Test
    public void buildWithAddress() {
        final Person.Builder builder = personBuilder("first name", "last name", login("name", "password"));
        final Cep cep = cep("02331", "002");
        final Address address = addressBuilder(cep)
                .withAddress("my address")
                .withComplement("my complement")
                .withNeighborhood("my Neighborhood")
                .withState("my State")
                .withCountry("my Country")
                .build();
        final Person person = builder.addAddress(address).build();
        assertThat(person, notNullValue());
        assertThat(person.getAddresses(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getCep(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getCep().getCode(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getCep().getNumber(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getAddress(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getComplement(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getCountry(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getNeighborhood(), notNullValue());
        assertThat(person.getAddresses().iterator().next().getState(), notNullValue());
    }

    @Test
    public void buildWithPaymentMethod() {
        final Person.Builder builder = personBuilder("first name", "last name", login("name", "password"));
        final PaymentMethod paymentMethod = paymentMethod("payment method");
        final Person person = builder.addPaymentMethod(paymentMethod).build();
        assertThat(person, notNullValue());
        assertThat(person.getPaymentMethods(), notNullValue());
        assertThat(person.getPaymentMethods().iterator().next().getPaymentMethod(), notNullValue());
    }

}
