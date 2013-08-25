package com.jebhomenye.domain.common.core;

import java.lang.reflect.Field;

import lombok.SneakyThrows;

public abstract class Momento {
	
	public Momento(Entity entity){
		buildthisFrom(entity);
	}
	
	@SneakyThrows
	private void buildthisFrom(Entity entity) {
		Field[] fieldsFromEntity = entity.getClass().getDeclaredFields();

		for(Field entityField : fieldsFromEntity){
			Field momentoField = this.getClass().getDeclaredField(entityField.getName());
			if(momentoField == null){
				throw new RuntimeException("memento should have all fields from entity");
			}
			Object value = entityField.get(entity);
			momentoField.set(this, value);
		}
		
	}
}
