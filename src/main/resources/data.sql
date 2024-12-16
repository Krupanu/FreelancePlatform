INSERT INTO freelance_platform.user
VALUES (1,'2024-12-14 16:46:23','user@test.com','User','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','FREELANCER'),
       (2,'2024-12-14 16:46:23','customer@test.com','Customer','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','EMPLOYEE');

INSERT INTO freelance_platform.order
VALUES (1,'2024-12-14 16:46:23','test_description',1, 'IN_PROGRESS','test_title', 2),
       (2,'2024-12-14 16:46:23','test_description 2',1, 'IN_PROGRESS','test_title 2', 2),
       (3,'2024-12-14 16:46:23','test_description 3',1, 'APPROVED','test_title 3', 2),
       (4,'2024-12-14 16:46:23','test_description 4',1, 'DECLINED','test_title 3', 2);

INSERT INTO freelance_platform.application
VALUES(1,'2024-12-14 16:46:23', 'IN_PROGRESS',1,1),
      (2,'2024-12-14 16:46:23','IN_PROGRESS',2,1),
      (3,'2024-12-14 16:46:23','IN_PROGRESS',2,2),
      (4,'2024-12-14 16:46:23','DECLINED',1,2);

INSERT INTO freelance_platform.contact_details
VALUES (1,'2024-12-14 16:46:23','user@test.com', '+37512345678',1),
       (2,'2024-12-14 16:46:23','customer@test.com', '+2759012345',2);

INSERT INTO freelance_platform.skills
VALUES (1,'2024-12-14 16:46:23','TestTitle');

INSERT INTO freelance_platform.user_profile
VALUES (1,'TestBio', 'TestCompanyName', 5,2);

INSERT INTO freelance_platform.user_skills
VALUES (1,'2024-12-14 16:46:23',1,1);