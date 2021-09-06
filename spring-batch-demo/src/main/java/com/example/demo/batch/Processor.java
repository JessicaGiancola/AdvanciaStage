package com.example.demo.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{

	private static final Map<String, String> DEPTS = new HashMap<>();
	
	public Processor() {
		
		DEPTS.put("001", "Technology");
		DEPTS.put("002", "Commercial");
		DEPTS.put("003", "Human Resource");
	}
	
	@Override
	public User process(User item) throws Exception {
		
		String dep = item.getDept();
		item.setDept(DEPTS.get(dep));
		return item;
	}
	

}
