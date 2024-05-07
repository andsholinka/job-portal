INSERT INTO public.application_user(id, email, name, password, username) 
VALUES 
    ('8a53cadc-3a2b-4ccd-853d-8283e41c4bbc', 'andrey@gmail.com', 'Andrey', '$2a$12$r0yPInFmaCP5738Exnv6k.A4JfdhMRhNUyDAFRADa2nIEJ0brIh7W', 'andrey'),
    ('211fa1fa-de4b-45f9-9e32-7a7ed7ef3d42', 'barra@gmail.com', 'Barra', '$2a$12$r0yPInFmaCP5738Exnv6k.A4JfdhMRhNUyDAFRADa2nIEJ0brIh7W', 'barra'),
    ('0e4c9b23-38e6-4d68-aeef-295142d6cc56', 'john@gmail.com', 'John', '$2a$12$r0yPInFmaCP5738Exnv6k.A4JfdhMRhNUyDAFRADa2nIEJ0brIh7W', 'john');


INSERT INTO public.employer(id, application_user_id, company, email, name) 
VALUES 
    (99, '8a53cadc-3a2b-4ccd-853d-8283e41c4bbc', 'PT Mencari Cinta Sejati', 'andrey@gmail.com', 'Andrey'),
    (100, '0e4c9b23-38e6-4d68-aeef-295142d6cc56', 'PT Cari Jodoh Bahagia', 'john@gmail.com', 'John');


INSERT INTO public.job_posting(employer_id, id, description, job_status, salary, title, type, company)
VALUES 
	(99, 99, 'Java Spring Boot with minimum 3 years of experience', 'DRAFT', '15.000.000', 'Backend Developer', 'FULL_TIME', 'PT Mencari Cinta Sejati'),
	(100, 100, 'React with minimum 3 years of experience', 'PUBLISHED', '15.000.000', 'Frontend Developer', 'FULL_TIME', 'PT Cari Jodoh Bahagia');


INSERT INTO public.freelancer(id, application_user_id, email, name)
	VALUES (98, '211fa1fa-de4b-45f9-9e32-7a7ed7ef3d42', 'barra@gmail.com', 'Barra');