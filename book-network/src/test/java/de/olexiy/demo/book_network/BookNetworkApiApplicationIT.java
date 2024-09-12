package de.olexiy.demo.book_network;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@Tag("integration")
class BookNetworkApiApplicationIT {
	@Container
	@ServiceConnection
	public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres");
	@Test
	void contextLoads() {
	}

}
