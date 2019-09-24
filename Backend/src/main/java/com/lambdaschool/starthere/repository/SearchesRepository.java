package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Searches;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchesRepository extends CrudRepository<Searches, Long>
{
    List<Searches> findAllByUser_Username(String name);
}
