package ma.gbp.objectif.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import static java.lang.System.exit;
//@EntityScan(basePackageClasses = {ObjectifProjectApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
public class ObjectifProjectApplication {
		
	
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	//@Autowired
	//DataSource dataSource;
	
	//@Autowired
	//CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ObjectifProjectApplication.class, args);
	}
	
	//@Transactional
	/*@Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n1.findAll()...");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }

        System.out.println("\n2.findByEmail(String email)...");
        for (Customer customer : customerRepository.findByEmail("222@yahoo.com")) {
            System.out.println(customer);
        }

        System.out.println("\n3.findByDate(Date date)...");
        for (Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))) {
            System.out.println(customer);
        }

        // For Stream, need @Transactional
      /**  @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        }
        System.out.println("Done!!!");
        exit(0);
	} **/

}
