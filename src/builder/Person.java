package builder;

public class Person {

    private String firstName;
    private String lastName;
    private String pesel;

    private Person(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String pesel;

        private PersonBuilder(String pesel) {
            this.pesel = pesel;
        }

        public static PersonBuilder aPerson(String pesel) {
            return new PersonBuilder(pesel);
        }

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person build() {
            Person person = new Person(pesel);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            return person;
        }
    }
}
