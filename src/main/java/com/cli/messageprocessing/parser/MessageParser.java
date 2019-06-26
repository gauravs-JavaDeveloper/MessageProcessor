package com.cli.messageprocessing.parser;

import java.util.List;

import com.cli.messageprocessing.model.MessageImpl;

/**
 * Generic interface for parsing notification messages
 * 
 * @author gauravs
 *
 */
public interface MessageParser {

	/**
	 * Parse Notification message from given file
	 * 
	 * @param notificationsFile
	 * @return
	 */
	public List<MessageImpl> parseNotificationMessage(String notificationsFile);

}
