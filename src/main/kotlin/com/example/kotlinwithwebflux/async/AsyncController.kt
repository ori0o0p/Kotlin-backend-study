package com.example.kotlinwithwebflux.async

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping("/async")
class AsyncController {

    @GetMapping("/task")
    fun getAsyncTask() : Mono<String> = Mono.just("*^^*")
        .delayElement(Duration.ofSeconds(3))

    @GetMapping("/tasks")
    fun getAsyncTasks() : Flux<String> = Flux.just("1 ", "2 ", "3 ", "4 ")
        .delayElements(Duration.ofSeconds(2))

}