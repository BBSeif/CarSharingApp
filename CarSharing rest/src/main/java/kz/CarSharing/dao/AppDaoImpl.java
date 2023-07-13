package kz.CarSharing.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {
    private EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Company company) {
        entityManager.persist(company);
    }


    @Override
    public Company findCompanyById(int id) {
        return entityManager.find(Company.class, id);
    }



    @Override
    @Transactional
    public void deleteCompanyById(int id) {

        Company tempCompany = entityManager.find(Company.class, id);

        entityManager.remove(tempCompany);
    }

    @Override
    @Transactional
    public void update(Company company) {

    }

    @Override
    public Car findAllCars() {
        Car car =  entityManager.find(Car.class, 2);
        System.out.println(car);



        return car;
    }
}
