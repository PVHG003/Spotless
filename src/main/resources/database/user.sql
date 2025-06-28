-- password = $2a$12$zVlPpmcxHDDbc6xaTzSBbOzAqamTY5OeOhA80Etpeb5VGys30ODUu

insert into users (id, created_date, last_modified_date, email, password, role_id)
values (gen_random_uuid(), now(), now(), 'user1@example.com',
        '$2a$12$zVlPpmcxHDDbc6xaTzSBbOzAqamTY5OeOhA80Etpeb5VGys30ODUu',
        (select id from roles where name = 'USER')),
       (gen_random_uuid(), now(), now(), 'admin@example.com',
        '$2a$12$zVlPpmcxHDDbc6xaTzSBbOzAqamTY5OeOhA80Etpeb5VGys30ODUu',
        (select id from roles where name = 'ADMIN')),
       (gen_random_uuid(), now(), now(), 'superuser@example.com',
        '$2a$12$zVlPpmcxHDDbc6xaTzSBbOzAqamTY5OeOhA80Etpeb5VGys30ODUu',
        (select id from roles where name = 'SUPERUSER'));

insert into user_favorite_songs (regular_user_id, song_id)
values ();