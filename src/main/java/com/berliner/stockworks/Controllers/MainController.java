package com.berliner.stockworks.Controllers;

import com.berliner.stockworks.Models.Product;
import com.berliner.stockworks.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{

    @Autowired
    ProductRepo productRepo;

    @RequestMapping("/")
    public String welcomePage()
    {
        return "welcome";
    }

    @GetMapping("/test")
    public String testPage()
    {
        return "base";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model)
    {
        model.addAttribute("newProduct", new Product());
        System.out.println("here");
        return "managerAccess/addproduct";
    }
    //For postMapping/Validation
    // public String submitPerson(@Valid @ModelAttribute("newPerson")PersonUser person, BindingResult result)

    @RequestMapping("/viewstock")
    public String viewStock(Model model)
    {
        model.addAttribute("allProducts", productRepo.findAll());
        return "viewstock";
    }

//    @RequestMapping("/error")
//    public String errorPage()
//    {
//        return "errorpage";
//    }
}
