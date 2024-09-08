package com.khantwal.wiki.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
	public NewTopic topic() {
		return TopicBuilder.name("wiki_changes").build();
	}
}
