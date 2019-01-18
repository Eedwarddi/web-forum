# web-forum

## Requirements

- MySQL 8.0.13

To run this application you need to create a file with your database information. Create a file named persistence-mysql.properties in src/main/resources

template for persistence-mysql.properties

```
#
# JDBC connection properties
#
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=
jdbc.user=
jdbc.password=

```
Insert your mysql url, username, and password.

IMPORTANT!

Insert the following line after your mysql url:

?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

otherwise mysql will give an error about the server time zone value not being recognized.

So for example:

```
jdbc.url=jdbc:mysql://localhost:3306/forumdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```
