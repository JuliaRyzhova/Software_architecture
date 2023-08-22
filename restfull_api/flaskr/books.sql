CREATE TABLE IF NOT EXISTS books (
  book_id integer PRIMARY KEY AUTOINCREMENT,
  title text NOT NULL,
  author text NOT NULL,
  price real NOT NULL,
  count_book integer,
  year_release text NOT NULL
);