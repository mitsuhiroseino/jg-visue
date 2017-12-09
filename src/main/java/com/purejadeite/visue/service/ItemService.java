/**
 * Serviceはビジネスロジック
 */
package com.purejadeite.visue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.purejadeite.visue.component.SampleComponent;

@Service
@ConfigurationProperties(prefix = "item")
public class ItemService {
	
	@Autowired
	SampleComponent component = null;

	public ItemService() {
		super();
	}
	
	

}
