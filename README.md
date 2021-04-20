# Text Search Engine

## Working Environment
You need to install Java 11 and Maven 3+ to run this app.

You may also have to configure your setting.xml file to access maven central
and download dependencies.

Here is an example :
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
   
  <localRepository>${user.home}/.m2/repository</localRepository>
  <interactiveMode>true</interactiveMode>
  <usePluginRegistry>false</usePluginRegistry>
  <offline>false</offline>

<proxies>
<proxy>
    <id>optional</id>
    <active>false</active>
    <protocol>http</protocol>
    <username></username>
    <password></password>
    <host>172.27.171.91</host>
    <port>8080</port>
</proxy>
</proxies>
 
  <mirrors>
    <mirror>
      <id>centralmirror</id>
      <name>Apache maven central mirror Spain</name>
      <url>http://downloads.centralmirror.com/public/maven</url>
      <mirrorOf>maven_central</mirrorOf>
    </mirror>
  </mirrors>

 
</settings>
```

## How to run this application?

You can run this application using two methods.

## Run a jar file

You can build the jar file **search-engine-1-0.-SNAPSHOT.jar** inside the target folder by running the command
*mvn package*

You can then run the following command en provide the words to process :
- java -jar [path_to_the_jar_file] [words list] : this command will log the search result
#### Exemple:
``` 
$ java -jar search-engine-1.0-SNAPSHOT.jar "denis"
search> denis
file5.txt: 100.0%
file11.txt: 100.0%
```

## Run the main class

You can also run this application by running the main class and providing an argument
in your IDE




