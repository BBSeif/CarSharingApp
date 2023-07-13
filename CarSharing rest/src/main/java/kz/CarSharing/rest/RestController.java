package kz.CarSharing.rest;

import kz.CarSharing.dao.AppDao;
import kz.CarSharing.entity.Car;
import kz.CarSharing.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RestController {

    private AppDao appDao;

    @Autowired
    public RestController(AppDao appDao) {
        this.appDao = appDao;
    }



    @GetMapping("/cars")
    public String  findAll(Model model) {
        Car car = appDao.findAllCars();

        model.addAttribute("car", car);
        return "car-list";
    }


}
