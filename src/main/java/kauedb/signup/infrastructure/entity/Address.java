package kauedb.signup.infrastructure.entity;

public class Address {

    private final Cep cep;
    private final String address;
    private final String complement;
    private final String neighborhood;
    private final String state;
    private final String country;

    public Address(Builder builder) {
        this.cep = builder.cep;
        this.address = builder.address;
        this.complement = builder.complement;
        this.neighborhood = builder.neighborhood;
        this.state = builder.state;
        this.country = builder.country;
    }


    public static class Builder {
        private Cep cep;
        private String address;
        private String complement;
        private String neighborhood;
        private String state;
        private String country;

        private Builder(final Cep cep) {
            this.cep = cep;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withComplement(final String complement) {
            this.complement = complement;
            return this;
        }

        public Builder withNeighborhood(final String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder withState(final String state) {
            this.state = state;
            return this;
        }

        public Builder withCountry(final String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        public static Builder addressBuilder(final Cep cep) {
            return new Builder(cep);
        }

    }

    public Cep getCep() {
        return cep;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
