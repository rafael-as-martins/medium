# Micro Service Central Configuration Repository

This repository has two modules, one client, that will read the configuration properties retrieved from the configuration repository, and the configuration repository itself;

The configuration repository is currently using file system storage approach only for the sake of the example simplicity, you should avoid using it in a cloud environemnt due the management constraints;

Commands:

 1. java -jar <ms-repository-project-location>/target/configuration-0.0.1-SNAPSHOT.jar
 2. java -jar <client1-project-location>target/client1-0.0.1-SNAPSHOT.jar
 3. Create a GET request for: http://127.0.0.1:8080/client/1
  
  
  If you get tha json sample, that means the configurations were read sucessfully.
  
  Note: The client should start up only when the configuration is up and runnig!



