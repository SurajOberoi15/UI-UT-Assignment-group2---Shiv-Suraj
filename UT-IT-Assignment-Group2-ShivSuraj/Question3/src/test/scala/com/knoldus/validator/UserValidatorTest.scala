package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}


class UserValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {

  val SachinUser: User = User("Sachin", "Bhutani", 34, 50000000, "WK" ,"TTN", "sachin.bhutani@gmail.com")
  val adminCompany: Company = Company("admin", "admin@gmail.com", "Mumbai")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "User" should "be a valid user because user does not exit in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(SachinUser.companyName)) thenReturn (Option(adminCompany))
    when(mockedEmail.emailIdIsValid(SachinUser.emailId)) thenReturn(true)

    val userValidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = userValidator.userIsValid(SachinUser)
    assert(result)

  }

  "User" should "be a invalid because email is not valid" in{

    when(mockedCompanyReadDto.getCompanyByName(SachinUser.companyName)) thenReturn (Option(adminCompany))
    when(mockedEmail.emailIdIsValid(SachinUser.emailId)) thenReturn(false)

    val userValidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = userValidator.userIsValid(SachinUser)
    assert(!result)

  }

  "User" should "be a invalid because company does exist in the DB" in{

    when(mockedCompanyReadDto.getCompanyByName(SachinUser.companyName)) thenReturn (None)
    when(mockedEmail.emailIdIsValid(SachinUser.emailId)) thenReturn(true)

    val userValidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = userValidator.userIsValid(SachinUser)
    assert(!result)

  }



}
