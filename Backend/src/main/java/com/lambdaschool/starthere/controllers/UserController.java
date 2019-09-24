package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.ErrorDetail;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.services.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController
{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "returns all users", response = User.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value = "/users",
                produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Get user by ID.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User(s) Found", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "User Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/user/{userId}",
                produces = {"application/json"})
    public ResponseEntity<?> getUserById(HttpServletRequest request,
                                         @PathVariable
                                                 Long userId)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User u = userService.findUserById(userId);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Get user by name.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User Found", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "User Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/user/name/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> getUserByName(HttpServletRequest request,
                                           @PathVariable
                                                   String userName)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User u = userService.findByName(userName);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @ApiOperation(value = "Get current user name.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Username Found", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "Username Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/getusername",
                produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getCurrentUserName(HttpServletRequest request, Authentication authentication)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Add new user.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User Created", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "User could not be created", response = ErrorDetail.class)})
    @PostMapping(value = "/user",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewUser(HttpServletRequest request, @Valid
    @RequestBody
            User newuser) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newuser = userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{userid}")
                                                    .buildAndExpand(newuser.getUserid())
                                                    .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user by ID.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User Updated", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "User Not Found", response = ErrorDetail.class)})
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUser(HttpServletRequest request,
                                        @RequestBody
                                                User updateUser,
                                        @PathVariable
                                                long id)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.update(updateUser, id, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Delete user by ID.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User Deleted", responseContainer = "List", response =
                    User.class),
            @ApiResponse(code = 404, message = "User Not Found", response = ErrorDetail.class)})
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @ApiOperation(value = "Get user roles by ID.", response = User.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "User Roles deleted", responseContainer = "List", response =
//                    User.class),
//            @ApiResponse(code = 404, message = "User Not Found", response = ErrorDetail.class)})
//    @DeleteMapping("/user/{userid}/role/{roleid}")
//    public ResponseEntity<?> deleteUserRoleByIds(HttpServletRequest request,
//                                                 @PathVariable
//                                                         long userid,
//                                                 @PathVariable
//                                                         long roleid)
//    {
//        logger.trace(request.getMethod()
//                            .toUpperCase() + " " + request.getRequestURI() + " accessed");
//
//        userService.deleteUserRole(userid, roleid);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/user/{userid}/role/{roleid}")
    public ResponseEntity<?> postUserRoleByIds(HttpServletRequest request,
                                               @PathVariable
                                                       long userid,
                                               @PathVariable
                                                       long roleid)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.addUserRole(userid, roleid);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}