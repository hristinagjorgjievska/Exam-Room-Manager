INSERT INTO professors (username, password, full_name, email, professor_role)
VALUES ('sasho_gramatikov', 'sasho_gramatikov_123', 'Сашо Граматиков', 'sasho.gramatikov@finki.ukim.mk', 'ROLE_PROFESSOR'),
       ('dimitar_trajanov', 'dimitar_trajanov_123', 'Димитар Трајанов', 'dimitar.trajanov@finki.ukim.mk', 'ROLE_PROFESSOR'),
       ('riste_stojanov', 'riste_stojanov_123', 'Ристе Стојанов', 'riste.stojanov@finki.ukim.mk', 'ROLE_PROFESSOR'),
       ('kostadin_mishev', 'kostadin_mishev_123', 'Костадин Мишев', 'kostadin.mishev@finki.ukim.mk', 'ROLE_PROFESSOR'),
       ('ana_todorovska', 'ana_todorovska_123', 'Ана Тодоровска', 'ana.todorovska@finki.ukim.mk', 'ROLE_ASSISTANT_PROFESSOR'),
       ('elena_atanasoska', 'elena_atanasoska_123', 'Елена Атанасоска', 'elena.atanasoska@finki.ukim.mk', 'ROLE_ASSISTANT_PROFESSOR'),
       ('darko_sasanski', 'darko_sasanski_123', 'Дарко Сасански', 'darko.sasanski@finki.ukim.mk', 'ROLE_ASSISTANT_PROFESSOR');

INSERT INTO subjects (name, code, professor_id)
VALUES ('Веб Програмирање', 'F23L3W024', 1),
       ('Веб Програмирање', 'F23L3W024', 2),
       ('Веб Програмирање', 'F23L3W024', 3),
       ('Веб Програмирање', 'F23L3W024', 4),
       ('Веб Програмирање', 'F23L3W024', 5),
       ('Веб Програмирање', 'F23L3W024',6),
       ('Веб Програмирање', 'F23L3W024', 7),
       ('Оперативни Системи', 'F23L2S017', 1),
       ('Архитектура и организација на компјутери', 'F23L1S003', 1),
       ('Електронска и мобилна трговија', 'F23L3S025', 1);

INSERT INTO classrooms (name, capacity, computer_availability)
VALUES ('Lab-2', 20, 'WITH_COMPUTERS'),
       ('Lab-3', 20, 'WITH_COMPUTERS'),
       ('Lab-12', 40, 'WITH_COMPUTERS'),
       ('Lab-13', 40, 'WITH_COMPUTERS'),
       ('Lab-138', 40, 'WITH_COMPUTERS'),
       ('Lab-215', 40, 'WITH_COMPUTERS'),
       ('Lab-200AB', 40, 'WITH_COMPUTERS'),
       ('Lab-200C', 20, 'WITH_COMPUTERS'),
       ('Lab-117', 120, 'WITH_COMPUTERS'),
       ('Lab-315', 120, 'WITHOUT_COMPUTERS'),
       ('B-1', 100, 'WITHOUT_COMPUTERS'),
       ('B-2.2', 120, 'WITHOUT_COMPUTERS'),
       ('B-3.2', 120, 'WITHOUT_COMPUTERS'),
       ('FINKI-BIG-AMPHITHEATRE', 300, 'WITHOUT_COMPUTERS'),
       ('MF-AMPHITHEATRE', 120, 'WITHOUT_COMPUTERS');