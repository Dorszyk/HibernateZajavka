create table pet_toy
(
    pet_toy_id serial not null,
    pet_id int not null,
    toy_id int not null,
    constraint fk_pet_toy_pet
        foreign key (pet_id)
            references pet (pet_id),
    constraint fk_pet_toy_toy
        foreign key (toy_id)
            references toy(toy_id)
);