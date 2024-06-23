-- Insert clients
INSERT INTO client (name, email)
VALUES ('John Doe', 'john.doe@example.com');

INSERT INTO client (name, email)
VALUES ('Jane Smith', 'jane.smith@example.com');

INSERT INTO client (name, email)
VALUES ('Michael Johnson', 'michael.johnson@example.com');

INSERT INTO client (name, email)
VALUES ('Emily Brown', 'emily.brown@example.com');

INSERT INTO client (name, email)
VALUES ('David Wilson', 'david.wilson@example.com');

-- Insert traders
INSERT INTO trader (name)
VALUES ('Trader A');

INSERT INTO trader (name)
VALUES ('Trader B');

-- Insert pots (associated with clients)
-- Insert 3 available pots
INSERT INTO pot (client_id, amount, available, transaction_count)
SELECT c.client_id, FLOOR(RAND() * 100) + 1, true, FLOOR(RAND() * 10) + 1
FROM client c
WHERE c.client_id IN (1, 2, 3);

-- Insert 2 non-available pots
INSERT INTO pot (client_id, amount, available, transaction_count)
SELECT c.client_id, FLOOR(RAND() * 100) + 1, false, FLOOR(RAND() * 10) + 1
FROM client c
WHERE c.client_id IN (4, 5);
