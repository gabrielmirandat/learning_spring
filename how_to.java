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
* wiring = classes dependentes, toda classe dependente precisa de "@Autowired" no código
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
JDBC - Java Database Connector
AOP - Aspect Oriented Programming

// P resolver o wiring
@Primary - diz qual a dependencia que deve resolver
@Qualifier("bubble") - por tag do nome

// Escopo de um bean, definido por @Scope
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("singleton") - mesmo que nada, é o padrão do Spring - cada Bean é o mesmo objeto 
@Scope("prototype") - cada Bean é um novo objeto
@Scope("request") - um Bean por chamada HTTP
@Scope("session") - um Bean por sessão HTTP

// Fazer Spring procurar Beans em um package diferente do ApplicationContext
@ComponentScan("package...")

// Bean lifecycle
@postConstruct - função que será executada logo após a criação do Bean
@PreDestroy - função executada antes de destruir um Bean

// CDI - Context and Dependency Injection
// define padrões para as anotations de injeção de dependencia
@Inject (@Autowired)
@Named (@Component)
@Singleton (define scopo de singleton)

// Termos
IOC Container - prove a inversão de controle
Application Context
Bean Factory - tipo ApplicationContext só com menos coisa, mas tem Spring AOP, WEBApplicationContext

// Component Annotations
@Component - component generica (pode usar em qualquer caso)
@Repository - encapsula armazenamento, obtenção, busca para um banco relacional
@Service - Facade servidor de negocios
@Controller - controlador MVC

// Arquivos de configurações
file: app.properties
    external.service.url = http://someserver.dev.com/service

@Value("${external.service.url}")
private String url;

class:
@PropertySource("classpath:app.properties")

//########################################################################################################################## 
JUnit
assertEquals, assertTrue, assertFalse, assertNotNull, assertNull, assertArrayEquals

@BeforeClass // antes de tudo uma vez
public static void beforeClass() {}
@AfterCLass
public static void afterClass() {}
@Before // antes de cada teste
public void before() {}
@After
public void after() {}

Mockito
public interface DataService(){}
// um stub por tipo de retorno, ruim
class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {return {4,6,15};}
}
// em vez de stub, usar mock, mas fácil dizer o retorno (uma linha, sem ter que criar método)
DataService dataServiceMock = mock(DataService.class);
when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,15,12});
SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
// com Mockito fica
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMock{
    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestFromAllData(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,15}).thenReturn(...)
        int result = businessImpl.testFindTheGreatestFromAllData();
        assetEquals
    }

}
.get(0)
Mockito.anyInt()


















