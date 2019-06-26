package com.cli.messageprocessing.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.cli.messageprocessing.model.MessageImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Notification message parsing for JSON format interface
 * 
 * @author gauravs
 *
 */
public class NotificationMessageParser implements MessageParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cli.messageprocessing.parser.MessageParser#parseNotificationMessage(
	 * java.lang.String)
	 */
	public List<MessageImpl> parseNotificationMessage(String notificationsFile) {
		List<MessageImpl> messages = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			// JSON file to Java object of MessageImpl type
			messages = mapper.readValue(new File(notificationsFile), new TypeReference<List<MessageImpl>>() {
			});
		} catch (IOException e) {
			// Logger log
			System.out.println("Excetion while parsing Input file" + e);
		}
		return messages;
	}

}
