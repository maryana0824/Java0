package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас, який представляє особу (людину).
 */
public class Person {
    public static final int MAX_FIRST_NAME_LENGTH = 20;
    public static final double MIN_SALARY = 1000.00;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Double salary;

    // Приватний конструктор, щоб не дозволяти створювати об'єкти Person ізза меж класу
    // Може бути створений лише за допомогою Builder.
    private Person() {
    }

    // Гетери та сетери для полів класу Person.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }

    /**
     * Builder для класу Person.
     */
    public static class Builder {
        private Person person;

        /**
         * Конструктор Builder.
         */
        public Builder() {
            this.person = new Person();
        }

        /**
         * Встановити ім'я особи.
         *
         * @param firstName Ім'я особи.
         * @return Екземпляр Builder.
         */
        public Builder setFirstName(String firstName) {
            if (firstName.length() > MAX_FIRST_NAME_LENGTH) {
                throw new IllegalArgumentException("First name length must be less than or equal to " + MAX_FIRST_NAME_LENGTH);
            }
            person.firstName = firstName;
            return this;
        }

        /**
         * Встановити прізвище особи.
         *
         * @param lastName Прізвище особи.
         * @return Екземпляр Builder.
         */
        public Builder setLastName(String lastName) {
            if (lastName.length() > MAX_FIRST_NAME_LENGTH) {
                throw new IllegalArgumentException("Last name length must be less than or equal to " + MAX_FIRST_NAME_LENGTH);
            }
            person.lastName = lastName;
            return this;
        }

        /**
         * Встановити день народження особи.
         *
         * @param birthday День народження особи.
         * @return Екземпляр Builder.
         */
        public Builder setBirthday(LocalDate birthday) {
            person.birthday = birthday;
            return this;
        }

        /**
         * Встановити зарплату особи.
         *
         * @param salary Зарплата особи.
         * @return Екземпляр Builder.
         */
        public Builder setSalary(Double salary) {
            if (salary < MIN_SALARY) {
                throw new IllegalArgumentException("Salary must be greater than or equal to " + MIN_SALARY);
            }
            person.salary = salary;
            return this;
        }

        /**
         * Побудувати об'єкт Person.
         *
         * @return Об'єкт Person.
         */
        public Person build() {
            return person;
        }
    }
}

