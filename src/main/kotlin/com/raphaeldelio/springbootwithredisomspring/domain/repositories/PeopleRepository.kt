package com.raphaeldelio.springbootwithredisomspring.domain.repositories

import com.raphaeldelio.springbootwithredisomspring.domain.Person
import com.redis.om.spring.repository.RedisDocumentRepository

interface PeopleRepository : RedisDocumentRepository<Person, String>