package com.gsssoftware.java.utility.restfulservices.executorFrameworkexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		
		Callable<String> task1=new Callable<String>() {
			
			public String call(){
				return "task1";
			}
			
		};
		
Callable<String> task2=new Callable<String>() {
			
			public String call(){
				return "task2";
			}
			
		};
		
Callable<String> task3=new Callable<String>() {
			
			public String call(){
				return "task3";
			}
			
		};
		
		List<Callable<String>> tasks=new ArrayList<Callable<String>>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		List<Future<String>>results=executorService.invokeAll(tasks);
		for(Future future:results){
			System.out.println(" Result "+future.get());
		}
		
		executorService.shutdown();
		executorService.awaitTermination(10, TimeUnit.DAYS);
		

	}

}
