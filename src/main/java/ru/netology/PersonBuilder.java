package ru.netology;

public class PersonBuilder implements Builder {
    private String name;
    private String surname;
    private int age;
    private String address;

    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Age is not correct");
        }
    }

    @Override
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {

        if (name != null && surname != null) {
            Person person = new Person(
                    this.name,
                    this.surname,
                    this.age
            );

            person.setAddress(this.address);

            return person;
        } else {
            throw new IllegalStateException("Mandatory fields are not filled in");
        }

    }
}
