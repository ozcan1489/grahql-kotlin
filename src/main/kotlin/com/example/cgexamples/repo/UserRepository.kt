package com.example.cgexamples.repo

import com.example.cgexamples.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>{

    fun findByEmail (email: String) : User?
}