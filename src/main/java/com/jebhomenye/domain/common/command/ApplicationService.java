package com.jebhomenye.domain.common.command;

import lombok.SneakyThrows;

import static com.jebhomenye.domain.common.util.DynamicMethodInvoker.*;

public abstract class ApplicationService {
	
	@SneakyThrows
	public <C extends Command>void execute(C command){
		invoke("when", this, command);		
	}
	
}
