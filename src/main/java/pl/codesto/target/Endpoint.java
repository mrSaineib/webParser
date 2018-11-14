package pl.codesto.target;

public enum Endpoint {
    NASZE_MIEJSCE("https://naszemiejscerestauracja.pl/lunch/");

    private final String value;

    private Endpoint(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


}
