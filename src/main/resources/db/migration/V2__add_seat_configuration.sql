ALTER TABLE aircrafts 
ADD COLUMN seat_configuration jsonb;

ALTER TABLE tickets
ADD COLUMN seat_status varchar(20) NOT NULL DEFAULT 'AVAILABLE'; 