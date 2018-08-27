http://www.in28minutes.com/course-guides/SpringMasterClass-CourseGuidev0.1.pdf
https://github.com/in28minutes/spring-master-class

http://www.springboottutorial.com/hibernate-jpa-tutorial-with-spring-boot-starter-jpa
WEB, H2, Devtools, JPA

http://localhost:8080/h2-console

//########################################################################################################################## 

MAVEN COMMAND SUIT

"validate"
    validate the project is correct and all necessary information is available
"compile"
    compile the source code of the project
"test"
    test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
"package"
    take the compiled code and packag it in its distributable format, such as a JAR.
"integration-test"
    process and deploy the packag if necessary into an environment where integration tests can be run
"verify"
    run any checks to verify the packag is valid and meets quality criteria
"install"
    install the packag into the local repository, for use as a dependency in other projects locally
"deploy"
    done in an integration or release environment, copies the final packag to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

"clean": cleans up artifacts created by prior builds
"site": generates site documentation for this project

//########################################################################################################################## 

* Spring = dependency injection + loosely coupling
* wiring = classes dependentes, toda classe dependende precisa de "@Autowired" no código
    o Wiring ocorre no construtor (ou metodo setter) da classe que declara o Autowiring
* bean = jeito do spring gerenciar objetos dependentes atualmente utilizados "@Component"
    você só pode ter um bean ativo por vez [com @Component] ou ter mais de um com @Primary pro atual
* p/ rodar o bean do Application Context
    ApplicationContext applicationContext = SpringApplication.run(SpringBinarySearchTest.class, args);
    BinarySearchImpl binarySearch = applicationContext.getBeans(BinarySearch.class);
    int result = binarySearch.binarySearch(new int[] {12,4,6}, 3);

data.sql = sempre executa ao iniciar

ORM - Hibernate (object relational mapping)
JMS - Message System (Spark - Kafka?)
JDBC

AOP - Aspect Oriented Programming