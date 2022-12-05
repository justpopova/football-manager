***Football Manager App***

This is simplified system for managing football teams and players.

**Features:**

- adding team/player
- update team/player
- get team/player by id
- get all teams from db
- get all players from db
- get all players from specific team by id
- remove team/player by id
- transfer player from one team to another

  *If player who needs to be transferred don't have team, then he automatically becomes as a part of new team.*

**The project has N-Tier Architecture:**

- Repository - all work with db(CRUD)
- Service - all business logic
- Controllers - accept request from the clients and send responses

**Technologies:**

- Java 17
- Spring Boot JPA
- Spring Boot Web
- H2 database
- Maven

**Instruction to run project:**

- Open IntelliJ IDEA and write ``git clone <SSH link>`` in console.
- Configure application.properties - set necessary parameters:

  ```spring.datasource.url=jdbc:h2:mem:football_manager_db
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  spring.jpa.hibernate.ddl-auto=create
  
  spring.jpa.properties.hibernate.format_sql=true
  spring.h2.console.enabled=true```

*by default is h2 database, but if you want to use MySQL or Postgres, will need to add necessary dependencies to pom.xml and
configure application.properties according to your username/password, change dialect, url*

- Run the project.