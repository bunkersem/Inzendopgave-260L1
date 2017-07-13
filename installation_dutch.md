## Installatie
1. Installeer de Jetbreans Intellij IDEA 2017.x
2. Installeer MySQL 5.7
3. Kloon de repository met GIT of klik de kloon knop via de github GUI
4. Maak een nieuwe MySQL connection
5. Maak een nieuwe database en noem het mockupcitytours
6. Open het project in Intellji
7. Maak een bestand genoemd Credentials.java file in src/database en vervang de volgende <..> velden met de MySQL connection credentials.
  package database;
  public class Credentials {
      public static String getPwd(){
          return <your password>;
      }
      public static String getUser(){
          return <your user identity>;
      }
  }
8. In dezelfde folder, open Repository.java en op lijn 17 vervang de connection string naar de MySQL connection string
9. Voeg de nieuwe MySQL database connection toe aan je project (navigeer naar View -> Tool Windows -> Database)
10. Navigeer naar de basis folder en voer de instructies in DbSchemaGen.sql uit op de database die je zojuist hebt toegevoegd.
11. Maak een nieuwe gebruiker met de naam "admin" zodat je veranderingen kan maken in de applicatie (SQL verklaring voorbeeld: "INSERT INTO users (name, pwd, email) VALUES ('admin', <your password>, <your email>);")
12. Installeer de volgende afhankelijkheden. The Gson and mysql-connector bibliotheken
13. Start de application.
14. Login met de admin user.
15. Open Help -> Administrator en begin met het toevoegen van inhoud.
