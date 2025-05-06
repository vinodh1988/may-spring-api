package com.solution.states;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationState {
	private Integer state=0;

	public Integer getState() {
		return state;
	}

	public void setState() {
		this.state++;
	}
}
