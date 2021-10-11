package za.ac.nwu.ac.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.ac.nwu.ac.logic.config.LogicConfig;
import org.springframework.context.annotation.Import;

@Import(LogicConfig.class)
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.web.sb.controller",
        "za.ac.nwu.ac.web.sb.exception"
})
public class WebConfig {
}