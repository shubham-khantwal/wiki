package com.khantwal.wiki.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.khantwal.wiki.entities.WikiEntity;
import com.khantwal.wiki.repos.WikiRepository;

@Service
public class WikiConsumer {
	private static final Logger logger = LoggerFactory.getLogger(WikiConsumer.class);
	
	private WikiRepository wikiRepo;
	
	
	
	public WikiConsumer(WikiRepository wikiRepo) {
		super();
		this.wikiRepo = wikiRepo;
	}



	@KafkaListener(topics="wiki_changes", groupId="myGroup")
	public void consume(String eventMessage) {
//		logger.info(String.format("Event message recieved %d = %s", eventMessage.length(),eventMessage));
		if (eventMessage.length() > 255) {
	        // Log and truncate or handle large message
	        logger.info("Message size exceeds limit, truncating or handling separately. "+eventMessage.length());
	        eventMessage = eventMessage.substring(0, 255);  // Optional: Truncate or handle large messages
	    } else {
	        logger.info("Message size within range");

	    }
		WikiEntity wiki = new WikiEntity();
		wiki.setWikiEventData(eventMessage);
		wikiRepo.save(wiki);
	}

}
