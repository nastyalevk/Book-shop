package nastya.BookShop;

import nastya.BookShop.model.User;
import nastya.BookShop.service.api.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootMysqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlCrudApplication.class, args);
	}

}