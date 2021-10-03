package config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Component
public class ContextConfigProperties implements InitializingBean {

    private static final String TEST_PROPERTIES_FILE = "context-config.properties";
    private static final String SELENOID_HOST_PROPERTY = "selenoid.host";
    private static final String SELENOID_PORT_PROPERTY = "selenoid.port";

    private Resource resource;
    private Properties properties;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadProperties();
    }

    public ContextConfigProperties() {
        properties = new Properties();
        resource = new ClassPathResource(TEST_PROPERTIES_FILE);
    }

    public ContextConfigProperties loadProperties() {
        try {
            properties.load(resource.getInputStream());
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return this;
    }

    public String getRequiredPropertyValue(String propertyName) {
        String propertyValue = getPropertyValue(propertyName);
        assertThat(propertyValue)
                .as(String.format("'%s' property should NOT be empty", propertyName))
                .isNotEmpty();
        return propertyValue;
    }

    public String getPropertyValue(String propertyName) {
        return properties.getProperty(propertyName, System.getProperty(propertyName));
    }

    public String selenoidHost() {
        return getRequiredPropertyValue(SELENOID_HOST_PROPERTY);
    }
    public Integer selenoidPort() {
        return Integer.valueOf(getRequiredPropertyValue(SELENOID_PORT_PROPERTY));
    }
}
