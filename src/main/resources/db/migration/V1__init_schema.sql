CREATE TABLE aircrafts (
    id BIGSERIAL PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    cargo_capacity INTEGER NOT NULL,
    manufacture_date DATE NOT NULL,
    registration_number VARCHAR(255) NOT NULL UNIQUE,
    contract_number VARCHAR(255) NOT NULL,
    in_operation BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE flights (
    id BIGSERIAL PRIMARY KEY,
    departure_airport VARCHAR(3) NOT NULL,
    arrival_airport VARCHAR(3) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    aircraft_id BIGINT REFERENCES aircrafts(id),
    status VARCHAR(20) NOT NULL
);

CREATE TABLE tickets (
    id BIGSERIAL PRIMARY KEY,
    flight_id BIGINT REFERENCES flights(id),
    seat_number VARCHAR(10) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL
); 