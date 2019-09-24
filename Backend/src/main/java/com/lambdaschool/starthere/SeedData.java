package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.*;
import com.lambdaschool.starthere.services.RoleService;
import com.lambdaschool.starthere.services.SearchesService;
import com.lambdaschool.starthere.services.UserService;
import io.micrometer.core.instrument.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    SearchesService searchesService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getUseremails()
          .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1, "admin@mymail.local"));


        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("data", "password", datas);
        u2.getUseremails()
          .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "bunny@email.local"));


        ArrayList<Searches> searches = new ArrayList<>();
//        searches.add(new Searches("USC", "Colubmia", "SC", "45000", "Liberal Arts", u3));
        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("user", "password", users);
        u3.getUseremails()
          .add(new Useremail(u3, "barnbarn@email.local"));


        u1.getSavedSearches().add(new Searches("USC", "Colubmia", "SC", "45000", "Liberal Arts", u1));
        u2.getSavedSearches().add(new Searches("UW Madison", "Madison", "WI", "55000", "Piano Performance", u2));
        u3.getSavedSearches().add(new Searches("SEU", "Lakeland", "FL", "22500", "Leadership", u3));
        u3.getSavedSearches().add(new Searches("UWO", "Oshkosh", "WI", "47240", "MBA", u3));
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);


//        // seed saved searches
//        Searches s1 = new Searches("USC", "Colubmia", "SC", "45000", "Liberal Arts", u1);
//        Searches s2 = new Searches("UW Madison", "Madison", "WI", "55000", "Piano Performance", u2);
//        Searches s3 = new Searches("SEU", "Lakeland", "FL", "22500", "Leadership", u3);
//        Searches s4 = new Searches("UWO", "Oshkosh", "WI", "47240", "MBA", u3);


    }
}