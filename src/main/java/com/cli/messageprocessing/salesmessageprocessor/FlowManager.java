package com.cli.messageprocessing.salesmessageprocessor;

/**
 * Flow manager of application, It implements template method design pattern
 * Base abstract class contain complete implementation of an operation(method)
 * and used in the algorithm
 * 
 * @author gauravs
 *
 */
public abstract class FlowManager {

	/**
	 * Template method in base class should be restricted so that the subclasses
	 * does not override it
	 */
	public final void startNotificationProcessing() {
		praseMessage();
		processMessage();
	}

	/**
	 * Read file from given path and parse it JSON to JAVA object
	 */
	abstract void praseMessage();

	/**
	 * According to messages given, process messages according to their types
	 * and create sale records
	 * 
	 * @return
	 */
	abstract boolean processMessage();

}
