package com.example.spring_app;

import com.hazelcast.config.ClasspathYamlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@ConditionalOnProperty(name = "hazelcast.enabled", havingValue = "true")
public class HazelcastConfiguration {

    @Bean
    public HazelcastInstance hazelcastInstance(
            @Value("${spring.hazelcast.config:hazelcast.yaml}") String configFile) {
        String filename = configFile.replace("classpath:", "");
        return Hazelcast.newHazelcastInstance(new ClasspathYamlConfig(filename));
    }

    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }

}
