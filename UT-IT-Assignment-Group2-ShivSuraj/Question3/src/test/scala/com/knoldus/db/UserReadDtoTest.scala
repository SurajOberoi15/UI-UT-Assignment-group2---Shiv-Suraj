package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class UserReadDtoTest extends  AnyFlatSpec
{
  "User" should "exist" in{
    val userReadDto = new userReadDto
    val result = userReadDto.getUserByName("Knoldus")
    assert(!result.isEmpty)
  }

  "User" should "not exist" in{
    val userReadDto = new userReadDto
    val result = userReadDto.getUserByName("Adobe")
    assert(result.isEmpty)
  }
}
