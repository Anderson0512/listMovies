//package com.nttdataestudos.config;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import static org.mockito.Mockito.*;
//
//class WebConfigTest {
//
//    private WebConfig webConfig;
//    private CorsRegistry corsRegistry;
//
//    @BeforeEach
//    public void setup() {
//        webConfig = new WebConfig();
//        corsRegistry = mock(CorsRegistry.class);
//    }
//
//    @Test
//    void testCorsConfigurer() {
//        // Arrange
//        String corsOrigins = "http://example.com";
//        ReflectionTestUtils.setField(webConfig, "corsOrigins", corsOrigins);
//
//        WebMvcConfigurer configurer = webConfig.corsConfigurer();
//
//        // Act
//        configurer.addCorsMappings(corsRegistry);
//
//        // Assert
//        verify(corsRegistry).addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
//    }
//}
