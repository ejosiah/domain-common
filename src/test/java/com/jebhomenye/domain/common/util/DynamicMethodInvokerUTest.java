package com.jebhomenye.domain.common.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DynamicMethodInvokerUTest {
	
	private static class Param{
		
	}
	
	private static class Param2{
		
	}
	
	private static class TestObject{
		
		void testMethod(Param param){
			
		}
		
		void testMethod(Param param, Param2 param2){
			
		}
	}
	
	@Spy TestObject testInterface = new TestObject();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInvoke() {
		Param param = new Param();
		DynamicMethodInvoker.invoke("testMethod", testInterface, param);
		verify(testInterface).testMethod(param);
	}
	
	@Test
	public void testInvokeMultipleParamMethod(){
		Param param = new Param();
		Param2 param2 = new Param2();
		DynamicMethodInvoker.invoke("testMethod", testInterface, param, param2);
		verify(testInterface).testMethod(param, param2);
	}
	
	@Test(expected=NoSuchMethodException.class)
	public void testInokeNonExistentMethod(){
		Param param = new Param();
		DynamicMethodInvoker.invoke("fakeMethod", testInterface, param);
		
	}

}
