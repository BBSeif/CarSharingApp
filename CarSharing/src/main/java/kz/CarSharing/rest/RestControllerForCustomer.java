package kz.CarSharing.rest;

import kz.CarSharing.dao.AppDao;
import kz.CarSharing.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class RestControllerForCustomer {
    private AppDao appDao;

    @Autowired
    public RestControllerForCustomer(AppDao appDao) {
        this.appDao = appDao;
    }

    @GetMapping("/carList")
    private String carList(Model model) {
        List<Car> theCars = new ArrayList<>();
        List<Car> cars = appDao.allCars();
        for (Car car: cars) {
            if (car.getCustomer() == null && car.getCompany() != null) {
                theCars.add(car);
            }
        }

        model.addAttribute("cars", theCars);

        return "carListForCustomer";
    }






}
