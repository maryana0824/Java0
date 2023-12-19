package lab1.service;

import lab1.Medicine;
import main.lab1.model.Person;
import main.lab1.model.Pharmacy;

import java.util.List;

public class PharmacyService {
    private Pharmacy pharmacy;

    private PharmacyService(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Medicine> getListMedicine() {
        return pharmacy.getCountMedicines();
    }

    public boolean ifMedicineExist(Medicine medicine) {
        return pharmacy.getCountMedicines().stream().anyMatch(countMedicine -> countMedicine.getMedicine().equals(medicine));
    }

    public boolean sellMedicine(Medicine medicine, int count) {
        for (CountMedicine countMedicine : pharmacy.getCountMedicines()) {
            if (countMedicine.getMedicine().equals(medicine) && countMedicine.getCount() >= count) {
                countMedicine.setCount(countMedicine.getCount() - count);
                return true;
            }
        }
        return false;
    }

    public boolean checkOverdueDay(Medicine medicine) {
        return medicine.getOverdueDay().isAfter(pharmacy.getPharmacist().getBirthday());
    }

    public List<Medicine> getSortedByPrice() {
        List<Medicine> medicines = pharmacy.getCountMedicines();
        medicines.sort(Medicine::compareTo);
        return medicines;
    }

    public static class Builder {
        private Pharmacy pharmacy;

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        public PharmacyService build() {
            return new PharmacyService(pharmacy);
        }
    }
}

