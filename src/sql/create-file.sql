INSERT INTO files (
  name, created_at, updated_at
) VALUES (
  :name, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()
);
