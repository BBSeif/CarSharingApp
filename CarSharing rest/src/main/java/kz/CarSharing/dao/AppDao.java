package kz.CarSharing.dao;

import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppDao {
    void save(Company company);

    Company findCompanyById(int id);

    void deleteCompanyById(int id);

    void update(Company company);

   Car findAllCars();
}
