/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com619.devops.user.spring.service;

import org.solent.com619.devops.user.dao.impl.PersistenceJPAConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author cgallen
 */
@Configuration

@ComponentScan(basePackages = {"org.solent.com619.devops.user.spring.service"})
@Import({PersistenceJPAConfig.class})
public class ServiceConfiguration {

}
