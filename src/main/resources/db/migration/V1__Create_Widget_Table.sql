CREATE DATABASE widgetdb;

CREATE TABLE widget (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT NOT NULL CHECK (char_length(description) BETWEEN 5 AND 1000),
    price DECIMAL(10,2) CHECK (price BETWEEN 1 AND 20000) NOT NULL
);