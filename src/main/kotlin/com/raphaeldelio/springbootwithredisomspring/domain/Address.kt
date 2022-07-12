package com.raphaeldelio.springbootwithredisomspring.domain

import com.redis.om.spring.annotations.Indexed
import com.redis.om.spring.annotations.Searchable

data class Address(
    @Indexed
    private val houseNumber: String? = null,

    @Searchable(nostem = true)
    private val street: String? = null,

    @Indexed
    private val city: String? = null,

    @Indexed
    private val state: String? = null,

    @Indexed
    private val postalCode: String? = null,

    @Indexed
    private val country: String? = null
)