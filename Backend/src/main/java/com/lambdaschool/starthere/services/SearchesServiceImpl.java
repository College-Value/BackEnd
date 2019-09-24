package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.models.Searches;
import com.lambdaschool.starthere.repository.SearchesRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "searchesService")
public class SearchesServiceImpl implements SearchesService
{

    @Autowired
    UserRepository userrepos;

    @Autowired
    SearchesRepository searchesrepos;

    @Override
    public List<Searches> findAll()
    {
        List<Searches> list = new ArrayList<>();
        searchesrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Searches findSearchesById(long id)
    {
        return searchesrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Search with id " + id + " Not Found!"));
    }

    @Override
    public List<Searches> findByUserName(String username)
    {
        return searchesrepos.findAllByUser_Username(username);
    }

    @Override
    public void delete(long id, boolean isAdmin)
    {
        if (searchesrepos.findById(id)
                .isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext()
                    .getAuthentication();
            if (searchesrepos.findById(id)
                    .get()
                    .getUser()
                    .getUsername()
                    .equalsIgnoreCase(authentication.getName()) || isAdmin)
            {
                searchesrepos.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
            }
        } else
        {
            throw new ResourceNotFoundException("Useremail with id " + id + " Not Found!");
        }
    }

    @Override
    public Searches save(Searches searches, boolean isAdmin)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (searches.getUser()
                .getUsername()
                .equalsIgnoreCase(authentication.getName()) || isAdmin)
        {
            return searchesrepos.save(searches);
        } else
        {
            throw new ResourceNotFoundException((authentication.getName() + "not authorized to make change"));
        }
    }
}