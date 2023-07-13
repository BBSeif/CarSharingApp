package kz.CarSharing.dao;

import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppDao {
    void save(Company company);

    void save(Car car);

    void update(Company company);

    Company findCompanyByName (String companyName);

    Company findCompanyById(int id);

    void deleteCompany(Company tempCompany);


   List<Company> findAllCompany();

    List<Car> findCarsByCompanyId(int theId);

    Company findCompanyByIdJoinFetch(int theId);

    Car findCarById(int theId);

    void deleteCarById(int id);

    void updateCar(Car car);

    List<Car> allCars();

}
