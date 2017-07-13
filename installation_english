## Installation
1. Install the Jetbreans Intellij IDEA 2017.x
2. Install MySQL 5.7
3. Clone the repository using GIT or by pressing the Clone button in the github GUI
4. Create a new MySQL connection
5. Create a new database and name it mockupcitytours
6. Open the project in Intellji
7. Add a Credentials.java file to src/database and paste in the following lines and replace the <..> fields with your MySQL connection credentials.
  package database;
  public class Credentials {
      public static String getPwd(){
          return <your password>;
      }
      public static String getUser(){
          return <your user identity>;
      }
  }
8. Within the same directory navigate to Repository.java and on line 17 change the connection string to your MySQL connection string
9. Add the MySQL database connection to your project (navigate to View -> Tool Windows -> Database)
10. Navigate to the root folder and execeute DbSchemaGen.sql on the database you just added.
11. Create a user with the name "admin" which will grant you the rights to access the administrator view within the application (SQL Statement Example: "INSERT INTO users (name, pwd, email) VALUES ('admin', <your password>, <your email>);")
12. Install the following dependencies. The Gson and mysql-connector libraries
13. Start the application.
14. Login using the admin user.
15. Open Help -> Administrator and start adding the required content.
