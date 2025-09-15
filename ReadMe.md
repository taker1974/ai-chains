# ai-chains

## About the application

An application for building chains of requests to external AIs and other tools.  
Search, CRUD.  
Java, Spring Boot.

## Technologies used

Java 21, openjdk,
Spring Boot 3.4.*, Lombok, Jakarta Validation, Jackson, Spring Security,  
Liquibase, PostgreSQL, JPQL, SQL,  
[Caffeine], Redis,  
Mockito, JUnit, Testcontainers, Docker, Docker Compose,  
JavaDoc, Swagger,
Fedora Linux 42, VS Code,
DeepSeek, Cursor, GigaCode, Yandex GPT,
Git/gitlab/github projects, kanban.

For a more detailed description, see [ai-chains/ReadMe.md](https://github.com/taker1974/ai-chains/blob/main/ai-chains/ReadMe.md)

## Preparing for deployment on a host

**Required software**:

- PostgreSQL >= 15;
- Java >= 21.

Software versions may differ. Development uses Postgres 17 and Java 21.  
There are no explicit restrictions on using other versions.

**Postgres**:

- check `application.yml` first;
- create the `ai_chains` database, create user "ai_chains_god" with password "87654321", and assign ownership of `ai_chains` to user `ai_chains_god`:

```Bash
$ sudo -u postgres psql
postgres=# CREATE DATABASE ai_chains;
CREATE DATABASE
postgres=# CREATE USER ai_chains_god WITH LOGIN PASSWORD '87654321';
CREATE ROLE
postgres=# ALTER DATABASE ai_chains OWNER TO ai_chains_god;
ALTER DATABASE
```

**For real-world use or further redistribution, logins and passwords must be hidden: at minimum, pass them via command-line parameters when starting the application.**

**Java**:

- install JDK or JRE version 21 or higher (development is on version 24; there are no explicit restrictions on using other Java versions);
- ensure the installation is correct and `java`, `javac`, `maven (mvn)` are available;
- **important** set `JAVA_HOME` (for example, in `~/.bashrc`):

```Bash
$export JAVA_HOME=/usr/lib/jvm/java-24-openjdk
```

If you encounter issues with openjdk-24, you can roll back to openjdk-21: simply replace version 24 with 21 in all `pom.xml` files.

## Running the application

See `pom.xml`. In the project root:

```Bash
$mvn clean install
$java -jar target/ai-chains-<your.app.version>.jar
```

See `application.yml`, `context-path`.  

In a browser:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Documentation

### Swagger -> HTML

`redoc-cli` was moved into `@redocly/cli`.  
You can use `npx` without installation:

```bash
npx @redocly/cli build-docs <путь-к-openapi-файлу>
```

Generating static HTML from Swagger, using the main application `tk-classified-ads-platform` as an example:

```Bash
curl http://localhost:<порт>/api-docs -o ai-chains-api-spec.json
npx @redocly/cli build-docs ai-chains-api-spec.json -o ai-chains-swagger.html 
```

### JavaDoc -> HTML

```Bash
mvn compile javadoc:javadoc
```

## Other

### Checking dependency versions

Add the plugin to `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>versions-maven-plugin</artifactId>
            <version>2.16.2</version>
        </plugin>
    </plugins>
</build>
```

Run the check:

```bash
mvn versions:display-dependency-updates
```

The _versions-maven-plugin_ allows updating versions in `pom.xml` automatically:

```bash
mvn versions:use-latest-versions
```

After execution, review the changes in `pom.xml`.

**Limitations**
SNAPSHOT versions: The _versions-maven-plugin_ ignores them by default.  
Use the `-DallowSnapshots=true` flag to include them.

Custom repositories: If an artifact is hosted outside Maven Central, ensure the  
repository is added to `pom.xml`/`settings.xml`.
