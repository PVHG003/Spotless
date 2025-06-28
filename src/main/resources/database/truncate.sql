BEGIN;

TRUNCATE contributors,
    genres,
    permissions,
    playlist_songs,
    playlists,
    regular_users,
    role_permissions,
    roles,
    song_contributors,
    song_genres,
    songs,
    user_favorite_songs,
    users CASCADE;

COMMIT;

DROP TABLE contributors,
genres,
permissions,
playlist_songs,
playlists,
regular_users,
role_permissions,
roles,
song_contributors,
song_genres,
songs,
user_favorite_songs,
users;
