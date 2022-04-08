package com.example.cgexamples.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.cgexamples.model.User
import com.example.cgexamples.repo.UserRepository
import org.springframework.stereotype.Component

@Component
class QueryResolver(private val userRepository: UserRepository)
    : GraphQLQueryResolver{

        fun getAllUser():List<User>{
            return userRepository.findAll()
        }
}