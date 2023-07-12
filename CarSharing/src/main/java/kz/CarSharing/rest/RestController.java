package kz.CarSharing.rest;

import kz.CarSharing.dao.AppDao;
import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import kz.CarSharing.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RestController {

    private AppDao appDao;

    @Autowired
    public RestController(AppDao appDao) {
        this.appDao = appDao;
    }


/**
 * For Company entity
 */
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        appDao.save(company);

        return "redirect:/company";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("companyId") int theId) {

        appDao.deleteCompanyById(theId);

        return "redirect:/company";
    }


//      List of Companies
    @GetMapping("/company")
    public String findCompanyWithCars(Model model) {

        List<Company> companies = appDao.findAllCompany();

        System.out.println("Got the companies!!!");


        model.addAttribute("company", companies);
        return "company-list";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model){

        Company company = new Company();

        model.addAttribute("company", company);

        return"company-form";
    }

//       The company with all details
    @GetMapping("/companyid")
    public String findCompanyAndCarById(@RequestParam("companyId")int theId, Model model) {

        List<Car> cars = appDao.findCarsByCompanyId(theId);

        Company company = appDao.findCompanyById(theId);


        model.addAttribute("cars", cars);
        model.addAttribute("company", company);
        return "car-list";
    }


    /**
     * For Car entity
     */

    @GetMapping("/addCar")
    public String  addCarToCompany(@RequestParam("companyId") int companyId, Model model) {

        Company tempCompany = appDao.findCompanyById(companyId);

        model.addAttribute("company", tempCompany);

        return "car-form";
    }


    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Company company ,@RequestParam("carName") String carName) {


        Car newCar = new Car(carName);
        newCar.setCompany(company);

        company.add(newCar);
        appDao.update(company);

        System.out.println(company);


        return "redirect:/company";
    }




    /**
     * For Customer entity
     */
}
