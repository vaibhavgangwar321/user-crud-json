# user-crud-json

This is a simple Spring Boot REST API for managing users with basic CRUD operations. 


1. Features :

     . Add a new user

     . List all users

     . Get user by ID

     . Update a user

     . Delete a user

     . Optional JSON file persistence to save users


2. Prerequisites :

     * Before running the server, ensure you have the following installed :

       . Java 17 or higher
       . Maven (build tool)
       . Optional: IDE like IntelliJ IDEA or VS Code for development.


3. Setup & Running the Server :

     step 1 : clone the repository
     step 2 : build the project
     step 3 : start the server

        The server will run at: http://localhost:8080


4. API Usage :

    4.1 Add User
   
      . Method: POST
      . URL: /users/add
      . Request Body Example:
            {
              "name": "vaibhav",
              "email": "vaibhav@example.com"
            }
   
      . Response: User object with auto-generated id.


   4.2 Get All Users

      . Method: GET
      . URL: /users/get
      . Response: List of all users.


   4.3 Get User by ID

      . Method: GET
      . URL: /users/get-{id}
      . Example: /users/get-1
      . Request Body Example:
             {
              "name": "vaibhav",
              "email": "vaibhav@example.com"
            }
   
      . Response: User object if exists, otherwise 404 Not Found.


   4.4 Update User

      . Method: PUT
      . URL: /users/update-{id}
      . Example: /users/update-1
      . Request Body Example :
               {
                 "name": "vaibhav",
                 "email": "vaibhav11@example.com"
               }

      . Response: Updated user if exists, otherwise 404 Not Found.


   4.5 Delete User

      . Method: DELETE
      . URL: /users/delete - {id}
      . Example: /users/delete-1
      . Response: 204 No Content if deleted, otherwise 404 Not Found.
   
       





     
   

          



   
   
