create table book
(
    id     serial,
    author varchar,
    title  varchar,
    page_number int not null default 0,
    release_date date,
    primary key (id),
    FOREIGN KEY(author) REFERENCES author(name)
    )

create table book_categories(
    book_entity_id int,
    categories_id int,
    FOREIGN KEY (book_entity_id) REFERENCES book(id),
    FOREIGN KEY (categories_id) REFERENCES category(id)
);