package com.example.cgexamples

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication (exclude = [SecurityAutoConfiguration::class])
class CgExamplesApplication

fun main(args: Array<String>) {
    runApplication<CgExamplesApplication>(*args)
}
