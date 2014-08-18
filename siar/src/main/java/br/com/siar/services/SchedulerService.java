package br.com.siar.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.JOptionPane;

@Service
public class SchedulerService{
	private BasicQuery query1 = new BasicQuery("{ age : { $lt : 40 }, name : 'cat' }");
	 
	@Scheduled(fixedRate=1000)
	public void yay(){

		//System.out.println("yay");
	}
}