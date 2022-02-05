package br.com.alura.leilao.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Qual é o executor
@CucumberOptions(features = "classpath:features") // onde busca as features
public class LeilaoCucumberRunner {
}
