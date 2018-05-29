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
import javax.validation.constraints.NotNull;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long p_id;

    @NotEmpty
    private String p_name;

    @NotEmpty
    private String p_sku;

    @NotEmpty
    private String p_upc;

    @NotNull
    private double p_price;

    @NotNull
    private double p_discount;  //Maybe not double?

    @NotEmpty
    private String p_source;

    @NotNull
    private int p_numInStock;

    @NotEmpty
    private String p_department;

    private boolean isTaxable;

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

    public String getP_source()
    {
        return p_source;
    }

    public void setP_source(String p_source)
    {
        this.p_source = p_source;
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
        return isTaxable;
    }

    public void setTaxable(boolean taxable)
    {
        isTaxable = taxable;
    }
}
