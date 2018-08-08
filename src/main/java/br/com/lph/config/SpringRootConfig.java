package br.com.lph.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // marca a classe como sendo de configuração do spring
@EnableWebMvc // habilita suporte para o SpringMVC
@EnableTransactionManagement // habilita o spring para controla as trasações com o banco de dados
@ComponentScan("br.com.lph") // passa o caminho para o spring scanear as classes gerenciadas por ele
public class SpringRootConfig {

}
