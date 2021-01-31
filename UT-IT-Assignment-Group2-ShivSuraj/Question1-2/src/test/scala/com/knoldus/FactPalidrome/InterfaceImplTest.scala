package com.knoldus.FactPalidrome

import org.scalatest.flatspec.AnyFlatSpec


class InterfaceImplTest extends AnyFlatSpec
{
  /*Palindrome Test Cases*/
  "Number" should "be palindrome" in {
    val palindrome_obj = new InterfaceImpl()
    assert(palindrome_obj.palindrome(num = 1331))
  }
  "Number" should "be palindrome number" in {
    val palindrome_obj = new InterfaceImpl()
    assert(!palindrome_obj.palindrome(num = 10))
  }
  "Number" should "not be Negative" in {
    val palindrome_obj = new InterfaceImpl()
    assert(!palindrome_obj.palindrome(num = -1))
  }

  /*Factorial Test Cases*/
  "Factorial" should "be valid " in {
    val fact_obj = new InterfaceImpl()
    assert(fact_obj.factorial(6)===720)
  }
  "Fact" should "be invalid " in {
    val fact_obj = new InterfaceImpl()
    assert(!(fact_obj.factorial(2)===72))
  }
  "Number" should "be invalid if number is zero " in {
    val fact_obj = new InterfaceImpl()
    assert(fact_obj.factorial(0)===1)
  }
}
