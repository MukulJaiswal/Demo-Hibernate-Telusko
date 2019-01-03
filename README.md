# Demo-Hibernate-Telusko
Youtube telusko hibernate learning...

# For Error "com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException"
## Solution
First Replace the MySQL dependency as given below

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.44</version>
</dependency>

# An error showing "Authentication plugin 'caching_sha2_password'" will appear. Run this command:
Run below command in mysql shell.

ALTER USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
