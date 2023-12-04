package com.example.kotlinwithwebflux.reactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/reactive")
class ReactiveController {

    @GetMapping("/flux")
    fun getHelloFlux () : Flux<String> {
        return Flux.just("Hello", "Kotlin", "WebFlux!")
    }

    @GetMapping("/mono")
    fun getHelloMono () : Mono<String> {
        return Flux.just("Hello", "Kotlin", "WebFlux!")
            //.next() // 플럭스의 맨 앞의 값을 모노로 변환하여 반환
            //.last() // 플럭스의 맨 뒤의 값을 모노로 변환하여 반환
            .collectList()
            .map { it.joinToString(" ") }
    }

    @GetMapping("/filter")
    fun getFilteredFlux() : Flux<String> {
        return Flux.just("Hello", "Kotlin", "WebFlux!")
            .filter { it.startsWith("H") }
    }

}