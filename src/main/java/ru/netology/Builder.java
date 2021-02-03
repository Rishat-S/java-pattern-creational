package ru.netology;

public interface Builder {
    Builder setName(String name);

    Builder setSurname(String surname);

    Builder setAge(int age);

    Builder setAddress(String address);

    Person build();
}
