package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.models.Searches;

import java.util.List;

public interface SearchesService
{
    List<Searches> findAll();

    Searches findSearchesById(long id);

    List<Searches> findByUserName(String username);

    void delete(long id, boolean isAdmin);

    Searches save(Searches searches, boolean isAdmin);
}
