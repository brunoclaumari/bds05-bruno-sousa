INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


INSERT INTO tb_genre (name) VALUES ('Ação');   	
INSERT INTO tb_genre (name) VALUES ('Heróis'); 	
INSERT INTO tb_genre (name) VALUES ('Fantasia');
INSERT INTO tb_genre (name) VALUES ('Comédia');	
INSERT INTO tb_genre (name) VALUES ('Drama');	
INSERT INTO tb_genre (name) VALUES ('Romântico');
INSERT INTO tb_genre (name) VALUES ('Suspense');
INSERT INTO tb_genre (name) VALUES ('Terror');	
INSERT INTO tb_genre (name) VALUES ('Documentário');
INSERT INTO tb_genre (name) VALUES ('Animação');	
INSERT INTO tb_genre (name) VALUES ('Policial');	--11


INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('sag', 'Vingadores Ultimato', 'O ultimo da Saga infinito', 'Vingadores voltam no tempo para deter o super vilão Thanos', 2019, 2);
INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gsaga', 'Capitao America 1', 'O primeiro vingador', 'olala', 2011, 2);
INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gasgas', 'Código de Conduta','-', 'Quando um homem vê sua família ser morta e a justiça permitir que os assassinos saíram ilesos, ele não tem mais nada a perder dando início a um engenhoso plano de vingança contra os assassinos e todo o sistema judiciário americano ', 2019, 11);
INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gas', 'Ace Ventura','Um detetive diferente', 'Um detetive especializado em buscas de animais é procurado para encontrar um golfinho mascote do time de futebol americano Miami Dolphins, e se mete em várias confusões', 1994, 4);
INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gfsaadsf', 'O Exterminador do Futuro 2','O julgamento final', 'Dois exterminadores voltam no tempo para encontrar o jovem John Connor, futuro líder da resistência humana. Um deles quer eliminá-lo e outro protegê-lo.... quem o encontrará primeiro?', 1991, 1);
INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gas', 'Velozes e Furiosos','Desafio em Tókio', 'Um grupo de loucos por corridas de carros lançam desafios de Drift por toda cidade de Tókio', 2009, 1);

INSERT INTO tb_movie (img_url, title, sub_title, synopsis, year, genre_id) VALUES ('gas', 'Golpe Baixo','-', 'Um ex jogador é preso por dirigir bêbado e é forçado a treinar um time de futebol americano formado por presos para jogar contra os guardas da prisão, mas nessa aventura ele acaba gostando da ideia e monta um time para ser o vencedor da partida', 2005, 4);






