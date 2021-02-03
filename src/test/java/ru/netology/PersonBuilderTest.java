package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonBuilderTest {

    PersonBuilder personBuilder = new PersonBuilder();


    @Test
    void testSetAgeLessZero() {

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> personBuilder.setAge(-100));

        assertEquals("Age is not correct", exception.getMessage());

    }

    @Test
    void testSetAgeOver100() {

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> personBuilder.setAge(101));

        assertEquals("Age is not correct", exception.getMessage());

    }

    @Test
    void testBuildNoNameAndSurname() {
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> personBuilder.build());

        assertEquals("Mandatory fields are not filled in", exception.getMessage());
    }

    @Test
    void testBuildNoName() {
        personBuilder.setName("Name");
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> personBuilder.build());

        assertEquals("Mandatory fields are not filled in", exception.getMessage());
    }

    @Test
    void testBuildNoSurname() {
        personBuilder.setSurname("Surname");
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> personBuilder.build());

        assertEquals("Mandatory fields are not filled in", exception.getMessage());
    }
}