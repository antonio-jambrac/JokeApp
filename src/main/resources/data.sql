INSERT INTO Category (id, name)
VALUES (default, 'crni humor'), (default, 'sarkasticne'), (default, 'vulgarne');

INSERT INTO Joke (id, content, category)
VALUES (default, 'test 1', 1), (default, 'test 2', 1), (default, 'test 3', 2), (default, 'test 4', 3),
(default, 'test 5', 2);
