package com.kw

@Entity(tableName = 'name_table', primaryKeys = ["username", "pin"])
data class PersonData (
   val username: String,
   val pin: String
   )