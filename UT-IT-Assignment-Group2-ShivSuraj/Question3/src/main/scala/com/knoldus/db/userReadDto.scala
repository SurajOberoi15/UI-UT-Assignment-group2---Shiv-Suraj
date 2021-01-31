package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class userReadDto
{
  val knoldusUser : User = User("Suraj", "Oberoi", 3, 5000, "Software Engineer" ,"Knoldus", "shiv.oberoi@knoldus.com")
  val philipsUser: User = User("Sachin","Bhutani" , 2, 5100, "Software Engineer", "Philips", "sachin.bhutani@philips.com")
  val Users: HashMap[String, User] = HashMap("Knoldus" -> knoldusUser, "Philips" -> philipsUser)

  def getUserByName(name: String): Option[User] = Users.get(name)
}
