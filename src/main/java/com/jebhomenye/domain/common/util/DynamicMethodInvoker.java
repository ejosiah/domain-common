package com.jebhomenye.domain.common.util;

import java.lang.reflect.Method;

import lombok.SneakyThrows;

public final class DynamicMethodInvoker {
	
	private DynamicMethodInvoker(){}
	
	@SneakyThrows
	public static void invoke(String methodName, Object onObject, Object...params){
		Method method = onObject.getClass().getDeclaredMethod(methodName, paramTypes(params));
		method.invoke(onObject, params);
	}
	
	public static Class<?>[] paramTypes(Object[] params){
		Class<?>[] types = new Class[params.length];
		for(int i = 0; i < types.length; i++){
			types[i] = params[i].getClass();
		}
		return types;
	}
}
