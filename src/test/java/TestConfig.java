import com.example.Security.JwtAuthFilter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestConfig {
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return mock(JwtAuthFilter.class);
    }
}
