package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Teste {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Async
	public void teste() {
		try {
			Thread.sleep(20000);
			logger.info("passou por aqui");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
