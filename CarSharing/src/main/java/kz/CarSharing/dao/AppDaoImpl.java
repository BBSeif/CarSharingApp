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
    @Transactional
    public void save(Car car) {entityManager.persist(car);}

    @Override
    @Transactional
    public void update(Company company) {
        entityManager.merge(company);
    }

    @Override
    public Company findCompanyById(int id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public Company findCompanyByName(String companyName) {

        return entityManager.find(Company.class, companyName);
    }

    @Override
    @Transactional
    public void deleteCompany(Company tempCompany) {
        entityManager.remove(tempCompany);
    }

    @Override
    public List<Company> findAllCompany() {
        TypedQuery<Company> query =  entityManager.createQuery("select e from Company e ", Company.class);

        List<Company> companies = query.getResultList();

        System.out.println("Companies are: " + companies);
        return companies;
    }

    @Override
    public List<Car> findCarsByCompanyId(int theId) {

        //      create query
        TypedQuery<Car> query = entityManager.createQuery("from Car where company.id = :data", Car.class);

        query.setParameter("data", theId);

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public Company findCompanyByIdJoinFetch(int theId) {

        TypedQuery<Company> query = entityManager.createQuery("from Car where company.id = :data", Company.class);

        query.setParameter("data", theId);

        return query.getSingleResult();
    }


    @Override
    public Car findCarById(int theId) {
        return entityManager.find(Car.class, theId);
    }

    @Override
    @Transactional
    public void deleteCarById(int id) {
        Car car = entityManager.find(Car.class, id);

        entityManager.remove(car);
    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        entityManager.merge(car);
    }

    /**
     * Dao for Customer part
     */

    @Override
    public List<Car> allCars() {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c ", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }
}
