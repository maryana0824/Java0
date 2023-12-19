package lab1.model;

import java.util.List;

/**
 * Клас, який представляє аптеку.
 */
public class Pharmacy {
    public static final int MAX_NAME_LENGTH = 20;
    private String name;
    private List<CountMedicine> countMedicines;
    private Person pharmacist;

    /**
     * Конструктор за замовчуванням.
     */
    public Pharmacy() {
    }

    /**
     * Конструктор з параметрами.
     *
     * @param name           Назва аптеки.
     * @param countMedicines Список ліків та їх кількість.
     * @param pharmacist     Фармацевт, який працює в аптеці.
     */
    public Pharmacy(String name, List<CountMedicine> countMedicines, Person pharmacist) {
        this.name = name;
        this.countMedicines = countMedicines;
        this.pharmacist = pharmacist;
    }

    /**
     * Отримати назву аптеки.
     *
     * @return Назва аптеки.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановити назву аптеки.
     *
     * @param name Назва аптеки.
     */
    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length must be less than or equal to " + MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    /**
     * Отримати список ліків та їх кількість.
     *
     * @return Список ліків та їх кількість.
     */
    public List<CountMedicine> getCountMedicines() {
        return countMedicines;
    }

    /**
     * Встановити список ліків та їх кількість.
     *
     * @param countMedicines Список ліків та їх кількість.
     */
    public void setCountMedicines(List<CountMedicine> countMedicines) {
        this.countMedicines = countMedicines;
    }

    /**
     * Отримати фармацевта, який працює в аптеці.
     *
     * @return Фармацевт.
     */
    public Person getPharmacist() {
        return pharmacist;
    }

    /**
     * Встановити фармацевта, який працює в аптеці.
     *
     * @param pharmacist Фармацевт.
     */
    public void setPharmacist(Person pharmacist) {
        this.pharmacist = pharmacist;
    }

    // Додайте методи toString, equals, hashCode для класу Pharmacy.

    /**
     * Клас, який представляє лікарський препарат та його кількість.
     */
    public static class CountMedicine {
        private Medicine medicine;
        private int count;

        // Конструктори, гетери та сетери для CountMedicine.

        // Додайте методи toString, equals, hashCode для класу CountMedicine.
    }

    /**
     * Builder для класу Pharmacy.
     */
    public static class Builder {
        private Pharmacy pharmacy;

        /**
         * Конструктор Builder.
         */
        public Builder() {
            pharmacy = new Pharmacy();
        }

        /**
         * Встановити назву аптеки.
         *
         * @param name Назва аптеки.
         * @return Екземпляр Builder.
         */
        public Builder setName(String name) {
            pharmacy.setName(name);
            return this;
        }

        /**
         * Встановити список ліків та їх кількість.
         *
         * @param countMedicines Список ліків та їх кількість.
         * @return Екземпляр Builder.
         */
        public Builder setCountMedicines(List<CountMedicine> countMedicines) {
            pharmacy.setCountMedicines(countMedicines);
            return this;
        }

        /**
         * Встановити фармацевта, який працює в аптеці.
         *
         * @param pharmacist Фармацевт.
         * @return Екземпляр Builder.
         */
        public Builder setPharmacist(Person pharmacist) {
            pharmacy.setPharmacist(pharmacist);
            return this;
        }

        /**
         * Побудувати об'єкт Pharmacy.
         *
         * @return Об'єкт Pharmacy.
         */
        public Pharmacy build() {
            return pharmacy;
        }
    }
}

