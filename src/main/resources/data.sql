DROP TABLE IF EXISTS jokes;

CREATE TABLE jokes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content CLOB,
  createdAt TIMESTAMP WITH TIME ZONE
);

INSERT INTO jokes (content, createdAt) VALUES
  ('whatthefuck1', '2005-12-31 23:59:59Z'),
  ('asdasfd', '2009-02-01 23:59:59Z'),
  ('fsdfsdf', CURRENT_TIMESTAMP);