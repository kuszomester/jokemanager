DROP TABLE IF EXISTS jokes;

CREATE TABLE jokes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content CLOB,
  createdAt TIMESTAMP
);

INSERT INTO jokes (content, createdAt) VALUES
  ('A boy asked his Bitcoin-investing dad for $10.00 worth of Bitcoin currency. Dad: $9.67? What do you need $10.32 for?', '2005-12-31 23:59:59'),
  ('Why was the anti-vaxxer‘s 4 year old child crying? Midlife crisis', '2009-02-01 23:59:59'),
  ('What has 4 letters, sometimes 9 letters, but never has 5 letters. Just a hint: I didn''t ask a question.', '2016-02-01 12:59:59'),
  ('The female janitor at my building asked if I would chill and smoke some weed with her. I said no. I can''t deal with high maintenance women.', '2018-05-01 10:59:59'),
  ('Set your wifi password to 2444666668888888. So when someone ask tell them it''s 12345678.', '2020-07-01 12:29:59');