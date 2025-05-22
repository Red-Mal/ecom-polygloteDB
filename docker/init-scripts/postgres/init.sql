-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address TEXT NOT NULL,
    phone_number VARCHAR(20),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create orders table
CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    total_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    shipping_address TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_orders_user_id ON orders(user_id);
CREATE INDEX IF NOT EXISTS idx_orders_status ON orders(status);

-- Insert sample data
INSERT INTO users (name, email, address, phone_number, created_at, updated_at) VALUES
('John Doe', 'john.doe@example.com', '123 Main St, City', '+1-555-0123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jane Smith', 'jane.smith@example.com', '456 Oak Ave, Town', '+1-555-0124', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Bob Johnson', 'bob.johnson@example.com', '789 Pine Rd, Village', '+1-555-0125', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert orders
INSERT INTO orders (user_id, total_amount, status, shipping_address, created_at, updated_at) VALUES
(1, 299.99, 'CONFIRMED', '123 Main St, City', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 149.99, 'SHIPPED', '456 Oak Ave, Town', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 499.99, 'PENDING', '123 Main St, City', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 