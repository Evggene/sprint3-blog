package org.bea;

import org.bea.config.TestConfig;
import org.bea.configuration.DataSourceConfiguration;
import org.bea.configuration.WebAppInitializer;
import org.bea.configuration.WebConfiguration;
import org.bea.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.context.request.async.WebAsyncManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class, TestConfig.class})
public class TestClass {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        var user = userRepository.findAll();
        assertEquals(user.get(0).getId(), 1);
    }
}
