package com.mattjeon.stock.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
 
public class DummyJobBean extends QuartzJobBean {
 
    private DummyTask dummyTask;
 
    @Override
	protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
    	System.out.println("Batch Start ");
        try {
			dummyTask.batchSchedule();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
 
    public void setDummyTask(DummyTask dummyTask) {
        this.dummyTask = dummyTask;
    }
 
}