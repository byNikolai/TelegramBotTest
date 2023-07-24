-- liquibase formatted sql

-- changeset bynikolai:create_notification_task
CREATE TABLE notification_task
(
    id                     SERIAL,
    message                TEXT      NOT NULL,
    chat_id                BIGINT    NOT NULL,
    notification_data_time TIMESTAMP NOT NULL
);
