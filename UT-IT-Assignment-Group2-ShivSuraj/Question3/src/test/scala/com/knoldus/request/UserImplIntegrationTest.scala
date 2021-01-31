package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val UserImpl = new UserImpl(userValidator)

  "User" should "be valid" in {
    val shivUser : User = User("shiv", "oberoi", 23, 15000, "Software Engineer" ,"Knoldus", "shiv.oberoi@knoldus.com")
    val result =  UserImpl.createUser(shivUser)
    assert(!result.isEmpty)
}

  "User" should "be invalid as it company does not exists in DB" in {
    val shivUser : User = User("shiv", "oberoi", 23, 15100, "Software Engineer" ,"IZSpider", "shiv.oberoi04@gmail.com")
    val result =  UserImpl.createUser(shivUser)
    assert(result.isEmpty)
}

  "User" should "be invalid as email id is invalid" in {
    val SachinUser : User = User("Sachin", "bhutani", 24, 5000000, "Software Enginner" ,"Knoldus", "Sachin..bhutani...knoldus.com")
    val result = UserImpl.createUser(SachinUser)
    assert(result.isEmpty)
}

  "User" should "be invalid as email id is invalid and company does not exists in DB" in {
    val SachinUser : User = User("Sachin", "bhutani", 24, 5000000, "Software Enginner" ,"VIVO", "Sachinknoldus.xyz")
    val result =  UserImpl.createUser(SachinUser)
    assert(result.isEmpty)
}
}