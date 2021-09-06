package com.example.demo.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import com.example.demo.model.User;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Bean
	public Job job(JobBuilderFactory jbf, StepBuilderFactory sbf, ItemReader<User> it, ItemProcessor<User, User> ip, ItemWriter<User> iw) {
		
		Step step = sbf.get("firstJob-file-load").<User,User>chunk(100)
						.reader(it).processor(ip).writer(iw).build();
		Job j = jbf.get("firstJob").incrementer(new RunIdIncrementer())
							.start(step).build();
		
		return j;		
	}
	
	@Bean
	public FlatFileItemReader<User> fileItemReader(){
		
		FlatFileItemReader<User> ffir = new FlatFileItemReader<>();
		ffir.setResource(new PathResource("src/main/resources/user.csv"));
		ffir.setName("CSV-Reader");
		ffir.setLinesToSkip(1);
		ffir.setLineMapper(lineMapper());
		
		return ffir;
		
	}

	
	@Bean
	public LineMapper<User> lineMapper() {
		DefaultLineMapper<User> dlm = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		BeanWrapperFieldSetMapper<User> bwfsm = new BeanWrapperFieldSetMapper<>();
		
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] {"id","name","dept","salary"});
		
		bwfsm.setTargetType(User.class);
		
		dlm.setLineTokenizer(tokenizer);
		dlm.setFieldSetMapper(bwfsm);
		
		return dlm;
	}
	
	

}
