create table if not exists student (
    student_id bigint auto_increment primary key,
    student_name varchar(255) not null,
    parent_phone_number varchar(20),
    parent_email varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp
);
