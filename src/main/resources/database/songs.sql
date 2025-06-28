insert into genres (name)
values
    ('Pop'),
    ('Rock'),
    ('Jazz'),
    ('Hip-Hop');

insert into artists (id, full_name, created_date, last_modified_date)
values
    (gen_random_uuid(), 'John Doe', now(), now()),
    (gen_random_uuid(), 'The Jazz Band', now(), now()),
    (gen_random_uuid(), 'DJ Example', now(), now());

insert into images (id, created_date, last_modified_date, length, size, type, url, width)
values
    (gen_random_uuid(), now(), now(), 500, 204800, 'image/png', 'https://example.com/john_doe.png', 500),
    (gen_random_uuid(), now(), now(), 600, 304800, 'image/jpeg', 'https://example.com/jazz_band.jpg', 600),
    (gen_random_uuid(), now(), now(), 400, 104800, 'image/png', 'https://example.com/dj_example.png', 400),
    (gen_random_uuid(), now(), now(), 800, 504800, 'image/jpeg', 'https://example.com/song_cover1.jpg', 800),
    (gen_random_uuid(), now(), now(), 700, 454800, 'image/jpeg', 'https://example.com/song_cover2.jpg', 700);

insert into artist_images (artist_id, image_id)
values
    (
        (select id from artists where full_name = 'John Doe'),
        (select id from images where url = 'https://example.com/john_doe.png')
    ),
    (
        (select id from artists where full_name = 'The Jazz Band'),
        (select id from images where url = 'https://example.com/jazz_band.jpg')
    ),
    (
        (select id from artists where full_name = 'DJ Example'),
        (select id from images where url = 'https://example.com/dj_example.png')
    );

insert into songs (id, created_date, last_modified_date, audio_url, duration, listen_count, release_date, song_cover, title, artist_id)
values
    (
        gen_random_uuid(), now(), now(),
        'https://example.com/audio1.mp3',
        210, 0, '2023-01-01',
        'https://example.com/song_cover1.jpg',
        'First Hit',
        (select id from artists where full_name = 'John Doe')
    ),
    (
        gen_random_uuid(), now(), now(),
        'https://example.com/audio2.mp3',
        180, 0, '2023-03-15',
        'https://example.com/song_cover2.jpg',
        'Jazz Vibes',
        (select id from artists where full_name = 'The Jazz Band')
    );

insert into song_images (song_id, image_id)
values
    (
        (select id from songs where title = 'First Hit'),
        (select id from images where url = 'https://example.com/song_cover1.jpg')
    ),
    (
        (select id from songs where title = 'Jazz Vibes'),
        (select id from images where url = 'https://example.com/song_cover2.jpg')
    );

insert into song_genres (song_id, genre_id)
values
    (
        (select id from songs where title = 'First Hit'),
        (select id from genres where name = 'Pop')
    ),
    (
        (select id from songs where title = 'Jazz Vibes'),
        (select id from genres where name = 'Jazz')
    );
