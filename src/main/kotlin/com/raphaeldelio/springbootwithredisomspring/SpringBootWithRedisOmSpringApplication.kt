package com.raphaeldelio.springbootwithredisomspring

import com.raphaeldelio.springbootwithredisomspring.domain.Address
import com.raphaeldelio.springbootwithredisomspring.domain.Person
import com.raphaeldelio.springbootwithredisomspring.domain.repositories.PeopleRepository
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.geo.Point
import org.springframework.util.StopWatch

@EnableRedisDocumentRepositories(basePackages = ["com.raphaeldelio.*"])
@SpringBootApplication
class SpringBootWithRedisOmSpringApplication {
    @Bean
    fun loadDataTest(repo: PeopleRepository): CommandLineRunner {
        return CommandLineRunner  {
            repo.deleteAll()

            val thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You."

            // Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
            val thorsAddress = Address(
                "248",
                "Seven Mile Beach Rd",
                "Broken Head",
                "NSW",
                "2481",
                "Australia"
            )

            val thor = Person(
                firstName = "Chris",
                lastName = "Hemsworth",
                age = 38,
                personalStatement = thorSays,
                homeLoc = Point(153.616667, -28.716667),
                address = thorsAddress,
                skills = setOf("hammer", "biceps", "hair", "heart")
            )

            val stopWatch = StopWatch()
            stopWatch.start("Inserting")
            for(i in 0 until 10000) {
                repo.save(thor)
            }
            stopWatch.stop()
            println("Inserting: ${stopWatch.totalTimeMillis}")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootWithRedisOmSpringApplication>(*args)
}
