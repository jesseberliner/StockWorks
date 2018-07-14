/*
 * This object represents an item.
 * It is identified by p_{local identifier}.
 */


package com.berliner.stockworks.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long p_id;

    @NotEmpty
    private String p_name;

    private String p_imgFile;

    @Size(min=2, max=240)
    private String p_desc;

    @NotEmpty
    private String p_sku;

    @NotEmpty
    private String p_upc;

    @NotNull
    @Min(0)
    private double p_price;

    @NotNull
    @Min(0)
    private double p_discount;  //Maybe not double?

    @NotNull
    private int p_numInStock;

    @NotEmpty
    private String p_department;

    @NotNull
    private boolean taxable;

    @NotNull
    private boolean deleted;


    public Product()
    {
        this.deleted = false;
    }

    //Getters and setters

    public long getP_id()
    {
        return p_id;
    }

    public void setP_id(long p_id)
    {
        this.p_id = p_id;
    }

    public String getP_name()
    {
        return p_name;
    }

    public void setP_name(String p_name)
    {
        this.p_name = p_name;
    }

    public String getP_imgFile()
    {
        return p_imgFile;
    }

    public void setP_imgFile(String p_imgFile)
    {
        this.p_imgFile = p_imgFile;
    }

    public String getP_desc()
    {
        return p_desc;
    }

    public void setP_desc(String p_desc)
    {
        this.p_desc = p_desc;
    }

    public String getP_sku()
    {
        return p_sku;
    }

    public void setP_sku(String p_sku)
    {
        this.p_sku = p_sku;
    }

    public String getP_upc()
    {
        return p_upc;
    }

    public void setP_upc(String p_upc)
    {
        this.p_upc = p_upc;
    }

    public double getP_price()
    {
        return p_price;
    }

    public void setP_price(double p_price)
    {
        this.p_price = p_price;
    }

    public double getP_discount()
    {
        return p_discount;
    }

    public void setP_discount(double p_discount)
    {
        this.p_discount = p_discount;
    }

    public int getP_numInStock()
    {
        return p_numInStock;
    }

    public void setP_numInStock(int p_numInStock)
    {
        this.p_numInStock = p_numInStock;
    }

    public String getP_department()
    {
        return p_department;
    }

    public void setP_department(String p_department)
    {
        this.p_department = p_department;
    }

    public boolean isTaxable()
    {
        return taxable;
    }

    public void setTaxable(boolean taxable)
    {
        this.taxable = taxable;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }
}
