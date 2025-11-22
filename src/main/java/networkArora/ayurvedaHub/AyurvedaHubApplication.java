package networkArora.ayurvedaHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AyurvedaHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyurvedaHubApplication.class, args);
	}

}
