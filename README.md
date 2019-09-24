# BackEnd

College Earnings
Documentation for College Earnings Back End
More information: http://www.github.com/gcj2
Contact Info: GCJohnston91@gmail.com
Version: 1.0.0
BasePath:/
MIT
https://github.com/LambdaSchool/java-starthere/blob/master/LICENSE
Access
Methods
[ Jump to Models ]
Table of Contents
ApIsController
GET /otherapis/openlibrary/{isbn}
LogoutController
GET /oauth/revoke-token
OpenController
POST /createnewuser
GET /favicon.ico
RolesController
POST /roles/role
DELETE /roles/role/{id}
GET /roles/role/{roleId}
GET /roles/role/name/{roleName}
GET /roles/roles
UserController
POST /users/user
DELETE /users/user/{id}
GET /users/getusername
GET /users/user/{userId}
GET /users/user/name/{userName}
GET /users/users
POST /users/user/{userid}/role/{roleid}
PUT /users/user/{id}
UseremailController
POST /useremails/useremail
DELETE /useremails/useremail/{useremailid}
GET /useremails/username/{userName}
GET /useremails/useremail/{useremailId}
GET /useremails/useremails
ApIsController
Up
GET /otherapis/openlibrary/{isbn}
listABookGivenISBN (listABookGivenISBNUsingGET)
Path parameters
isbn (required)
Path Parameter — isbn
Return type
Object
Example data
Content-Type: application/json
"{}"
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK Object
LogoutController
Up
GET /oauth/revoke-token
Logs user out by deleting token. (logoutUsingGET)
Return type
array[User]
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
User Logged Out
404
User Could Not Be Logged Out ErrorDetail
OpenController
Up
POST /createnewuser
Create a new user. (addNewUserUsingPOST)
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Request body
newuser User (required)
Body Parameter — newuser
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
User Created
404
User could not be created ErrorDetail
Up
GET /favicon.ico
returnNoFavicon (returnNoFaviconUsingGET)
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK
RolesController
Up
POST /roles/role
addNewRole (addNewRoleUsingPOST)
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Request body
newRole Role (required)
Body Parameter — newRole
Return type
Object
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK Object
Up
DELETE /roles/role/{id}
deleteRoleById (deleteRoleByIdUsingDELETE)
Path parameters
id (required)
Path Parameter — id format: int64
Return type
Object
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK Object
Up
GET /roles/role/{roleId}
getRoleById (getRoleByIdUsingGET)
Path parameters
roleId (required)
Path Parameter — roleId format: int64
Return type
Object
Example data
Content-Type: application/json
"{}"
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK Object
Up
GET /roles/role/name/{roleName}
getRoleByName (getRoleByNameUsingGET)
Path parameters
roleName (required)
Path Parameter — roleName
Return type
Object
Example data
Content-Type: application/json
"{}"
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK Object
Up
GET /roles/roles
listRoles (listRolesUsingGET)
Return type
Object
Example data
Content-Type: application/json
"{}"
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK Object
UserController
Up
POST /users/user
Add new user. (addNewUserUsingPOST1)
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Request body
newuser User (required)
Body Parameter — newuser
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
User Created
404
User could not be created ErrorDetail
Up
DELETE /users/user/{id}
Delete user by ID. (deleteUserByIdUsingDELETE)
Path parameters
id (required)
Path Parameter — id format: int64
Return type
array[User]
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
User Deleted
404
User Not Found ErrorDetail
Up
GET /users/getusername
Get current user name. (getCurrentUserNameUsingGET)
Query parameters
authenticated (optional)
Query Parameter —
authorities[0].authority (optional)
Query Parameter —
credentials (optional)
Query Parameter —
details (optional)
Query Parameter —
principal (optional)
Query Parameter —
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
Username Found
404
Username Not Found ErrorDetail
Up
GET /users/user/{userId}
Get user by ID. (getUserByIdUsingGET)
Path parameters
userId (required)
Path Parameter — userId format: int64
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
User(s) Found
404
User Not Found ErrorDetail
Up
GET /users/user/name/{userName}
Get user by name. (getUserByNameUsingGET)
Path parameters
userName (required)
Path Parameter — userName
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
User Found
404
User Not Found ErrorDetail
Up
GET /users/users
returns all users (listAllUsersUsingGET)
Query parameters
page (optional)
Query Parameter — Results page you want to retrieve (0..N)
size (optional)
Query Parameter — Number of records per page.
sort (optional)
Query Parameter — Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK
Up
POST /users/user/{userid}/role/{roleid}
postUserRoleByIds (postUserRoleByIdsUsingPOST)
Path parameters
roleid (required)
Path Parameter — roleid format: int64
userid (required)
Path Parameter — userid format: int64
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Return type
Object
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK Object
Up
PUT /users/user/{id}
Update user by ID. (updateUserUsingPUT)
Path parameters
id (required)
Path Parameter — id format: int64
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Request body
updateUser User (required)
Body Parameter — updateUser
Return type
array[User]
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
User Updated
404
User Not Found ErrorDetail
UseremailController
Up
POST /useremails/useremail
addNewQuote (addNewQuoteUsingPOST)
Consumes
This API call consumes the following media types via the Content-Type request header:
application/json
Request body
newUseremail Useremail (required)
Body Parameter — newUseremail
Return type
Object
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK Object
Up
DELETE /useremails/useremail/{useremailid}
deleteQuoteById (deleteQuoteByIdUsingDELETE)
Path parameters
useremailid (required)
Path Parameter — useremailid format: int64
Return type
Object
Example data
Content-Type:
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
*/*
Responses
200
OK Object
Up
GET /useremails/username/{userName}
findQuoteByUserName (findQuoteByUserNameUsingGET)
Path parameters
userName (required)
Path Parameter — userName
Return type
Object
Example data
Content-Type: application/json
"{}"
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK Object
Up
GET /useremails/useremail/{useremailId}
Get user email by ID. (getUserEmailByIdUsingGET)
Path parameters
useremailId (required)
Path Parameter — useremailId format: int64
Return type
array[User]
Example data
Content-Type: application/json
[ {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
}, {
  "savedSearches" : [ {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  }, {
    "collegename" : "collegename",
    "earnings" : "earnings",
    "searchid" : 0,
    "city" : "city",
    "degree" : "degree",
    "state" : "state"
  } ],
  "useremails" : [ {
    "useremailid" : 6,
    "useremail" : "useremail"
  }, {
    "useremailid" : 6,
    "useremail" : "useremail"
  } ],
  "password" : "password",
  "userroles" : [ {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  }, {
    "role" : {
      "userroles" : [ null, null ],
      "roleid" : 5,
      "name" : "name"
    }
  } ],
  "authority" : [ {
    "authority" : "authority"
  }, {
    "authority" : "authority"
  } ],
  "userid" : 1,
  "passwordNoEncrypt" : "passwordNoEncrypt",
  "username" : "username"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
User(s) Found
404
User Not Found ErrorDetail
Up
GET /useremails/useremails
returns all user emails (listAllUseremailsUsingGET)
Query parameters
page (optional)
Query Parameter — Results page you want to retrieve (0..N)
size (optional)
Query Parameter — Number of records per page.
sort (optional)
Query Parameter — Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
Return type
array[Useremail]
Example data
Content-Type: application/json
[ {
  "useremailid" : 6,
  "useremail" : "useremail"
}, {
  "useremailid" : 6,
  "useremail" : "useremail"
} ]
Produces
This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
application/json
Responses
200
OK
Models
[ Jump to Methods ]
Table of Contents
ErrorDetail - ErrorDetail
Role - Role
Searches - Searches
SimpleGrantedAuthority - SimpleGrantedAuthority
User - User
UserRoles - UserRoles
Useremail - Useremail
ValidationError - ValidationError
ErrorDetail - ErrorDetailUp
detail (optional)
String
developerMessage (optional)
String
errors (optional)
map[String, array[ValidationError]]
status (optional)
Integer format: int32
timestamp (optional)
String
title (optional)
String
Role - RoleUp
name (optional)
String
roleid (optional)
Long format: int64
userroles (optional)
array[UserRoles]
Searches - SearchesUp
city (optional)
String
collegename (optional)
String
degree (optional)
String
earnings (optional)
String
searchid (optional)
Long format: int64
state (optional)
String
user (optional)
User
SimpleGrantedAuthority - SimpleGrantedAuthorityUp
authority (optional)
String
User - UserUp
authority (optional)
array[SimpleGrantedAuthority]
password (optional)
String
passwordNoEncrypt (optional)
String
savedSearches (optional)
array[Searches]
useremails (optional)
array[Useremail]
userid (optional)
Long format: int64
username (optional)
String
userroles (optional)
array[UserRoles]
UserRoles - UserRolesUp
role (optional)
Role
user (optional)
User
Useremail - UseremailUp
user (optional)
User
useremail (optional)
String
useremailid (optional)
Long format: int64
ValidationError - ValidationErrorUp
code (optional)
String
message (optional)
String
