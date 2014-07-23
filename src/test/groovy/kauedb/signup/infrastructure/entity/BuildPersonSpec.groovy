package kauedb.signup.infrastructure.entity

import spock.lang.Specification

import static kauedb.signup.infrastructure.entity.Address.Builder.addressBuilder
import static kauedb.signup.infrastructure.entity.Cep.cep
import static kauedb.signup.infrastructure.entity.Login.login
import static kauedb.signup.infrastructure.entity.PaymentMethod.paymentMethod
import static kauedb.signup.infrastructure.entity.Person.Builder.personBuilder
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.CoreMatchers.sameInstance
import static org.hamcrest.MatcherAssert.assertThat

class BuildPersonSpec extends Specification {

    def login = login("login", "password")
    def firstName = "first name"
    def lastName = "last name"

    Person.Builder builder = personBuilder(firstName, lastName, login)

    Person person

    def "should build person with first name, last name and login"() {
        when:
        person = builder.build();
        then:
        assertThat person.firstName, is("first name")
        assertThat person.lastName, is("last name")
        assertThat person.login, is(sameInstance(login))
        assertThat person.login.login, is("login")
        assertThat person.login.password, is("password")
    }

    def address

    def "should build person with one address "() {
        when:
        address = addressBuilder(cep("02331", "002")).build()
        person = builder.addAddress(address).build()
        then:
        assertThat person.addresses.first(), is(address)
    }

    def paymentMethod

    def "should build person with with one payment method"() {
        when:
        paymentMethod = paymentMethod("payment method")
        person = builder.addPaymentMethod(paymentMethod).build()
        then:
        assertThat person.paymentMethods.first(), is(paymentMethod)
    }

}
