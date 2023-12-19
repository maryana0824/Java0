package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас, який представляє лікарський препарат.
 */
public class Medicine implements Comparable<Medicine> {
    public static final int MAX_NAME_LENGTH = 20;
    private String name;
    private String form;
    private Double price;
    private LocalDate overdueDay;

    // Приватний конструктор, щоб не дозволяти створювати об'єкти Medicine ізза меж класу
    // Може бути створений лише за допомогою Builder.
    private Medicine() {
    }

    /**
     * Конструктор з параметрами.
     *
     * @param name       Назва лікарського препарату.
     * @param form       Форма випуску препарату.
     * @param price      Ціна препарату.
     * @param overdueDay Термін придатності препарату.
     */
    public Medicine(String name, String form, Double price, LocalDate overdueDay) {
        this.name = name;
        this.form = form;
        this.price = price;
        this.overdueDay = overdueDay;
    }

    /**
     * Отримати назву лікарського препарату.
     *
     * @return Назва лікарського препарату.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановити назву лікарського препарату.
     *
     * @param name Назва лікарського препарату.
     */
    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length must be less than or equal to " + MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    /**
     * Отримати форму випуску препарату.
     *
     * @return Форма випуску препарату.
     */
    public String getForm() {
        return form;
    }

    /**
     * Встановити форму випуску препарату.
     *
     * @param form Форма випуску препарату.
     */
    public void setForm(String form) {
        if (form.length() > 30) {
            throw new IllegalArgumentException("Form length must be less than or equal to 30");
        }
        this.form = form;
    }

    /**
     * Отримати ціну препарату.
     *
     * @return Ціна препарату.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Встановити ціну препарату.
     *
     * @param price Ціна препарату.
     */
    public void setPrice(Double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    /**
     * Встановити термін придатності препарату.
     *
     * @param overdueDay Термін придатності препарату.
     */
    public void setOverdueDay(LocalDate overdueDay) {
        if (overdueDay.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Overdue day must be in the future");
        }
        this.overdueDay = overdueDay;
    }

    /**
     * Отримати термін придатності препарату.
     *
     * @return Термін придатності препарату.
     */
    public LocalDate getOverdueDay() {
        return overdueDay;
    }

    // Гетери та сетери для інших полів класу Medicine.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(name, medicine.name) &&
                Objects.equals(form, medicine.form) &&
                Objects.equals(overdueDay, medicine.overdueDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, form, overdueDay);
    }

    @Override
    public int compareTo(Medicine o) {
        return Double.compare(this.price, o.price);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", form='" + form + '\'' +
                ", price=" + price +
                ", overdueDay=" + overdueDay +
                '}';
    }

    /**
     * Builder для класу Medicine.
     */
    public static class Builder {
        private Medicine medicine;

        /**
         * Конструктор Builder.
         */
        public Builder() {
            medicine = new Medicine();
        }

        /**
         * Встановити назву лікарського препарату.
         *
         * @param name Назва лікарського препарату.
         * @return Екземпляр Builder.
         */
        public Builder setName(String name) {
            medicine.setName(name);
            return this;
        }

        /**
         * Встановити форму випуску препарату.
         *
         * @param form Форма випуску препарату.
         * @return Екземпляр Builder.
         */
        public Builder setForm(String form) {
            medicine.setForm(form);
            return this;
        }

        /**
         * Встановити ціну препарату.
         *
         * @param price Ціна препарату.
         * @return Екземпляр Builder.
         */
        public Builder setPrice(Double price) {
            medicine.setPrice(price);
            return this;
        }

        /**
         * Встановити термін придатності препарату.
         *
         * @param overdueDay Термін придатності препарату.
         * @return Екземпляр Builder.
         */
        public Builder setOverdueDay(LocalDate overdueDay) {
            medicine.setOverdueDay(overdueDay);
            return this;
        }

        /**
         * Побудувати об'єкт Medicine.
         *
         * @return Об'єкт Medicine.
         */
        public Medicine build() {
            return medicine;
        }
    }
}

