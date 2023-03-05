package com.icrypt.app.processing;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

import com.icrypt.app.annotation.StatusField;
import com.icrypt.app.annotation.TransactWorkflow;
import com.icrypt.app.annotation.Workflow;
import com.icrypt.app.service.WorkflowService;

public class AnnotationProcessor {
	private void checkIfTransactWorkflow(Object object) {
		if (Objects.isNull(object)) {
//	        throw new JsonSerializationException("The object to serialize is null");
		}

		Class<?> clazz = object.getClass();
		if (!clazz.isAnnotationPresent(TransactWorkflow.class)) {
			System.out.println("Not Annotated");
		} else {
			System.out.println("Annotated");
		}
	}

	private void checkIfStatusField(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(StatusField.class)) {
				field.setAccessible(true);
				System.out.println(field.get(object));
				int i = (int) field.get(object);
				i = i + 1;
				field.set(object, i);
			}
		}
	}

	private void checkIfWorkflowMethod(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		for (Method method : clazz.getMethods()) {
			if(method.isAnnotationPresent(Workflow.class)) {
				System.out.println(method);
			}
		}
	}

	public void testAllAnnotation(Object object) throws IllegalArgumentException, IllegalAccessException {
		checkIfTransactWorkflow(object);
		checkIfStatusField(object);
		checkIfWorkflowMethod(object);
	}
	public static void main(String [] args) throws IllegalArgumentException, IllegalAccessException {
		
		AnnotationProcessor ap = new AnnotationProcessor();
		WorkflowService workflowService = new WorkflowService();
		workflowService.setStatus(3);
		ap.testAllAnnotation(workflowService);
		System.out.println(WorkflowService.class.getAnnotation(TransactWorkflow.class).type());
		System.out.println(workflowService.getStatus());
	}
	
}
