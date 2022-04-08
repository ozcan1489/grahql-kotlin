package com.example.cgexamples.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.cgexamples.dto.LoginDTO
import com.example.cgexamples.dto.Message
import com.example.cgexamples.dto.RegisterDTO
import com.example.cgexamples.model.User
import com.example.cgexamples.repo.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component


@Component
class Resolver (private val userRepository: UserRepository) : GraphQLMutationResolver {

    fun login(body: LoginDTO) : Message {
        val user = this.userRepository.findByEmail(body.email)
            ?: return Message("User Not Found!")

        if(!user.comparePassword(body.password)){
            return Message("Invalid password")
        }

        return Message("success")
    }

    fun register(body: RegisterDTO) : User {
        val user = User()
        user.firstName = body.firstName
        user.lastName = body.lastName
        user.email = body.email
        user.password = body.password

        return this.userRepository.save(user)
    }
}