package com.berliner.stockworks.Repositories;

import com.berliner.stockworks.Models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long>
{
}
