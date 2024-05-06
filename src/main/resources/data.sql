INSERT INTO public.application_user(
	id, email, name, password, username)
	VALUES ('8a53cadc-3a2b-4ccd-853d-8283e41c4bbc', 'andrey@gmail.com', 'Andrey', '$2a$12$r0yPInFmaCP5738Exnv6k.A4JfdhMRhNUyDAFRADa2nIEJ0brIh7W', 'andrey');


INSERT INTO public.employer(
	id, application_user_id, company, email, name)
	VALUES (1, '8a53cadc-3a2b-4ccd-853d-8283e41c4bbc', 'PT Mencari Cinta Sejati', 'andrey@gmail.com', 'Andrey');