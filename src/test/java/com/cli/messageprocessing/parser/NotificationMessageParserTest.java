package com.cli.messageprocessing.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cli.messageprocessing.model.MessageImpl;
import com.cli.messageprocessing.util.ApplicationContants;

public class NotificationMessageParserTest {

	// private static final String FILE_PATH =
	// "F:/Personal_data/GIT_jc/SalesMessageProcessor/src/main/resources/NotificationMessages.json";
	private MessageParser messageParser;

	@Before
	public void init() {
		messageParser = new NotificationMessageParser();
	}

	@Test
	public void parseNotificationMessage() {

		String filePath = new File(
				getClass().getClassLoader().getResource(ApplicationContants.NOTIFICATION_FILE_NAME).getFile())
						.getAbsolutePath();
		List<MessageImpl> messages = messageParser.parseNotificationMessage(filePath);
		assertNotNull(messages);
		assertEquals(messages.size(), 54);

	}

	@Test
	public void parseNotificationMessageWithInvadlidPath() {
		List<MessageImpl> messages = messageParser.parseNotificationMessage("");
		assertNull(messages);

	}

}
