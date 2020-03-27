package com.bolsaideas.springboot.web.app.events.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.bolsaideas.springboot.web.app.domain.model.Hugo;
import com.bolsaideas.springboot.web.app.events.model.EventDeviceHugo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEventDeviceHugo implements EventDeviceHugo {

	  @Autowired
	  private JmsTemplate jmsTemplate;

	  @Autowired
	  private ObjectMapper mapper;
	  
	  @Value("${message.outbound.hugoWithoutJMQueue}")
	  private String outboundDeviceWithoutJMQueue;
	  
	
	@Override
	public void publisDeviceHugo(Hugo eventoModelHugoDevice) {
		
		try {
			
			jmsTemplate.convertAndSend(outboundDeviceWithoutJMQueue,mapper.writeValueAsString(eventoModelHugoDevice));
			
		}catch (JsonProcessingException ex) {
		      log.error(String.format("jms send. Exception convert object to json: [%s]",ex.getMessage()));
		
		}
		
	}

}
