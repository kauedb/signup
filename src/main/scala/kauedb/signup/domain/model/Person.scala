package kauedb.signup.domain.model

case class Person(firstName: String
                  , lastName: String
                  , login: Login
                  , addresses: List[Address] = List.empty
                  , paymentMethods: List[PaymentMethod] = List.empty) {

}