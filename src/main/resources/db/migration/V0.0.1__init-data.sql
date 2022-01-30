create table utilisateur
(
    id bigint not null constraint utilisateur_pk primary key,
    role varchar(255),
    login varchar(255),
    password varchar(255),
    nom varchar(255),
    prenom varchar(255)
);

alter table utilisateur owner to postgres;
