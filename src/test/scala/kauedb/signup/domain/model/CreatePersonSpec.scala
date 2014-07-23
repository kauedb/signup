package kauedb.signup.domain.model

import org.scalatest._

//@RunWith(classOf[JUnitRunner])
class CreatePersonSpec extends FlatSpec with Matchers {

  "a person without address and payment methods" should "be created" in {
    val person = Person(firstName = "first name"
      , lastName = "last name"
      , login = Login(login = "login", password = "password"))

    person.firstName should be("first name")
    person.lastName should be("last name")
    person.login.login should be("login")
    person.login.password should be("password")
    person.addresses should be(empty)
    person.paymentMethods should be(empty)
  }

  "a person" should "be created" in {
    val person = Person(firstName = "first name"
      , lastName = "last name"
      , login = Login(login = "login", password = "password")
      , addresses = List[Address](Address(Cep(number = "02331", digit = "002")))
      , paymentMethods = List[PaymentMethod](PaymentMethod("payment method")))

    person.firstName should be("first name")
    person.lastName should be("last name")
    person.login.login should be("login")
    person.login.password should be("password")
    person.addresses.iterator.next().cep.number should be("02331")
    person.addresses.iterator.next().cep.digit should be("002")
    person.paymentMethods.iterator.next().paymentMethod should be("payment method")
  }

}
