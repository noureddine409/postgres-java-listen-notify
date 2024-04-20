# PostgreSQL Notify/Listen Lab

## Overview

This lab demonstrates the usage of the `NOTIFY` and `LISTEN` features in PostgreSQL. These features enable real-time communication between different sessions or threads within the database.

In this lab, we'll explore two scenarios:

1. **Publish-Subscribe Model:** Two separate threads will be used—one for publishing notifications (`NOTIFY`) and the other for listening to these notifications (`LISTEN`).

2. **Trigger-Based Notification:** We'll utilize triggers to automatically notify a Java application whenever a new row is inserted into a table.

## Requirements

- PostgreSQL installed on your machine.
- Basic understanding of SQL and database concepts.
- Optionally, a Java environment to interact with the database using JDBC for the second scenario.

## Setup

1. **Database Setup:**
   - Create a PostgreSQL database.
   - Create the necessary table with the desired schema. (Refer to the provided SQL script for creating the table structure.)

2. **Publish-Subscribe Model:**
   - Create two separate database connections or sessions—one for publishing and the other for listening.
   - Execute SQL commands to `NOTIFY` and `LISTEN` to the desired channel.

3. **Trigger-Based Notification:**
   - Create a trigger function that executes the `NOTIFY` command whenever a new row is inserted into the table.
   - Attach the trigger function to the `AFTER INSERT` event on the table.

## Lab 

### Scenario 1: Publish-Subscribe Model

1. Open two separate database connections—one for publishing and the other for listening.
2. In the publishing connection, insert a new row into the table.
3. Observe the notification received by the listening connection.

### Scenario 2: Trigger-Based Notification

1. Set up a Java application with JDBC connectivity to the PostgreSQL database.
2. Create a trigger function in PostgreSQL that sends a notification to the Java application whenever a new row is inserted into the table.
3. Insert a new row into the table using any SQL client.
4. Verify that the Java application receives the notification.

## Additional Notes

- It's recommended to have a clear understanding of PostgreSQL triggers and the concept of asynchronous notifications before attempting the lab exercises.
- Feel free to customize the provided SQL scripts and Java application according to your requirements.
