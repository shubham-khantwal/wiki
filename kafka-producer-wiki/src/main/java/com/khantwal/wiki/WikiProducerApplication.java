package com.khantwal.wiki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.khantwal.wiki.producer.WikiProducer;

@SpringBootApplication
public class WikiProducerApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(WikiProducerApplication.class);
	}
	
	
	@Autowired
	private WikiProducer wikiProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		wikiProducer.sendMessage();
	}
}
