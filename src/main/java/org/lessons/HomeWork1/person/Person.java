package org.lessons.HomeWork1.person;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(String firstName,
                  String lastName,
                  String middleName,
                  String country,
                  String address,
                  String phone,
                  int age,
                  String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        PersonBuilder() {
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder country(String country) {
            this.country = country;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this.firstName,
                    this.lastName,
                    this.middleName,
                    this.country,
                    this.address,
                    this.phone,
                    this.age,
                    this.gender);
        }

    }

    @Override
    public String toString() {
        String NO_DATA_CONSTANT = "нет данных";
        return String.format("First name: %s, middle name: %s, last name: %s, country: %s, address: %s, phone: %s, age: %s, gender: %s",
                this.firstName == null ? NO_DATA_CONSTANT : this.firstName,
                this.lastName == null ? NO_DATA_CONSTANT : this.lastName,
                this.middleName == null ? NO_DATA_CONSTANT : this.middleName,
                this.country == null ? NO_DATA_CONSTANT : this.country,
                this.address == null ? NO_DATA_CONSTANT : this.address,
                this.phone == null ? NO_DATA_CONSTANT : this.phone,
                this.age == 0 ? NO_DATA_CONSTANT : this.age,
                this.gender == null ? NO_DATA_CONSTANT : this.gender);
    }
}
