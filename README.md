# Sales Notification Message processing console based Application
Application which would read message notifications from file(JSON) and parse and process messages according to sale type(Single/Multi/Adjustment) and print reports according to sales.

###Processing requirements

All sales must be recorded

All messages must be processed

After every 10th message received your application should log a report detailing the number of sales of each product and their total value.

After 50 messages your application should log that it is pausing, stop accepting new messages and log a report of the adjustments that have been made to each sale type while the application was running.

###Sales and Messages

A sale has a product type field and a value – you should choose sensible types for these.

Any number of different product types can be expected. There is no fixed set.

A message notifying you of a sale could be one of the following types

Message Type 1 – contains the details of 1 sale E.g apple at 10p

Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of apples at 10p each.

Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. Operations can be add, subtract, or multiply e.g Add 20p apples would instruct your application to add 

## Getting Started
As its being intellectual property,I could not make it public before it get reviewed by concern team hence keep it private and shipping developed code and its dependencies in zip file format. instead of putting code on github or any other repositories.

### Prerequisites

1. Java 1.8 setup
2. Maven build tool
3. IDE
4. Reading and parsing JSON message interface JAckson framework has been used

## Building Project
Project MAVEN building tool based, to build project use below command
 mvn clean install

It will give you build of project in jar file (SalesMessageProcessor-0.0.1.jar) under {location}\SalesMessageProcessor\target

## Running Project
### IDE
1. Import given MAVEN project in IDE
2. Run main method in com.cli.messageprocessing.salesmessageprocessor.SaleMessageProcessorApp class

   
## Running the tests
1. With MAVEN,use below command
   mvn test
It will generate test case execution report under {location}\SalesMessageProcessor\target\surefire-reports (to view in browser)


## Source Code Review
This section would describe you about how application for message processing has been developed by giving some example of usage of design patterns and coding standards.Although there are many things need to be improved but given a try to gather all experience and tried to stick with design patterns and coding standards
    
1. SingleTon Pattern
   Some class used in an application are required for have only single instance of them. 
   - example: com.cli.messageprocessing.salesmessageprocessor.ApplicationManager.java;
   
 2. Command Pattern
    For message processing of different type,application used commands according to message type and process message separately. To   have less coupling among implementations 
   example: com.cli.messageprocessing.command.IMessageProcessCommand.java
   example: com.cli.messageprocessing.command.ProcessMessageCommand and com.cli.messageprocessing.command.ProcessAdjustMentMessageCommand
 
 3. Strategy Pattern:
    In an application to apply adjustment of sales with different operation types add/sutract/multiply. used strategy pattern here to pass strategy according to user choice using java 8 lambda and functional interface.  
    example: com.cli.messageprocessing.strategy.AdjustmentStrategy , its functional interface 
 
 4. Template Pattern:
    To start application have to follow some sort of sequence like first reading and parsing of input file and then processing of message.In future we might need to change something then just need to change in abstraction.
    example: com.cli.messageprocessing.salesmessageprocessor.FlowManger.java
    example: com.cli.messageprocessing.salesmessageprocessor.MessageProcessor.java
       
 Apart from these there are place where abstraction over implementation is preferred by extensibility and less code change.
 
 ### Unit Test Case added to cover most of scenarios using Junit,Hamcrest frameworks


## Author
 *** Gaurav Suryawanshi ***
    