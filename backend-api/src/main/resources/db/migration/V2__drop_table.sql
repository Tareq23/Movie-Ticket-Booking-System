/*
ALTER TABLE tickets
    ADD COLUMN screening_ref VARCHAR(15) NOT NULL,
    ADD FOREIGN KEY (cinema_id, auditorium_id) REFERENCES auditoriums(cinema_id, auditorium_id),
    ADD FOREIGN KEY (booking_id) REFERENCES bookings(booking_id);

-- Add this composite unique constraint to prevent double-booking
ALTER TABLE tickets
    ADD CONSTRAINT unique_seat_per_screening
        UNIQUE (cinema_id, auditorium_id, row, number, screening_ref);


*/

/*
 drop table movie_reviews;
 drop table discount_coupons;
 drop table payments;
 drop table tickets;
 drop table seats;
 drop table seat_locks;
 drop table bookings;
 drop table movie_categories;
 drop table screenings;
 drop table auditoriums;
 drop table cinemas;
 drop table movies;
 drop table users;

 truncate table flyway_schema_history;
*/
-- truncate table flyway_schema_history;