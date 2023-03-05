package com.icrypt.app.service;

import com.icrypt.app.annotation.StatusField;
import com.icrypt.app.annotation.TransactWorkflow;
import com.icrypt.app.annotation.Workflow;

@TransactWorkflow(type="PARALLEL")
public class WorkflowService {
	
	@StatusField
	int status=0;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Workflow
	public boolean workflowOrchestration(int status) {
		System.out.println(status);
		return true;
	}
}
