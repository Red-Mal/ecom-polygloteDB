-- Insert sample users
INSERT INTO users (name, email, address, phone_number) VALUES
('John Doe', 'john.doe@example.com', '123 Main St, New York, NY 10001', '+1-555-0123'),
('Jane Smith', 'jane.smith@example.com', '456 Oak Ave, Los Angeles, CA 90001', '+1-555-0124'),
('Bob Johnson', 'bob.johnson@example.com', '789 Pine Rd, Chicago, IL 60601', '+1-555-0125'),
('Alice Brown', 'alice.brown@example.com', '321 Maple Dr, Houston, TX 77001', '+1-555-0126'),
('Charlie Wilson', 'charlie.wilson@example.com', '654 Elm St, Miami, FL 33101', '+1-555-0127');

-- Insert sample orders
INSERT INTO orders (user_id, total_amount, status, shipping_address) VALUES
(1, 299.99, 'CONFIRMED', '123 Main St, New York, NY 10001'),
(2, 149.99, 'SHIPPED', '456 Oak Ave, Los Angeles, CA 90001'),
(1, 499.99, 'PENDING', '123 Main St, New York, NY 10001'),
(3, 199.99, 'DELIVERED', '789 Pine Rd, Chicago, IL 60601'),
(4, 399.99, 'CONFIRMED', '321 Maple Dr, Houston, TX 77001'),
(2, 249.99, 'PENDING', '456 Oak Ave, Los Angeles, CA 90001'),
(5, 599.99, 'SHIPPED', '654 Elm St, Miami, FL 33101'),
(3, 159.99, 'CONFIRMED', '789 Pine Rd, Chicago, IL 60601'),
(4, 799.99, 'PENDING', '321 Maple Dr, Houston, TX 77001'),
(5, 299.99, 'DELIVERED', '654 Elm St, Miami, FL 33101'); 