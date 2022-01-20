package cn.nanchaos.nim.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

/**
 * @author nanchaos
 */
@Configuration
@ConditionalOnExpression(value = "${nanchaos.enable.scheduling}")
@Import(SchedulingConfiguration.class)
public class ControlSchedulingConfiguration {

}