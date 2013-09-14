package com.jebhomenye.domain.common.command;

public interface CommandHandler<C extends Command> {
	
	void handle(C command);
}
