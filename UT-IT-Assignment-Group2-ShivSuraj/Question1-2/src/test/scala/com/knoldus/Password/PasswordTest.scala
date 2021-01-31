package com.knoldus.Password

import org.scalatest.flatspec.AnyFlatSpec

class PasswordTest extends AnyFlatSpec
{
  "Password" should "be in  this format" in
    {
    val password = new PasswordImpl("shivSuraj@123")
    assert(password.isValidPassword)
    }
  "Password" should "contain at least one Uppercase Character" in
    {
    val password = new PasswordImpl("shivsuraj@123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one Lowercase Character" in
    {
    val password= new PasswordImpl("SHIVSURAJ@123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one number" in
    {
    val password= new PasswordImpl("shivSuraj@")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one Special Character" in
    {
    val password= new PasswordImpl("shivSuraj123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain minimum 8 Characters" in
    {
    val password= new PasswordImpl("SS@123")
    assert(!password.isValidPassword)
    }
  "Password" should "be less than 15 Characters" in
    {
    val password= new PasswordImpl("shivSuraj@123456")
    assert(!password.isValidPassword)
    }
  "Password" should "not contain any spaces" in
    {
    val password= new PasswordImpl("Shiv Suraj @ 123")
    assert(!password.isValidPassword)
   }
}


