--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(1, 'mkyong','111@yahoo.com', TO_DATE('2017-02-11', 'yyyy-mm-dd'));
--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(2,'yflow','222@yahoo.com', TO_DATE('2017-02-12', 'yyyy-mm-dd'));
--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(3,'zilap','333@yahoo.com', TO_DATE('2017-02-13', 'yyyy-mm-dd'));
INSERT INTO "MARCHE" (ID, DESCRIPTION_MARCHE, INTITULE_MARCHE) VALUES ('20', 'Banque Transactionnelle', 'BT');
INSERT INTO "MARCHE" (ID, DESCRIPTION_MARCHE, INTITULE_MARCHE) VALUES ('10', 'Banque des professionnels et personnels', 'B2P');
INSERT INTO "PRODUIT" (ID, DESCRIPTION_PRODUIT, INTITUTE_PRODUIT, MARCHE_ID) VALUES ('144', 'DESCRIPTION-PROD1', 'PROD1', '10');
INSERT INTO "PRODUIT" (ID, DESCRIPTION_PRODUIT, INTITUTE_PRODUIT, MARCHE_ID) VALUES ('155', 'DESCRIPTION-PROD2', 'PROD2', '10');
