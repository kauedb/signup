package kauedb.signup.infrastructure.entity;

public class Cep {

    private final String number, code;

    private Cep(final String number, final String code) {
        this.number = number;
        this.code = code;
    }

    public static Cep cep(final String number, final String code) {
        return new Cep(number, code);
    }

    public String getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }
}
