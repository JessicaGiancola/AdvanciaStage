package springbatch.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbatch.example.model.User;
import springbatch.example.util.MyReader;
import springbatch.example.util.MyWriter;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Autowired
	public JobBuilderFactory jbf;
	
	@Autowired
	public StepBuilderFactory sbf;
	
	@Autowired
	public MyReader reader;
	
	@Autowired
	public MyWriter writer;
	
	@Bean
	public Job job() {
		
		return jbf.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep()).end().build();
	}
	
	private Step createStep() {
		return sbf.get("MyStep")
				.<User, User> chunk(1)
				.reader(reader)
				.writer(writer)
				.build();		
	}
}
