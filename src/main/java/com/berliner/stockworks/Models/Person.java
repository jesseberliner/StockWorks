package com.berliner.stockworks.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long p_id;
}
