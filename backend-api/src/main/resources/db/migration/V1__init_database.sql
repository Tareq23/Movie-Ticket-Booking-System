

CREATE TABLE if not exists users (
   user_id BIGINT PRIMARY KEY,
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
    genre VARCHAR(50),
    language VARCHAR(50),
    rating VARCHAR(10),
    poster_url VARCHAR(255),
    trailer_url VARCHAR(300)
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
    cinema_id INT NOT NULL,
    auditorium_id INT NOT NULL,
    screening_sl INT NOT NULL,
    movie_id INT NOT NULL,
    start_time TIMESTAMPTZ NOT NULL,
    end_time TIMESTAMPTZ NOT NULL,
    primary key (cinema_id, auditorium_id, screening_sl),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (cinema_id, auditorium_id) REFERENCES auditoriums(cinema_id, auditorium_id)
);

CREATE TABLE if not exists movie_categories (
      category_id BIGINT PRIMARY KEY,
      category_name VARCHAR(50) UNIQUE NOT NULL,
      description TEXT
);


CREATE TABLE if not exists  bookings (
  booking_id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  payment_id BIGINT,
  screening_ref VARCHAR(15) NOT NULL, -- concatenation of screening key (cinema id, auditorium id, screening sl)
  booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total_amount DECIMAL(10,2) NOT NULL,
  payment_status VARCHAR(15) -- ENUM('pending', 'confirmed', 'cancelled'),

);

CREATE TABLE if not exists  seats (
  cinema_id INT NOT NULL,
  auditorium_id INT NOT NULL,
  row VARCHAR(5) NOT NULL, --// e.g., "A", "B"
  number INT NOT NULL,  --// e.g., 1, 2
  type VARCHAR(10) DEFAULT 'standard' , --('standard', 'premium', 'sofa') DEFAULT 'standard',
  PRIMARY KEY (cinema_id, auditorium_id, row, number)
);

-- Temporary reservation (expires in 10 minutes)
CREATE TABLE seat_locks (
    seat_ref VARCHAR(20) NOT NULL, --concatenation of seats key (cinema_id, auditorium_id, row, number)
    screening_ref VARCHAR(15) NOT NULL,
    user_id INT NOT NULL,
    expires_at TIMESTAMPTZ NOT NULL DEFAULT (NOW() + INTERVAL '10 minutes'),
    PRIMARY KEY (seat_ref, screening_ref)
);

CREATE TABLE if not exists  tickets (
     cinema_id INT NOT NULL,
     auditorium_id INT NOT NULL,
     row VARCHAR(5) NOT NULL,
     number INT NOT NULL,
     booking_id BIGINT NOT NULL,
     type VARCHAR(10), -- ENUM('adult', 'child', 'senior') NOT NULL,
     price DECIMAL(10,2) NOT NULL,
     primary key (cinema_id, auditorium_id, row, number)
);

CREATE TABLE if not exists  payments (
      payment_id BIGINT PRIMARY KEY,
      amount DECIMAL(10,2) NOT NULL,
      payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      payment_method VARCHAR(20) NOT NULL,
      transaction_id VARCHAR(100),
      status VARCHAR(30) NOT NULL,
      card_last_four VARCHAR(4),
      payment_gateway VARCHAR(50)
);

CREATE TABLE if not exists  discount_coupons(
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
       review_id BIGINT PRIMARY KEY,
       user_id BIGINT NOT NULL,
       movie_id INT NOT NULL,
       rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
       review_text TEXT,
       review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       review_updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


/*
    SEQUENCE
*/

CREATE SEQUENCE IF NOT EXISTS USER_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS MOVIE_CATEGORIES_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS MOVIE_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS MOVIE_REVIEW_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS CINEMA_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1001 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS ORGANIZATION_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS TICKET_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS SEAT_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS DISCOUNT_COUPON_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS PAYMENT_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS BOOKING_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 117283 CACHE 1 NO CYCLE;







