

CREATE TABLE if not exists users (
   user_id INT PRIMARY KEY,
   password VARCHAR(255) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   phone VARCHAR(20),
   dob DATE,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists movies (
    movie_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    duration_minutes INT NOT NULL,
    release_date DATE,
    genre VARCHAR(50),  -- e.g., "Action", "Horror"
    language VARCHAR(50),
    rating VARCHAR(10), --// e.g., "PG-13", "R"
    poster_url VARCHAR(255)
);


CREATE TABLE if not exists cinemas (
     cinema_id INT PRIMARY KEY,
     cinema_name VARCHAR(100) NOT NULL,
     address TEXT NOT NULL,
     city VARCHAR(50) NOT NULL,
     facilities TEXT --// e.g., "3D, Dolby Atmos"
);

CREATE TABLE if not exists auditoriums (
     cinema_id INT NOT NULL,
     auditorium_id INT NOT NULL, -- COMPOSITE PRIMARY KEY (AUDITORIUM_ID, CINEMA_ID)
     name VARCHAR(50) NOT NULL,
     capacity INT NOT NULL,
     PRIMARY KEY (cinema_id, auditorium_id),
     FOREIGN KEY (cinema_id) REFERENCES cinemas(cinema_id)
);

CREATE TABLE  if not exists screenings (
    screening_id INT PRIMARY KEY,
    movie_id INT NOT NULL,
    auditorium_id INT NOT NULL,
    cinema_id INT NOT NULL,
    start_time TIMESTAMPTZ NOT NULL,
    end_time TIMESTAMPTZ NOT NULL,
    base_price DECIMAL(10,2) NOT NULL,
    available_seats INT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (cinema_id, auditorium_id) REFERENCES auditoriums(cinema_id, auditorium_id)
);

CREATE TABLE if not exists movie_categories (
      category_id INT PRIMARY KEY,
      category_name VARCHAR(50) UNIQUE NOT NULL,
      description TEXT
);


CREATE TABLE if not exists  bookings (
  booking_id INT PRIMARY KEY,
  user_id INT NOT NULL,
  screening_id INT NOT NULL,-- // Changed from event_id
  booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total_amount DECIMAL(10,2) NOT NULL,
  status VARCHAR(15), -- ENUM('pending', 'confirmed', 'cancelled'),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (screening_id) REFERENCES screenings(screening_id)
);

CREATE TABLE if not exists  seats (
  seat_id INT PRIMARY KEY,
  cinema_id INT NOT NULL,
  auditorium_id INT NOT NULL,
  row CHAR(1) NOT NULL, --// e.g., "A", "B"
  number INT NOT NULL,  --// e.g., 1, 2
  type VARCHAR(10) DEFAULT 'standard' , --('standard', 'premium', 'sofa') DEFAULT 'standard',
  FOREIGN KEY (cinema_id, auditorium_id) REFERENCES auditoriums(cinema_id, auditorium_id),
  UNIQUE (auditorium_id, row, number)
);

CREATE TABLE if not exists  tickets (
     ticket_id INT PRIMARY KEY,
     booking_id INT NOT NULL,
     seat_id INT NOT NULL,
     type VARCHAR(10), -- ENUM('adult', 'child', 'senior') NOT NULL,
     price DECIMAL(10,2) NOT NULL,
     FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
     FOREIGN KEY (seat_id) REFERENCES seats(seat_id)
);

CREATE TABLE if not exists  payments (
      payment_id INT PRIMARY KEY,
      amount DECIMAL(10,2) NOT NULL,
      payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      payment_method VARCHAR(20) NOT NULL, --('credit_card', 'debit_card', 'paypal', 'bank_transfer', 'cash') NOT NULL,
      transaction_id VARCHAR(100),
      status VARCHAR NOT NULL , --('pending', 'completed', 'failed', 'refunded') NOT NULL,
      card_last_four VARCHAR(4),
      payment_gateway VARCHAR(50)
);

CREATE TABLE if not exists  discount_coupon(
   discount_id INT PRIMARY KEY,
   code VARCHAR(50) UNIQUE NOT NULL,
   description TEXT,
   discount_type VARCHAR(10) NOT NULL, -- ENUM('percentage', 'fixed') NOT NULL,
   discount_value DECIMAL(10,2) NOT NULL,
   start_date TIMESTAMPTZ NOT NULL,
   end_date TIMESTAMPTZ NOT NULL,
   max_uses INT,
   current_uses INT DEFAULT 0,
   min_order_amount DECIMAL(10,2) DEFAULT 0,
   is_active BOOLEAN DEFAULT TRUE
);




CREATE TABLE if not exists  movie_reviews (
       review_id INT PRIMARY KEY,
       user_id INT NOT NULL,
       movie_id INT NOT NULL,
       rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
       review_text TEXT,
       review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (user_id) REFERENCES users(user_id),
       FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);


/*
    SEQUENCE
*/

CREATE SEQUENCE IF NOT EXISTS USER_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS MOVIES_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS MOVIE_REVIEW_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS cinemas_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS organizations_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS TICKET_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS SEAT_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS DISCOUNT_COUPON_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS PAYMENT_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS BOOKING_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;







