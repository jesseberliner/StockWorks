package com.berliner.stockworks.Controllers;

import com.berliner.stockworks.Configs.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import com.berliner.stockworks.Models.Product;
import com.berliner.stockworks.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainController
{
    //Repositories

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CloudinaryConfig cloudc;

/***************************************************************************************
General
 ***************************************************************************************/

    @RequestMapping({"/","/welcome"})
    public String welcomePage()
    {
        return "welcome";
    }

    @RequestMapping("/viewstock")
    public String viewStock(Model model)
    {
        model.addAttribute("allProducts", productRepo.findByDeletedIs(false));
        return "viewstock";
    }


/***************************************************************************************
Manager
 ***************************************************************************************/
    @GetMapping("/addproduct")
    public String addProduct(Model model)
    {
        model.addAttribute("newProduct", new Product());
        return "managerAccess/addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestParam("file")MultipartFile file, @Valid @ModelAttribute("newProduct")Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "managerAccess/addproduct";
        }

        if(!file.isEmpty()) {

            try {
                Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
                product.setP_imgFile(uploadResult.get("url").toString());
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:managerAccess/addproduct";
            }
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

    @RequestMapping("/deleteproduct/{p_id}")
    public String deleteProduct(@PathVariable ("p_id") long id)
    {
        Product product = productRepo.findOne(id);
        product.setDeleted(true);
        productRepo.save(product);

        return "redirect:/viewstock";
    }
/***************************************************************************************
Employee
 ***************************************************************************************/
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


/***************************************************************************************
 Customer
 ***************************************************************************************/

    @GetMapping("/cviewstock")
    public String cViewStock(Model model)
    {
        model.addAttribute("products", productRepo.findByDeletedIs(false));
        return "customerAccess/customerviewstock";
    }

}
