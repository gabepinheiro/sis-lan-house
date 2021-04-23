DROP DATABASE IF EXISTS lanhouse;
CREATE DATABASE lanhouse
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE lanhouse;

CREATE TABLE `lanhouse`.`cliente` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `cpf` VARCHAR(14) NOT NULL,
    `nome` VARCHAR(30) NOT NULL,
    `sobrenome` VARCHAR(30) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `genero` ENUM('F', 'M') NOT NULL,
    `telefone` VARCHAR(14),
    `celular` VARCHAR(15) NOT NULL,
    `dataCadastro` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `desativado` BOOL NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`id` , `cpf`),
    UNIQUE INDEX `UNIQUE_CLIENTE` (`cpf`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`usuario` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(20) NOT NULL,
    `senha` VARCHAR(30) NOT NULL,
    `cliente` int(8) not null,
    PRIMARY KEY (`id` , `login`),
    UNIQUE INDEX `UNIQUE_LOGIN` (`login`),
     CONSTRAINT `FK_USUARIOCLIENTE` FOREIGN KEY (`cliente`)
        REFERENCES `lanhouse`.`cliente` (`id`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

create table bancodehoras(
	id int auto_increment,
    usuarioId int,
    hora int,
    minuto int,
    segundo int,
    CONSTRAINT FK_Usuario FOREIGN KEY (usuarioId) REFERENCES usuario(id),
	primary key (id)
)

create table estacao(
		id int(2) AUTO_INCREMENT,
		ip varchar(255) not null,
		descricao varchar(255) not null,
		manutencao bool default false,
		UNIQUE (id),
		PRIMArY KEY(ip)
	)

CREATE TABLE `lanhouse`.`caixa` (
    `id` INT(8) NOT NULL DEFAULT 1,
    `status` ENUM('ABERTO', 'FECHADO') NOT NULL DEFAULT 'FECHADO',
    `valor` FLOAT NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`aberturaCaixa` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `data_hora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `valorAtribuido` FLOAT NOT NULL DEFAULT 0,
    `usuario` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`fechamentoCaixa` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `data_hora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `valorRetirado` FLOAT NOT NULL DEFAULT 0,
    `motivoFechamento` VARCHAR(50) NOT NULL,
    `usuario` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;


CREATE TABLE `lanhouse`.`cargo` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id` , `nome`),
    UNIQUE INDEX `UNIQUE_NOMECARGO` (`nome`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;


CREATE TABLE `lanhouse`.`fornecedor` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `cnpj` VARCHAR(18) NOT NULL,
    `nome` VARCHAR(40) NOT NULL,
    `razaoSocial` VARCHAR(40) NOT NULL,
    `cep` VARCHAR(10) NOT NULL,
    `logradouro` VARCHAR(60) NOT NULL,
    `numero` VARCHAR(10) NOT NULL,
    `complemento` VARCHAR(50) DEFAULT NULL,
    `bairro` VARCHAR(40) NOT NULL,
    `cidade` VARCHAR(30) NOT NULL,
    `estado` CHAR(2) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    `telefone` VARCHAR(14),
    `celular` VARCHAR(15) NOT NULL,
    `desativado` BOOL NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`id` , `cnpj`),
    UNIQUE INDEX `UNIQUE_CNPJ` (`cnpj`),
    UNIQUE INDEX `UNIQUE_NOME` (`nome`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`tipoEquipamento` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `tipo` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UNIQUE` (`tipo`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;


CREATE TABLE `lanhouse`.`equipamento` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(30) NOT NULL,
    `valor` FLOAT NOT NULL,
    `fornecedor` INT(8) NOT NULL,
    `dataFabricacao` DATE NOT NULL,
    `garantia` INT(3) NOT NULL DEFAULT 0,
    `tipo` INT(8) NOT NULL,
    PRIMARY KEY (`id` , `descricao`),
    UNIQUE INDEX `UNIQUE_DESCEQUIPAMENTO` (`descricao`),
    CONSTRAINT `FK_FORNECEDOREQUIP` FOREIGN KEY (`fornecedor`)
        REFERENCES `lanhouse`.`fornecedor` (`id`),
    CONSTRAINT `FK_TIPOEQUIP` FOREIGN KEY (`tipo`)
        REFERENCES `lanhouse`.`tipoEquipamento` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;




CREATE TABLE `lanhouse`.`login` (
    `id` INT(8) NOT NULL DEFAULT 1,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `usuario` INT(8) NOT NULL,
    `estacao` int(8) not null,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_USUARIOLOGIN` FOREIGN KEY (`usuario`)
        REFERENCES `lanhouse`.`usuario` (`id`),
	CONSTRAINT `FK_ESTACAOLOGIN` FOREIGN KEY (`estacao`)
        REFERENCES `lanhouse`.`estacao` (`id`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`logout` (
    `id` INT(8) NOT NULL DEFAULT 1,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `usuario` INT(8) NOT NULL,
    `estacao` int(8) not null,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_USUARIOLOGOUT` FOREIGN KEY (`usuario`)
        REFERENCES `lanhouse`.`usuario` (`id`),
	CONSTRAINT `FK_ESTACAOLOGOUT` FOREIGN KEY (`estacao`)
        REFERENCES `lanhouse`.`estacao` (`id`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`estoqueEquipamento` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `equipamento` INT(8) NOT NULL,
    `quantidade` INT(8) NOT NULL,
    `dataEntrada` DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id` , `equipamento`),
    UNIQUE INDEX `UNIQUE_CODEQUIPAMENTO` (`equipamento`),
    CONSTRAINT `FK_ESTOQUEEQUIPAMENTO` FOREIGN KEY (`equipamento`)
        REFERENCES `lanhouse`.`equipamento` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`equipamentoManutencao` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `equipamento` INT(8) NOT NULL,
    `quantidade` INT(8) NOT NULL,
    `dataEntrada` DATETIME DEFAULT CURRENT_TIMESTAMP,
	`defeito` varchar(30) not null,
    PRIMARY KEY (`id`, `equipamento`),
    CONSTRAINT `FK_MANUTENCAOEQUIP` FOREIGN KEY (`equipamento`)
        REFERENCES `lanhouse`.`equipamento` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`retiraequipamentoManutencao` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `equipamento` INT(8) NOT NULL,
    `quantidade` INT(8) NOT NULL,
    PRIMARY KEY (`id`, `equipamento`),
    CONSTRAINT `FK_MANUTENCAOEQUIPamento` FOREIGN KEY (`equipamento`)
        REFERENCES `lanhouse`.`equipamento` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`funcionario` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `cpf` VARCHAR(14) NOT NULL,
    `nome` VARCHAR(30) NOT NULL,
    `sobrenome` VARCHAR(30) NOT NULL,
    `dataAdmissao` DATE NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `cep` VARCHAR(10) NOT NULL,
    `logradouro` VARCHAR(40) NOT NULL,
    `numero` VARCHAR(10) NOT NULL,
    `complemento` VARCHAR(60) DEFAULT NULL,
    `bairro` VARCHAR(30) NOT NULL,
    `cidade` VARCHAR(20) NOT NULL,
    `estado` CHAR(2) NOT NULL,
    `cargo` INT(8) NOT NULL,
    `telefone` VARCHAR(14),
    `salario` FLOAT NOT NULL,
    `celular` VARCHAR(15) NOT NULL,
    `desativado` BOOL NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`id` , `cpf`),
    UNIQUE INDEX `UNIQUE_CPFFUNCIONARIO` (`cpf`),
    CONSTRAINT `FK_CARGO` FOREIGN KEY (`cargo`)
        REFERENCES `lanhouse`.`cargo` (`id`)
) CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`usuarioFuncionario` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(20) NOT NULL,
    `senha` VARCHAR(30) NOT NULL,
    `funcionario` INT(10) NOT NULL,
    PRIMARY KEY (`id` , `login`),
    CONSTRAINT `FK_LOGINCFUNC` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`),
    UNIQUE INDEX `UNIQUE_LOGIN` (`login`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`loginFuncionario` (
    `id` INT(8) auto_increment not null,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `usuario` INT(8) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_FUNCIONARIOLOGIN` FOREIGN KEY (`usuario`)
        REFERENCES `lanhouse`.`usuarioFuncionario` (`id`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`logoutFuncionario` (
    `id` INT(8) auto_increment not null,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `usuario` INT(8) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_FUNCIONARIOLOGOUT` FOREIGN KEY (`usuario`)
        REFERENCES `lanhouse`.`usuarioFuncionario` (`id`)
)  CHARSET=latin1 COLLATE = latin1_general_cs;

CREATE TABLE `lanhouse`.`servico` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(30) NOT NULL,
    `valor` FLOAT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UNIQUE_DESCSERVICO` (`descricao`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;
insert into servico(descricao, valor)
values('Aluguel', '2');

CREATE TABLE `lanhouse`.`aluguel` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `tempo` DECIMAL(5 , 3 ) NOT NULL,
    `servico` INT(8) NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_SERVICO` FOREIGN KEY (`servico`)
        REFERENCES `lanhouse`.`servico` (`id`) 
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`venda` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `total` FLOAT NOT NULL,
    `status` ENUM('PAGA', 'PENDENTE') NOT NULL DEFAULT 'PENDENTE',
    `cliente` INT(8) NOT NULL,
    `funcionario` INT(8) NOT NULL,
    `servicos` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_CLIENTEATIVIDADE` FOREIGN KEY (`cliente`)
        REFERENCES `lanhouse`.`cliente` (`id`),
    CONSTRAINT `FK_FUNCIONARIOATIVIDADE` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`compra` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `descricao` varchar(80) not null,
    `data_hora` DATETIME NOT NULL,
    `dataVencimento` DATE NOT NULL,
    `valor` FLOAT NOT NULL,
    `status` ENUM('PAGA', 'PENDENTE') NOT NULL DEFAULT 'PENDENTE',
    `fornecedor` INT(8) NOT NULL,
    `funcionario` INT(8) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_FORNECEDORCOMPRA` FOREIGN KEY (`fornecedor`)
        REFERENCES `lanhouse`.`fornecedor` (`id`),
    CONSTRAINT `FK_FUNCIONARIOCOMPRA` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;



CREATE TABLE `lanhouse`.`entradaCaixa` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `dataHora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `valor` FLOAT NOT NULL,
    `funcionario` INT(8) NOT NULL,
    `venda` INT(8) NOT NULL,
    PRIMARY KEY (`id` , `venda`),
    UNIQUE INDEX `UNIQUE_ATIVIDADE` (`venda`),
    CONSTRAINT `FK_ENTRADACAIXA` FOREIGN KEY (`venda`)
        REFERENCES `lanhouse`.`venda` (`id`),
    CONSTRAINT `FK_FUNCIONARIO` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`saidaCaixa` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `dataHora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `valor` FLOAT NOT NULL,
    `funcionario` INT(8) NOT NULL,
    `compra` INT(8) NOT NULL,
    PRIMARY KEY (`id` , `compra`),
    UNIQUE INDEX `UNIQUE_ATIVIDADE` (`compra`),
    CONSTRAINT `fk_funcSAIDA` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`),
    CONSTRAINT `FK_COMPRASAIDA` FOREIGN KEY (`compra`)
        REFERENCES `lanhouse`.`compra` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`pagamentoDivida` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `dataHora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `compra` INT(8) NOT NULL,
    `tipo` ENUM('EXTERNO', 'CAIXA') NOT NULL,
    `funcionario` INT(8) NOT NULL,
    `valor` FLOAT NOT NULL,
    PRIMARY KEY (`id` , `compra`),
    UNIQUE INDEX `UNIQUE_ATIVIDADE` (`compra`),
    CONSTRAINT `FK_FUNCPGMT` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`),
    CONSTRAINT `FK_COMPRAPGMT` FOREIGN KEY (`compra`)
        REFERENCES `lanhouse`.`compra` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

CREATE TABLE `lanhouse`.`recebimento` (
    `id` INT(8) NOT NULL AUTO_INCREMENT,
    `dataHora` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `venda` INT(8) NOT NULL,
    `tipo` ENUM('DEBITO', 'CREDITO', 'DINHEIRO') NOT NULL,
    `valorPago` FLOAT NOT NULL,
    `troco` FLOAT NOT NULL,
    `funcionario` INT(8) NOT NULL,
    PRIMARY KEY (`id` , `venda`),
    UNIQUE INDEX `UNIQUE_VENDA` (`venda`),
    CONSTRAINT `FK_FUNCRECEBIMENTO` FOREIGN KEY (`funcionario`)
        REFERENCES `lanhouse`.`funcionario` (`id`),
    CONSTRAINT `FK_VENDARECEBIMENTO` FOREIGN KEY (`venda`)
        REFERENCES `lanhouse`.`venda` (`id`)
)  CHARSET=UTF8 COLLATE = UTF8_GENERAL_CI;

DELIMITER $$
 
CREATE TRIGGER TG_ABERTURACAIXA 
AFTER INSERT ON aberturaCaixa
FOR EACH ROW BEGIN
UPDATE caixa SET STATUS = 'ABERTO', valor = valor + NEW.valorAtribuido; 
END $$;

DELIMITER $$
 
CREATE TRIGGER TG_FECHAMENTOCAIXA 
AFTER INSERT ON fechamentoCaixa
FOR EACH ROW BEGIN
UPDATE caixa SET STATUS = 'FECHADO', valor = valor - NEW.valorRetirado; 
END $$

DELIMITER $$
 
CREATE TRIGGER TG_ENTRADACAIXA
AFTER INSERT ON recebimento
FOR EACH ROW BEGIN
insert into entradaCaixa(valor, funcionario, venda)
values(new.valorPago - new.troco, new.funcionario, new.venda);
UPDATE venda SET STATUS = 'PAGA' where id= NEW.venda; 
update caixa set valor = valor + (new.valorPago - new.troco);
delete from pagamentoPendente where venda = new.venda;
END $$



DELIMITER $$
 
CREATE TRIGGER TG_SAIDACAIXA
AFTER INSERT ON pagamentoDivida
FOR EACH ROW BEGIN
insert into saidaCaixa(valor, funcionario, compra)
values(new.valor, new.funcionario, new.compra);
UPDATE compra SET STATUS = 'PAGA' where id= NEW.compra; 
update caixa set valor = valor - new.valor;
delete from contaPendente where compra = new.compra;
END $$

DELIMITER $$
 
CREATE TRIGGER TG_DIMINUIDEVIDOMANUTENCAO
AFTER INSERT ON equipamentomanutencao
FOR EACH ROW BEGIN
UPDATE estoqueequipamento set quantidade = quantidade - new.quantidade where equipamento = new.equipamento; 
END $$

DELIMITER $$
 
CREATE TRIGGER TG_AUMENTODEVIDORETIRADEMANUTENCAO
AFTER INSERT ON retiraequipamentomanutencao
FOR EACH ROW BEGIN
UPDATE estoqueequipamento set quantidade = quantidade + new.quantidade where equipamento = new.equipamento; 
END $$

DELIMITER $$
 



 
