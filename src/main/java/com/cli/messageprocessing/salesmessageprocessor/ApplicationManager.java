package com.cli.messageprocessing.salesmessageprocessor;

/**
 * SingleTone design pattern implementation of Manager
 * 
 * @author gauravs
 *
 */
public class ApplicationManager {

	private static ApplicationManager instance;
	private MessageProcessor messageProcessor;

	private ApplicationManager() {
		messageProcessor = new MessageProcessor();
	}

	// one instance singleton
	public static ApplicationManager getInstance() {
		if (instance == null) {
			instance = new ApplicationManager();
		}
		return instance;
	}

	/**
	 * Start application for Notification message processing
	 */
	public void start() {
		messageProcessor.startProcessing();
	}

}
