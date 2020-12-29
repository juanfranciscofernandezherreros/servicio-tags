INSERT INTO languages(clave,iso2,iso3) VALUES('es','es-es','esp');
INSERT INTO tags(clave) VALUES('tag1');
INSERT INTO tagstranslation(name_tags_translated,language_id,tags_id,slug) VALUES('Paseito',1,1,'tag1');
INSERT INTO tags(clave) VALUES('tag2');
INSERT INTO tagstranslation(name_tags_translated,language_id,tags_id,slug) VALUES('Rutilla',1,2,'tag2');
INSERT INTO tags(clave) VALUES('tag3');
INSERT INTO tagstranslation(name_tags_translated,language_id,tags_id,slug) VALUES('Ciclismo',1,3,'tag3');