package com.esp.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esp.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
