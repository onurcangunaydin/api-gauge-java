User API Spec
=====================

Create User Hapy Path
----------------
* Create Body
* Add to body "firstName" : "Jon"
* Add to body "lastName" : "Less"
* Add to body "userName" : "jondo"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "200"
* Print out body
* Assert response matches post create user model


Create User Negative Special Characters
----------------
* Create Body
* Add to body "firstName" : "***"
* Add to body "lastName" : "!!!==)"
* Add to body "userName" : "***"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "400"


Create User Negative Blank Space
----------------
* Create Body
* Add to body "firstName" : " "
* Add to body "lastName" : " "
* Add to body "userName" : "lest"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "400"
* Assert response matches post create user model


Create User Negative Special Characters 2
----------------
* Create Body
* Add to body "firstName" : "!!!!"
* Add to body "lastName" : "?=?="
* Add to body "userName" : "lest"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "400"
* Assert response matches post create user model


Create User Restriction 1
----------------
* Create Body
* Add to body "firstName" : "l"
* Add to body "lastName" : "dfhertyhkghtrefghbnmtr4rfgk5tgbdfgykdfghtytrswerkkvfk"
* Add to body "userName" : "lest"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "400"
* Assert response matches post create user model


Create User Missing Body
----------------
* Create Body
* Add to body "userName" : "lest"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Check is response status "400"
* Print out body
* Assert response matches post create user model


Create User Restriction 2
----------------
* Create Body
* Add to body "firstName" : "l"
* Add to body "lastName" : ""
* Add to body "userName" : "lest"
* Add to body "password" : "324!??"
* Send "POST" request to "users"
* Print out body
* Check is response status "400"
* Assert response matches post create user model


Get User List Succesfuly
----------------
* Send "GET" request to "users"
* Check is response status "200"
* Assert response matches user model
* Print out body


Get User List Negative
----------------
* Send "GET" request to "usersS"
* Check is response status "404"
* Assert response matches user model
* Print out body


Get Specific User
----------------
* Send "GET" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "200"
* Assert response matches get user by id model
* Print out body

Get Specific User-Negative
----------------
* Send "GET" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180343"
* Check is response status "404"


Delete User
----------------
* Send "DELETE" request to "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "200"

Delete User-Negative
----------------
* Send "DELETE" request to "/users/c4f6c088-f91b-494e-b7f0f48df3180"
* Check is response status "404"


Switch User Activity
----------------
* Create Body
* Add to body "isActive" : "true"
* Send "PATCH" request to "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity"
* Check is response status "200"
* Assert response matches patch switch user activity model
* Print out body

Switch User Activity-Negative
----------------
* Create Body
* Add to body "isActive" : ""
* Send "PATCH" request to "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity"
* Check is response status "400"
* Assert response matches patch switch user activity model
* Print out body

Switch User Activity-Negative-Null
----------------
* Create Body
* Add to body "isActive" : "null"
* Send "PATCH" request to "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity"
* Check is response status "400"
* Print out body

Switch User Activity-Negative-Blank
----------------
* Create Body
* Add to body "" : ""
* Send "PATCH" request to "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity"
* Print out body
* Check is response status "400"


Update User Info PUT
----------------
* Create Body
* Add to body "firstName" : "jane"
* Add to body "lastName" : "doe"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "200"
* Assert response matches put update user model
* Print out body

Update User Info Negative-restriction #1
----------------
* Create Body
* Add to body "firstName" : "k"
* Add to body "lastName" : "k"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"

Update User Info Negative-restriction #2
----------------
* Create Body
* Add to body "firstName" : ""
* Add to body "lastName" : "kert"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"


Update User Info Negative-restriction #3
----------------
* Create Body
* Add to body "firstName" : "leth"
* Add to body "lastName" : "1"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"

Update User Info Negative-restriction #4
----------------
* Create Body
* Add to body "firstName" : "leth"
* Add to body "lastName" : "exampletersexampletersexampletersexampleters"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"

Update User Info Negative-blank
----------------
* Create Body
* Add to body "firstName" : ""
* Add to body "lastName" : ""
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"

Update User Info Special-Characters
----------------
* Create Body
* Add to body "firstName" : "!!LE"
* Add to body "lastName" : "???''3"
* Send "PUT" request to "users/c4f6c088-f91b-494e-b7f0-a08f48df3180"
* Check is response status "400"


Update User Info Negative-Not-Found
----------------
* Create Body
* Add to body "firstName" : ""
* Add to body "lastName" : ""
* Send "PUT" request to "users/c4f6c088-f9-494e-b7f0-a08f48df"
* Check is response status "404"