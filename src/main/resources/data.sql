INSERT INTO genres (genre_name) VALUES ('��������');
INSERT INTO genres (genre_name) VALUES ('�����');
INSERT INTO genres (genre_name) VALUES ('�����');
INSERT INTO genres (genre_name) VALUES ('������');
INSERT INTO genres (genre_name) VALUES ('�������');

INSERT INTO authors (author_name) VALUES ('�.������');
INSERT INTO authors (author_name) VALUES ('�.�������');
INSERT INTO authors (author_name) VALUES ('�.�����������');
INSERT INTO authors (author_name) VALUES ('�.�������');

INSERT INTO books (title, genre_id)
VALUES ('��������� ��������', (SELECT id FROM genres WHERE genre_name = '��������'));

INSERT INTO books (title, genre_id)
VALUES ('����� � ���', (SELECT id FROM genres WHERE genre_name = '�����'));

INSERT INTO books (title, genre_id)
VALUES ('������������ � ���������', (SELECT id FROM genres WHERE genre_name = '�����'));

INSERT INTO books (title, genre_id)
VALUES ('Generation �', (SELECT id FROM genres WHERE genre_name = '������'));

INSERT INTO books (title, genre_id)
VALUES ('�����', (SELECT id FROM genres WHERE genre_name = '�����'));

INSERT INTO books (title, genre_id)
VALUES ('����� � ������������', (SELECT id FROM genres WHERE genre_name = '��������'));

INSERT INTO books (title)
VALUES ('����� � ������������2');


INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.������'),
  (SELECT id FROM books WHERE title = '��������� ��������'));

INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.�������'),
  (SELECT id FROM books WHERE title = '����� � ���')
);

INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.�����������'),
  (SELECT id FROM books WHERE title = '������������ � ���������')
);

INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.�������'),
  (SELECT id FROM books WHERE title = 'Generation �')
);

INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.�����������'),
  (SELECT id FROM books WHERE title = '����� � ������������')
);

INSERT INTO books_authors (authors_id, books_id)
VALUES (
  (SELECT id FROM authors WHERE author_name = '�.�������'),
  (SELECT id FROM books WHERE title = '����� � ������������')
);


# INSERT INTO books_authors (authors_id, books_id)
# VALUES (
#            (SELECT id FROM authors WHERE author_name = '�.�����������'),
#            (SELECT id FROM books WHERE title = '�����')
#        );
