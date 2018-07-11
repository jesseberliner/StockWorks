package com.berliner.stockworks.Controllers;

import com.berliner.stockworks.Models.Product;
import com.berliner.stockworks.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController
{

    @Autowired
    ProductRepo productRepo;

    @RequestMapping({"/","/welcome"})
    public String welcomePage()
    {
        return "welcome";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model)
    {
        model.addAttribute("newProduct", new Product());
        return "managerAccess/addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("newProduct")Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "managerAccess/addproduct";
        }
        productRepo.save(product);
        return "managerAccess/viewaddedproduct";
    }
    //For postMapping/Validation
    // public String submitPerson(@Valid @ModelAttribute("newPerson")PersonUser person, BindingResult result)

    @GetMapping("/update/{p_id}")
    public String updateProduct(@PathVariable("p_id") long id, Model model)
    {
        model.addAttribute("newProduct", productRepo.findOne(id));

        return "managerAccess/addproduct";

    }

    @RequestMapping("/viewstock")
    public String viewStock(Model model)
    {
        model.addAttribute("allProducts", productRepo.findAll());
        return "viewstock";
    }
}
