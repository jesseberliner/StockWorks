package com.berliner.stockworks.Controllers;

import com.berliner.stockworks.Models.Product;
import com.berliner.stockworks.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addProduct(@Valid @ModelAttribute("newProduct")Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "managerAccess/addproduct";
        }
        productRepo.save(product);
        return "managerAccess/viewaddedproduct";
    }

    @GetMapping("/update/{p_id}")
    public String updateProduct(@PathVariable("p_id") long id, Model model)
    {
        model.addAttribute("newProduct", productRepo.findOne(id));

        return "managerAccess/addproduct";

    }

    @GetMapping("/addstock/{p_id}")
    public String updateStock(@PathVariable("p_id") long id, Model model)
    {
        model.addAttribute("changeProduct", productRepo.findOne(id));
        return "employeeAccess/addstock";

    }
//Needs correction if left blank
    @PostMapping("/addstock")
    public String updateStock(@ModelAttribute("changeProduct")Product product)
    {

        Product changed = productRepo.findOne(product.getP_id());
        changed.setP_numInStock(product.getP_numInStock());

        productRepo.save(changed);

        return "redirect:/viewstock";

    }

    @RequestMapping("/deleteproduct/{p_id}")
    public String deleteProduct(@PathVariable ("p_id") long id)
    {
        Product product = productRepo.findOne(id);
        product.setDeleted(true);
        productRepo.save(product);

        return "redirect:/viewstock";
    }

    @RequestMapping("/viewstock")
    public String viewStock(Model model)
    {
        model.addAttribute("allProducts", productRepo.findByDeletedIsFalse());
        return "viewstock";
    }



}
