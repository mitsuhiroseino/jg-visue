/**
 * 
 */
package com.purejadeite.visue.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sample")
public class SampleComponent {

	public SampleComponent() {
		super();
	}

}
