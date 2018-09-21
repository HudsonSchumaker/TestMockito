package br.com.schumaker.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import br.com.schumaker.mockito.EvenOdd;

public class TestReflaction {
	public static void main(String... args) {
		Class<?> clazz = EvenOdd.class;
		Method[] methods = clazz.getDeclaredMethods();
		
		for(Method m : methods) {
			System.out.printf("nome %s%n", m.getName());
			System.out.printf("\t # return %s%n", m.getReturnType());
			System.out.printf("\t # params %s%n", m.getParameterCount());
			System.out.printf("\t # modifier %s%n", Modifier.toString(m.getModifiers()));
		}
	}
}