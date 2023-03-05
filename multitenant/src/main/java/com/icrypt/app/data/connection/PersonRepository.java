package com.icrypt.app.data.connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icrypt.app.multitenant.entity.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	  Person findById(long id);
	}

