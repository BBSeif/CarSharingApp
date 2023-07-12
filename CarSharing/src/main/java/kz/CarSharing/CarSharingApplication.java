package kz.CarSharing;

import kz.CarSharing.dao.AppDao;
import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import kz.CarSharing.entity.Customer;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarSharingApplication {

	public static void main(String[] args) {SpringApplication.run(CarSharingApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao) {

		return runner -> {
//			saveCompany(appDao);

//			findById(appDao);
		};
	}
//
//	private void findById(AppDao appDao) {
//		int num = 2;
//		Company company = appDao.findCompanyById(num);
//
//		System.out.println(company.toString());
//
//	}
//
//	private void saveCompany(AppDao appDao) {
//		Company company1 = new Company("Astana");
//		Company company2 = new Company("Almaty");
//		Company company3 = new Company("Shymkent");
//
//		Car toyota = new Car("Toyota");
//		Car kia = new Car("Kia");
//		Car honda = new Car("Honda");
//
//
//		Customer customer1 = new Customer("Askat");
//		Customer customer2 = new Customer("Maksat");
//		Customer customer3 = new Customer("Aian");
//
//		company1.add(kia);
//
//		company3.add(toyota);
//		company3.add(honda);
//
//
//
//		appDao.save(company1);
//		appDao.save(company2);
//		appDao.save(company3);
//		System.out.println("Company's saved !!!");
//	}
}
