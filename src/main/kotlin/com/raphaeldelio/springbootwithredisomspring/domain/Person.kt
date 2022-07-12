package com.raphaeldelio.springbootwithredisomspring.domain

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;

@Document
data class Person(
    // Id Field, also indexed
    @Id
    @Indexed
    val id: String? = null,

    // Indexed for exact text matching
    @Indexed 
     val firstName: String,
    
    @Indexed 
    private val lastName: String,

    //Indexed for numeric matches
    @Indexed
    private val age: Int,
    
    //Indexed for Full Text matches
    @Searchable 
    private val personalStatement: String,
    
    //Indexed for Geo Filtering
    @Indexed 
    private val homeLoc: Point,
    
    // Nest indexed object
    @Indexed 
    private val address: Address,

    @Indexed
    private val skills: Set<String>
)
