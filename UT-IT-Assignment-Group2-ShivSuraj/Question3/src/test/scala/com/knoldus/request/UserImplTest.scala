package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImplTest extends org.scalatest.flatspec.AnyFlatSpec{
  val mockedUserValidate = mock[UserValidator]
  val surajUser : User = User("suraj", "oberoi", 23, 15000, "Software Engineer" ,"Knoldus", "suraj.oberoi@knoldus.com")
  val sachinUser : User = User("sachin", "bhutani", 23, 15100, "Software Engineer" ,"TTN", "sachin.bhutani@gmail.com")

  "User" should "be valid" in{
    val UserImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(surajUser)) thenReturn(true)
    val result = UserImpl.createUser((surajUser))
    assert(!result.isEmpty)
  }

  "User" should "be not be valid" in{
    val UserImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(sachinUser)) thenReturn(false)
    val result = UserImpl.createUser((sachinUser))
    assert(result.isEmpty)
  }

}
