package com.example.spring_app;

import com.hazelcast.config.ClasspathYamlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@Bean
	public HazelcastInstance hazelcastInstance(
			@Value("${spring.hazelcast.config:hazelcast.yaml}") String configFile) {
		String filename = configFile.replace("classpath:", "");
		return Hazelcast.newHazelcastInstance(new ClasspathYamlConfig(filename));
	}

}
