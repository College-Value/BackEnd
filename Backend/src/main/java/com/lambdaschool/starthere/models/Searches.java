package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "searches")
public class Searches extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long searchid;

    @Column(nullable = false)
    private String collegename;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String earnings;

    @Column(nullable = false)
    private String degree;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties("searches")
    private User user;

    public Searches()
    {
    }

    public Searches(String collegename, String city, String state, String earnings, String degree, User user)
    {
        this.collegename = collegename;
        this.city = city;
        this.state = state;
        this.earnings = earnings;
        this.degree = degree;
        this.user = user;
    }

    public long getSearchid()
    {
        return searchid;
    }

    public void setSearchid(long searchid)
    {
        this.searchid = searchid;
    }

    public String getCollegename()
    {
        return collegename;
    }

    public void setCollegename(String collegename)
    {
        this.collegename = collegename;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getEarnings()
    {
        return earnings;
    }

    public void setEarnings(String earnings)
    {
        this.earnings = earnings;
    }

    public String getDegree()
    {
        return degree;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Searches{" +
                "searchid=" + searchid +
                ", collegename='" + collegename + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", earnings='" + earnings + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}