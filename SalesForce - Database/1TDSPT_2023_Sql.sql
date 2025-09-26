/* Integrantes e turma:
- Maria Beatriz RM552669 1TDSPT
- Igor Marcondes RM553544 1TDSPT
- Nicholas Pereira RM552744 1TDSPT
*/


--Verificando com o drop tabelas existentes, utilizando cascade para n�o ter interfer�ncias
drop table Usuario cascade constraints;
drop table Empresa cascade constraints;
drop table Funcionario cascade constraints; 
drop table Licenca cascade constraints;
drop table Menu_produtos cascade constraints;
drop table trailFinder cascade constraints;
drop table Chatbot cascade constraints;
drop table Agente cascade constraints;
    
    
--Cria��o da tabela que representa a entidade Empresa
create table Empresa(cnpj char(14) constraint Empresa_cnpj primary key,
                     nome varchar(20) constraint Empresa_nome_nn not null
                                          constraint Empresa_nome_uk unique,
                     razao_social varchar(80) constraint Empresa_razao_n null,
                     assinatura char(5) constraint Empresa_assinatura_nn not null,
                     atuacao varchar(30) constraint Empresa_atuacao_nn not null,
                     cod_atuacao char(2) constraint Empresa_cod_atuacao_nn not null
);
    
    --Cria��o da tabela que representa a entidade Funcionario
create table Funcionario(func_id char(5) constraint func_id_nn not null,
                         func_cpf char(11) constraint func_cpf_pk primary key,
                         func_nome varchar(20) constraint func_nome_nn not null,    
                         func_sobrenome varchar(30) constraint func_sobre_nn not null,
                         func_tel number(11) constraint func_tel_n null,
                         func_salario number(8,2) constraint func_salario_nn not null,
                         fk_empresa char(14) constraint fk_funcionario_empresa references Empresa
                                        constraint fk_funcionario_empresa_nn not null
);
    
--Cria��o da tabela que representa a entidade Licenca
create table Licenca(contrato_licenca char(5) constraint licenca_contrato_pk primary key,
                     tipo_licenca char(1) constraint licenca_type_nn not null,
                     nome_licenca varchar(25) constraint licenca_nome_nn not null,
                     tipo_venc varchar(15) constraint licenca_tipo_venc_nn not null,
                     expira date constraint Licenca_date_expiracao not null,
                     fk_empresa constraint fk_licenca_empresa references Empresa
);
            
--Cria��o da tabela que representa a entidade Menu_produtos
create table Menu_produtos(fk_licenca constraint fk_menu_licenca references Licenca
                                            constraint fk_menu_licenca_nn not null
                                            constraint fk_menu_licenca_pk primary key,
                            produtos_sales char(2) constraint menu_produtos_sales_nn not null,
                            servicos_sales varchar(20) constraint menu_servicos_nn not null,
                            categoria varchar(25) constraint menu_categoria_nn not null,
                            planos char(1) constraint menu_planos_nn not null                        
);                              
    
--Cria��o da tabela que representa a entidade Trail_Finder
create table trailFinder(fk_menu constraint fk_trail_menu references Menu_Produtos,
                          industrias_trail varchar(25) constraint trail_industrias_nn not null,
                          tamanho_trail char(1) constraint trail_tamanho_nn not null
                        
);
    
--Cria��o da tabela que representa a entidade Chatbot
create table Chatbot(duvida_chat varchar(150) constraint chatbot_duvida_nn not null,
                     id_duvida char(3) constraint chatbot_id_duvida_pk primary key,
                     data_chat date constraint chatbot_data_nn not null,
                     resposta_chat varchar(150) constraint chatbot_resposta_nn not null
);
    
--Cria��o da tabela que representa a entidade Agente
create table Agente( id_agente char(3) constraint agente_id_pk primary key,
                     contato_encaminha number(11) constraint agente_contato_uk unique,
                     data_encaminha date constraint agente_data_nn not null,
                     resolucao_encaminha varchar(200) constraint agente_resolucao_nn not null,
                     fk_chatbot constraint fk_agente_chatbot references Chatbot
);
    --Cria��o da tabela que representa a entidade Usu�rio
create table Usuario(id_user number(5) constraint user_id_pk primary key,
                     acesso_user date constraint user_acesso_nn  not null,
                     nome_user varchar(30) constraint user_nome_nn not null,
                     email_user varchar(30) constraint user_email_nn not null,
                     senha_user varchar(20) constraint user_senha_nn not null,
                     tel_user number(11) constraint user_tel_n null,
                     fk_menu constraint fk_user_menu references Menu_Produtos,
                     fk_chatbot constraint fk_user_chatbot references Chatbot
);

--Inser��o de dados na tabela Empresa
INSERT INTO Empresa VALUES (LPAD('01080512000178', 14, '0'), 'SALESFORCE', 'SALESFORCE TECNOLOGIA LTDA', '00000', 'Tecnologia', '13');
INSERT INTO Empresa VALUES ('16668076000553', 'SUMUP', 'SUMUP SOLU��ES DE PAGAMENTO BRASIL LTDA', '00001', 'Servi�os financeiros', '06');
INSERT INTO Empresa VALUES ('15664649000184', 'GYMPASS', 'GPBR PARTICIPA��ES LTDA.', '00002', 'Sa�de', '07');
INSERT INTO Empresa VALUES ('87870952000225', 'VIPAL BORRACHAS', 'BORRACHAS VIPAL S.A.', '00003', 'Manufatura', '08');
INSERT INTO Empresa VALUES ('36636489000130', 'GRUPO TIGRE', 'TIGRE INDUSTRIA E COMERCIO DE COMPOSTOS PLASTICOS LTDA', '00004', 'Constru��o Civil', '14');
INSERT INTO Empresa VALUES ('81106957000119', 'ALDO', 'DESCARBONIZE SOLUCOES SA', '00005', 'Varejo', '12');
INSERT INTO Empresa VALUES ('04740876000125', 'ALELO', 'ALELO INSTITUICAO DE PAGAMENTO SA', '00006', 'Servi�os financeiros', '06');
INSERT INTO Empresa VALUES ('03472246000588', 'AUDI DO BRASIL', 'AUDI DO BRASIL INDUSTRIA E COMERCIO DE VEICULOS LTDAA', '00007', 'Automotivo', '01');
INSERT INTO Empresa VALUES ('03007308000126', 'Natura', 'NATURA COSMETICOS S.A.', '00008', 'Bens de Consumo', '03');
INSERT INTO Empresa VALUES ('29313703000155', 'Eletrobras', 'ELETROBRAS CENTRAIS ELETRICAS BRASILEIRAS S/A', '00009', 'Energia', '05');
INSERT INTO Empresa VALUES ('08284948000101', 'Rede Globo', 'GLOBO COMUNICACAO E PARTICIPACOES S.A.', '00010', 'M�dia', '09');
COMMIT;

--Inser��o de dados na tabela Funcionario

-- Funcion�rios para a empresa SUMUP
insert into Funcionario values (000001, '12345678901', 'Joao', 'Silva', 11987654321, 3000.00, 16668076000553);
insert into Funcionario values (000002, '23456789012', 'Maria', 'Santos', 11987654322, 3500.00, 16668076000553);
insert into Funcionario values (000003, '34567890123', 'Pedro', 'Oliveira', 11987654323, 2800.00, 16668076000553);
insert into Funcionario values (000004, '45678901234', 'Ana', 'Souza', 11987654324, 3200.00, 16668076000553);
insert into Funcionario values (000005, '56789012345', 'Carlos', 'Ferreira', 11987654325, 3100.00, 16668076000553);
COMMIT;

-- Funcion�rios para a empresa GYMPASS
insert into Funcionario values (000001, '67890123456', 'Juliana', 'Martins', 11987654326, 2700.00, 15664649000184);
insert into Funcionario values (000002, '78901234567', 'Lucas', 'Lima', 11987654327, 2900.00, 15664649000184);
insert into Funcionario values (000003, '89012345678', 'Mariana', 'Almeida', 11987654328, 3200.00, 15664649000184);
insert into Funcionario values (000004, '90123456789', 'Rafael', 'Pereira', 11987654329, 3000.00, 15664649000184);
insert into Funcionario values (000005, '01234567890', 'Fernanda', 'Rocha', 11987654330, 3100.00, 15664649000184);
COMMIT;

-- Funcion�rios para a empresa VIPAL BORRACHAS
insert into Funcionario values (000001, '11223344556', 'Aline', 'Goncalves', 11987654331, 2600.00, 87870952000225);
insert into Funcionario values (000002, '22334455667', 'Marcos', 'Cunha', 11987654332, 3100.00, 87870952000225);
insert into Funcionario values (000003, '33445566778', 'Cristina', 'Mendes', 11987654333, 2800.00, 87870952000225);
insert into Funcionario values (000004, '44556677889', 'Rodrigo', 'Sousa', 11987654334, 3200.00, 87870952000225);
insert into Funcionario values (000005, '55667788990', 'Patricia', 'Costa', 11987654335, 3300.00, 87870952000225);
COMMIT;

-- Funcion�rios para a empresa GRUPO TIGRE
insert into Funcionario values (000001, '66778899011', 'Diego', 'Barbosa', 11987654336, 3400.00, 36636489000130);
insert into Funcionario values (000002, '77889901122', 'Camila', 'Fernandes', 11987654337, 3000.00, 36636489000130);
insert into Funcionario values (000003, '88990011223', 'Roberto', 'Melo', 11987654338, 3100.00, 36636489000130);
insert into Funcionario values (000004, '99001122334', 'Isabela', 'Carvalho', 11987654339, 2900.00, 36636489000130);
insert into Funcionario values (000005, '00112233445', 'Gustavo', 'Ribeiro', 11987654340, 2800.00, 36636489000130);
COMMIT;

-- Funcion�rios para a empresa ALDO
insert into Funcionario values (000001, '55448347096', 'Aline', 'Goncalves', 11987654341, 3300.00, 81106957000119);
insert into Funcionario values (000002, '27069113013', 'Marcos', 'Cunha', 11987654342, 3500.00, 81106957000119);
insert into Funcionario values (000003, '80633678040', 'Cristina', 'Mendes', 11987654343, 8265.00, 81106957000119);
insert into Funcionario values (000004, '74305570076', 'Rodrigo', 'Sousa', 11987654344, 2132.50, 81106957000119);
insert into Funcionario values (000005, '30074840061', 'Patricia', 'Costa', 11987654345, 1850.36, 81106957000119);

-- Funcion�rios para a empresa ALELO
insert into Funcionario values (000001, '37489626064', 'Joao', 'Silva', 11987654346, 3300.00,'04740876000125');
insert into Funcionario values (000002, '39541303005', 'Maria', 'Santos', 11987654347,  3500.00, '04740876000125');
insert into Funcionario values (000003, '82800054042', 'Pedro', 'Oliveira', 11987654348, 8265.00, '04740876000125');
insert into Funcionario values (000004, '07451963063', 'Ana', 'Souza', 11987654349, 2132.50, '04740876000125');
insert into Funcionario values (000005, '32026129053', 'Carlos', 'Ferreira', 11987654350, 1850.36, '04740876000125');

-- Funcion�rios para a empresa AUDI DO BRASIL
insert into Funcionario values (000001, '92856130046', 'Juliana', 'Martins', 11987654351, 4000.00, '03472246000588');
insert into Funcionario values (000002, '07208777098', 'Lucas', 'Lima', 11987654352, 4200.00, '03472246000588');
insert into Funcionario values (000003, '00837460050', 'Mariana', 'Almeida', 11987654353, 3800.00, '03472246000588');
insert into Funcionario values (000004, '44845412039', 'Rafael', 'Pereira', 11987654354, 4100.00, '03472246000588');
insert into Funcionario values (000005, '63829787014', 'Fernanda', 'Rocha', 11987654355, 3900.00, '03472246000588');
COMMIT;

-- Funcion�rios para a empresa NATURA
insert into Funcionario values (000001, '51255516003', 'Aline', 'Goncalves', 11987654356, 4500.00, '03007308000126');
insert into Funcionario values (000002, '12721688081', 'Marcos', 'Cunha', 11987654357, 4800.00, '03007308000126');
insert into Funcionario values (000003, '60731809009', 'Cristina', 'Mendes', 11987654358, 4200.00, '03007308000126');
insert into Funcionario values (000004, '72053670002', 'Rodrigo', 'Sousa', 11987654359, 4600.00, '03007308000126');
insert into Funcionario values (000005, '54938802023', 'Patricia', 'Costa', 11987654360, 4300.00, '03007308000126');
COMMIT;

-- Funcion�rios para a empresa ELETROBRAS
insert into Funcionario values (000001, '69728539070', 'Diego', 'Barbosa', 11987654361, 3200.00, 29313703000155);
insert into Funcionario values (000002, '88913121000', 'Camila', 'Fernandes', 11987654362, 3500.25, 29313703000155);
insert into Funcionario values (000003, '50232975000', 'Roberto', 'Melo', 11987654363, 3000.32, 29313703000155);
insert into Funcionario values (000004, '07316379090', 'Isabela', 'Carvalho', 11987654364, 3300.00, 29313703000155);
insert into Funcionario values (000005, '57280596002', 'Gustavo', 'Ribeiro', 11987654365, 3100.00, 29313703000155);
COMMIT;

-- Funcion�rios para a empresa Rede Globo
insert into Funcionario values (000001, '87543303000', 'Aline', 'Goncalves', 11987654366, 4000.00, '08284948000101');
insert into Funcionario values (000002, '53923431040', 'Marcos', 'Cunha', 11987654367, 4300.58, '08284948000101');
insert into Funcionario values (000003, '66038579010', 'Cristina', 'Mendes', 11987654368, 3800.00, '08284948000101');
insert into Funcionario values (000004, '89477595039', 'Rodrigo', 'Sousa', 11987654369, 4100.00, '08284948000101');
insert into Funcionario values (000005, '48009394025', 'Patricia', 'Costa', 11987654370, 3900.70, '08284948000101');
COMMIT;

--Inser��o dos dados na tabela Licenca
insert into Licenca values (00000, 4, 'Unlimited', 'Anual', '01/01/2150', '01080512000178');
insert into Licenca values (00001, 1, 'Starter','Anual','01/01/2025', 16668076000553);
insert into Licenca values (00002, 2, 'Sales Professional','Mensal', '01/06/2024', 15664649000184);
insert into Licenca values (00003, 3, 'Enterprise', 'Anual', '01/07/2024', 87870952000225);
insert into Licenca values (00004, 4, 'Unlimited','Anual', '20/04/2024', 36636489000130);
insert into Licenca values (00005, 1, 'Starter', 'Mensal','20/06/2024', 81106957000119);
insert into Licenca values (00006, 2, 'Sales Professional','Anual', '20/06/2025', '04740876000125');
insert into Licenca values (00007, 3, 'Enterprise','Anual','01/06/2024', '03472246000588');
insert into Licenca values (00008, 4, 'Unlimited','Mensal', '01/05/2024', '03007308000126');
insert into Licenca values (00009, 1, 'Starter', 'Anual', '01/05/2025', 29313703000155);
insert into Licenca values (00010, 2, 'Sales Professional', 'Mensal', '01/06/2024', '08284948000101');
COMMIT;

--Inser��o dos dados na tabela Menu_produtos
insert into Menu_produtos values (00000, '01', 'CRM', 'Gerenciamento de Cliente', 4);
insert into Menu_produtos values (00001, '06', 'Pagamentos', 'Servi�os financeiros', 1);
insert into Menu_produtos values (00002,'07', 'Assinaturas', 'Sa�de', 2);
insert into Menu_produtos values (00003,'08', 'Reciclagem', 'Manufatura', 3);
insert into Menu_produtos values (00004, '14', 'Materiais', 'Constru��o Civil', 4);
insert into Menu_produtos values (00005, '12', 'Moda', 'Varejo', 1);
insert into Menu_produtos values (00006, '06', 'Alimenta��o', 'Servi�os financeiros', 2);
insert into Menu_produtos values (00007, '01', 'Assist�ncia', 'Automotivo', 3);
insert into Menu_produtos values (00008, '03', 'Bem-estar', 'Bens de Consumo', 4);
insert into Menu_produtos values (00009, '05', 'Energia', 'Energia', 1);
insert into Menu_produtos values (00010, '09', 'Entretenimento', 'M�dia', 2);
COMMIT;

--Inser��o de dados no Trail_Finder
--O tamanho das empresas � definido da seguinte forma:
--Microempresa: 1, Pequeno porte: 2, M�dio porte: 3, Grandes empresas: 4
insert into trailFinder values (00000, 'Tecnologia', 4);
insert into trailFinder values (00001, 'Servi�os financeiros', 3);
insert into trailFinder values (00002, 'Sa�de', 3);
insert into trailFinder values (00003, 'Manufatura', 2);
insert into trailFinder values (00004, 'Constru��o Civil', 1);
insert into trailFinder values (00005, 'Varejo', 2);
insert into trailFinder values (00006, 'Servi�os financeiros', 4);
insert into trailFinder values (00007, 'Automotivo', 4);
insert into trailFinder values (00008, 'Bens de Consumo', 3);
insert into trailFinder values (00009, 'Energia', 2);
insert into trailFinder values (00010, 'M�dia', 4);
COMMIT;

-- Inserts para a tabela Chatbot
insert into Chatbot values ('default', 000, '01/01/2001', 'Salesforce � uma empresa de software de CRM.');
insert into Chatbot values ('O que � Salesforce?', 001, '02/05/2024', 'Salesforce � uma empresa de software de CRM.');
insert into Chatbot values ('Quais s�o os produtos da Salesforce?', 002, '02/05/2024', 'Salesforce oferece uma variedade de produtos, incluindo Sales Cloud, Service Cloud e Marketing Cloud.');
insert into Chatbot values ('Como Salesforce pode ajudar minha empresa?',003, '02/05/2024', 'Salesforce pode ajudar a melhorar o relacionamento com os clientes, aumentar as vendas e otimizar processos de neg�cios.');
insert into Chatbot values ('Qual � a hist�ria da Salesforce?',004, '02/05/2024','Salesforce foi fundada em 1999 por Marc Benioff e Parker Harris em San Francisco, Calif�rnia.');
insert into Chatbot values ('Por que escolher Salesforce?', 005, '02/05/2024', 'Salesforce � uma escolha popular devido � sua facilidade de uso, flexibilidade e capacidade de personaliza��o.');
insert into Chatbot values ('Como posso aprender mais sobre Salesforce?',006, '02/05/2024', 'Voc� pode aprender mais sobre Salesforce atrav�s de cursos online, documenta��o oficial e comunidades de usu�rios.');
insert into Chatbot values ('Qual � a vis�o da Salesforce?', 007, '02/05/2024', 'A vis�o da Salesforce � criar um mundo mais conectado, usando tecnologia para melhorar a vida das pessoas.');
COMMIT;

-- Inserts para a tabela Agente
insert into Agente values ('001', 11987654321, '02/05/2024', 'Resolu��o da d�vida 1', 001);
insert into Agente values ('002', 11987654322, '02/05/2024', 'Resolu��o da d�vida 2', 002);
insert into Agente values ('003', 11987654323, '02/05/2024', 'Resolu��o da d�vida 3', 003);
insert into Agente values ('004', 11987654324, '02/05/2024', 'Resolu��o da d�vida 4', 004);
insert into Agente values ('005', 11987654325, '02/05/2024', 'Resolu��o da d�vida 5', 005);
insert into Agente values ('006', 11987654326, '02/05/2024', 'Resolu��o da d�vida 6', 006);
insert into Agente values ('007', 11987654327, '02/05/2024', 'Resolu��o da d�vida 7', 007);
COMMIT;

-- Inserts para a tabela Usuario
insert into Usuario values (1, '02/05/2024', 'Jo�o', 'joao@email.com', 'senha123', 11987654321, 00000, 001);
insert into Usuario values (2, '02/05/2024', 'Maria', 'maria@email.com', 'senha456', 11987654322, 00000, 002);
insert into Usuario values (3, '02/05/2024', 'Pedro', 'pedro@email.com', 'senha789', 11987654323, 000000, 003);
insert into Usuario values (4, '02/05/2024', 'Ana', 'ana@email.com', 'senhaabc', 11987654324, 000000, 004);
insert into Usuario values (5, '02/05/2024', 'Carlos', 'carlos@email.com', 'senhaxyz', 11987654325, 00000, 005);
insert into Usuario values (6, '02/05/2024', 'Juliana', 'juliana@email.com', 'senha123', 11987654326, 00000, 006);
insert into Usuario values (7, '02/05/2024', 'Lucas', 'lucas@email.com', 'senha456', 11987654327, 00000, 007);
COMMIT;

-- Exemplos de UPDATE para a tabela Empresa
UPDATE Empresa SET nome = 'Salesforce Inc.' WHERE cnpj = 1080512000178;
UPDATE Empresa SET razao_social = 'Nova Raz�o Social' WHERE cnpj = '16668076000553';
UPDATE Empresa SET cod_atuacao = '10' WHERE cnpj = '15664649000184';

-- Exemplos de DELETE para a tabela Empresa,Licenca, Menu_produtos, Trail_finder e Funcionario
alter table Funcionario drop constraint FK_FUNCIONARIO_EMPRESA;
alter table Licenca drop constraint FK_licenca_EMPRESA;
alter table Menu_produtos drop constraint fk_menu_licenca;
alter table trailFinder drop constraint fk_trail_menu;
DELETE FROM Empresa WHERE cnpj = '36636489000130';
DELETE FROM Empresa WHERE cnpj = '81106957000119';
DELETE FROM Empresa WHERE cnpj = '08284948000101';
DELETE FROM Funcionario WHERE fk_empresa = '36636489000130';
DELETE FROM Funcionario WHERE fk_empresa = '81106957000119';
DELETE FROM Funcionario WHERE fk_empresa = '08284948000101';
DELETE FROM Licenca WHERE fk_empresa = '36636489000130';
DELETE FROM Licenca WHERE fk_empresa = '81106957000119';
DELETE FROM Licenca WHERE fk_empresa = '08284948000101';
DELETE FROM Menu_produtos where fk_licenca = 00004;
DELETE FROM Menu_produtos where fk_licenca = 00005;
DELETE FROM Menu_produtos where fk_licenca = 00010;
DELETE FROM trailFinder where fk_menu = 4;
DELETE FROM trailFinder where fk_menu = 5;
DELETE FROM trailFinder where fk_menu = 10;


ALTER TABLE Funcionario ADD CONSTRAINT fk_funcionario_empresa FOREIGN KEY (fk_empresa) REFERENCES Empresa(cnpj);
ALTER TABLE Licenca ADD CONSTRAINT  fk_licenca_empresa FOREIGN KEY (fk_empresa) REFERENCES Empresa(cnpj);
ALTER TABLE Menu_produtos ADD CONSTRAINT fk_menu_licenca FOREIGN KEY (fk_licenca) REFERENCES Licenca(contrato_licenca);
ALTER TABLE trailFinder ADD CONSTRAINT fk_trail_menu FOREIGN KEY (fk_menu) REFERENCES Menu_produtos(fk_licenca);
COMMIT;

-- Exemplos de UPDATE para a tabela Funcionario
UPDATE Funcionario SET func_tel = 11987654321 WHERE func_cpf = '12345678901';
UPDATE Funcionario SET func_sobrenome = 'Novo Sobrenome' WHERE func_cpf = '23456789012';
UPDATE Funcionario SET fk_empresa = '01080512000178' WHERE func_cpf = '34567890123';

-- Exemplos de DELETE para a tabela Funcionario
DELETE FROM Funcionario WHERE func_cpf = '12345678901';
DELETE FROM Funcionario WHERE func_cpf = '55667788990';
DELETE FROM Funcionario WHERE func_cpf = '07316379090';

-- Exemplos de UPDATE para a tabela Licenca
UPDATE Licenca SET expira = '01/01/2200' WHERE contrato_licenca = 00000;
UPDATE Licenca SET tipo_venc = 'Mensal' WHERE contrato_licenca = 00001;
UPDATE Licenca SET tipo_licenca = '2' WHERE contrato_licenca = 00002;

-- Exemplos de UPDATE para a tabela Menu_produtos
UPDATE Menu_produtos SET categoria = 'Nova Categoria' WHERE fk_licenca = 00000;
UPDATE Menu_produtos SET planos = '3' WHERE fk_licenca = 00001;
UPDATE Menu_produtos SET servicos_sales = 'Novo Servi�o' WHERE fk_licenca = 00002;

-- Exemplos de UPDATE para a tabela Trail_Finder
UPDATE trailFinder SET tamanho_trail = '3' WHERE fk_menu = '0';
UPDATE trailFinder SET industrias_trail = 'Nova Ind�stria' WHERE fk_menu = '1';
UPDATE trailFinder SET tamanho_trail = '4' WHERE fk_menu = '2';

-- Exemplos de UPDATE para a tabela Chatbot
UPDATE Chatbot SET resposta_chat = 'Nova resposta' WHERE duvida_chat = 'default';
UPDATE Chatbot SET data_chat = '03/05/2024' WHERE id_duvida = '1';
UPDATE Chatbot SET resposta_chat = 'Resposta' WHERE id_duvida = '2';

-- Exemplos de DELETE para a tabela Chatbot, Usuario, Agente
alter table Usuario drop constraint fk_user_chatbot;
alter table Agente drop constraint fk_agente_chatbot;
DELETE FROM Chatbot WHERE id_duvida = '5';
DELETE FROM Chatbot WHERE id_duvida = '6';
DELETE FROM Chatbot WHERE id_duvida = '7';
DELETE FROM Usuario where fk_chatbot = '5';
DELETE FROM Usuario where fk_chatbot = '6';
DELETE FROM Usuario where fk_chatbot = '7';
DELETE FROM Agente where fk_chatbot = '5';
DELETE FROM Agente where fk_chatbot = '6';
DELETE FROM Agente where fk_chatbot = '7';

ALTER TABLE Usuario ADD CONSTRAINT fk_user_chatbot FOREIGN KEY (fk_chatbot) REFERENCES Chatbot(id_duvida);
ALTER TABLE Agente ADD CONSTRAINT fk_agente_chatbot FOREIGN KEY (fk_chatbot) REFERENCES Chatbot(id_duvida);
COMMIT;

-- Exemplos de UPDATE para a tabela Agente
UPDATE Agente SET id_agente = 000 WHERE id_agente = '001';
UPDATE Agente SET data_encaminha = '03/05/2024' WHERE id_agente = '002';
UPDATE Agente SET resolucao_encaminha = 'Nova resolu��o' WHERE fk_chatbot = '3';

-- Exemplos de UPDATE para a tabela Usuario
UPDATE Usuario SET nome_user = 'Novo Nome' WHERE id_user = 1;
UPDATE Usuario SET email_user = 'novo@email.com' WHERE id_user = 2;
UPDATE Usuario SET senha_user = 'nova_senha' WHERE id_user = 3;
COMMIT;

--Gera��o de relat�rios
select nome "Empresa", cnpj "CNPJ", atuacao "Ramo" from Empresa order by 1;
select func_nome "Nome", func_salario "Sal�rio", fk_empresa "CNPJ da Empresa" from Funcionario where func_salario > 3500 order by 2, 1;
select tamanho_trail, count(tamanho_trail) from trailFinder group by tamanho_trail;
select max(func_salario), min(func_salario), sum(func_salario) from Funcionario;

SELECT nome "Empresa", COUNT(func_id) "Quantidade de funcion�rios" FROM Empresa
LEFT JOIN Funcionario ON cnpj = fk_empresa GROUP BY nome;

SELECT nome AS "Empresa", COUNT(func_id) AS "Quantidade de funcion�rios" FROM Empresa
LEFT JOIN Funcionario ON cnpj = fk_empresa
GROUP BY nome HAVING COUNT(func_id) > 3;

SELECT nome "Empresa", sum(func_salario) "Total de sal�rios" FROM Empresa
LEFT JOIN Funcionario ON cnpj = fk_empresa GROUP BY nome;
COMMIT;