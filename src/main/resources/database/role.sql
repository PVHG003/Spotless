-- Insert roles
insert into roles (name)
values ('SUPERUSER'),
       ('ADMIN'),
       ('USER');

-- Insert permissions
insert into permissions (name)
values ('MANAGE_USERS'),
       ('MANAGE_SONGS'),
       ('MANAGE_PROFILE');

-- SUPERUSER: gets all permissions
insert into role_permissions (role_id, permission_id)
select r.id, p.id
from roles r
         cross join permissions p
where r.name = 'SUPERUSER';

-- ADMIN: only MANAGE_USERS and MANAGE_SONGS
insert into role_permissions (role_id, permission_id)
select r.id, p.id
from roles r
         join permissions p on p.name in ('MANAGE_USERS', 'MANAGE_SONGS')
where r.name = 'ADMIN';

-- USER: only MANAGE_PROFILE
insert into role_permissions (role_id, permission_id)
select r.id, p.id
from roles r
         join permissions p on p.name = 'MANAGE_PROFILE'
where r.name = 'USER';
