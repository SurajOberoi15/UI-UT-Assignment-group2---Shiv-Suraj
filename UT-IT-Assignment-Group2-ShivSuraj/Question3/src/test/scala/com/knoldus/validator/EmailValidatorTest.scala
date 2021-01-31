package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{
  val emailValidator = new EmailValidator()

  "Email" should "be valid" in {
    val result : Boolean = emailValidator.emailIdIsValid("shivoberoi04@gmail.com")
    assert(result==true)
  }

  "Email" should "be invalid because @ does not exist " in {
    val result : Boolean = emailValidator.emailIdIsValid("shivoberoi04gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because it cannot contain space/tabs" in {
    val result : Boolean = emailValidator.emailIdIsValid("shivoberoi  @gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because of invalid top domain" in {
    val result : Boolean = emailValidator.emailIdIsValid("shivoberoi@gmail.xyzy")
    assert(result==false)
  }

  "Email" should "be invalid because email cannot start from any special symbol" in {
    val result : Boolean = emailValidator.emailIdIsValid("-gmail.com")
    assert(result==false)
  }

}
