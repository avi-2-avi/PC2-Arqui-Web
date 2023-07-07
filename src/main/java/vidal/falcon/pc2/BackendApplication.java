package vidal.falcon.pc2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vidal.falcon.pc2.entities.VfEmployee;
import vidal.falcon.pc2.entities.VfEnterprise;
import vidal.falcon.pc2.repositories.VfEmployeeRepository;
import vidal.falcon.pc2.repositories.VfEnterpriseRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner vfMappingDemo(
			VfEnterpriseRepository vfEnterpriseRepository,
			VfEmployeeRepository vfEmployeeRepository
	) {
		return args -> {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			VfEnterprise enterprise1 = vfEnterpriseRepository.save(new VfEnterprise("Leche Inc","SRL", dateFormat.parse("2021-01-02"), dateFormat.parse("2020-01-05"), "Activo"));
			VfEnterprise enterprise2 = vfEnterpriseRepository.save(new VfEnterprise("Queso Inc","SAC", dateFormat.parse("2021-01-03"), dateFormat.parse("2020-01-09"), "Suspendido"));

			vfEmployeeRepository.save(new VfEmployee("Cristina Vidal",  dateFormat.parse("2021-01-02"), "A3", 12.1, "Chofer", enterprise1));
			vfEmployeeRepository.save(new VfEmployee("Lisein",  dateFormat.parse("2021-03-03"), "A2", 1.1, "Administrativo", enterprise2));
		};
	}

}
