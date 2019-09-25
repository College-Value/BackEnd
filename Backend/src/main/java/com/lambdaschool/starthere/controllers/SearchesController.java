package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.ErrorDetail;
import com.lambdaschool.starthere.models.Searches;
import com.lambdaschool.starthere.models.Searches;

import com.lambdaschool.starthere.services.SearchesService;

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
@RequestMapping("/searches")
public class SearchesController
{
    private static final Logger logger = LoggerFactory.getLogger(SearchesController.class);

    @Autowired
    private SearchesService searchesService;

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "returns all searches", response = Searches.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value = "/searches",
            produces = {"application/json"})
    public ResponseEntity<?> listAllSearches(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Searches> mySearches = searchesService.findAll();
        return new ResponseEntity<>(mySearches, HttpStatus.OK);
    }


//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Get searches by ID.", response = Searches.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Searches(s) Found", responseContainer = "List", response =
                    Searches.class),
            @ApiResponse(code = 404, message = "Searches Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> getSearchesById(HttpServletRequest request,
                                         @PathVariable
                                                 Long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Searches u = searchesService.findSearchesById(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }



//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Add new searches.", response = Searches.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Searches Created", responseContainer = "List", response =
                    Searches.class),
            @ApiResponse(code = 404, message = "Searches could not be created", response = ErrorDetail.class)})
    @PostMapping(value = "/searches",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewSearches(HttpServletRequest request, @Valid
    @RequestBody
            Searches newsearches) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newsearches = searchesService.save(newsearches);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newSearchesURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newsearches.getSearchid())
                .toUri();
        responseHeaders.setLocation(newSearchesURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

//    @ApiOperation(value = "Update searches by ID.", response = Searches.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Searches Updated", responseContainer = "List", response =
//                    Searches.class),
//            @ApiResponse(code = 404, message = "Searches Not Found", response = ErrorDetail.class)})
//    @PutMapping(value = "/searches/{id}")
//    public ResponseEntity<?> updateSearches(HttpServletRequest request,
//                                        @RequestBody
//                                                Searches updateSearches,
//                                        @PathVariable
//                                                long id)
//    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");
//
//        searchesService.update(updateSearches, id, request.isSearchesInRole("ADMIN"));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    //    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "Delete searches by ID.", response = Searches.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Searches Deleted", responseContainer = "List", response =
                    Searches.class),
            @ApiResponse(code = 404, message = "Searches Not Found", response = ErrorDetail.class)})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSearchesById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        searchesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
