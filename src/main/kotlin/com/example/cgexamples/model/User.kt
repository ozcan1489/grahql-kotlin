package com.example.cgexamples.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Document
class User {

    @Id
    var id: ObjectId = ObjectId.get()
    @Field
    var firstName =""
    @Field
    var lastName = ""
    @Field
    var email =""
    var password = ""
        @JsonIgnore
        get() = field
        set(value) {
            field = BCryptPasswordEncoder().encode(value)
        }

    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }

}