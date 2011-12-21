CREATE TABLE  PESSOA 
   (	NOME VARCHAR2(4000), 
	CPF VARCHAR2(4000), 
	BAIRRO VARCHAR2(4000), 
	RUA VARCHAR2(4000), 
	NUMERO NUMBER, 
	NUMEROCEP VARCHAR2(4000)
   );

Create or replace procedure listarPessoasPorNomeProc(nomeExemplo in varchar, pessoas out sys_refcursor) as
begin
   open pessoas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where nome like nomeExemplo || '%';
end listarPessoasPorNomeProc;

Create or replace procedure excluirPessoa(p_cpf in varchar) as
begin
   delete from pessoa where cpf = p_cpf;
end excluirPessoa;

Create or replace function listarPessoasPorNomeFunc(nomeExemplo in varchar) return sys_refcursor is
  pessoas sys_refcursor;
begin 
   open pessoas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where nome like nomeExemplo || '%';
   
   return pessoas;
end listarPessoasPorNomeFunc;

Create or replace function excPessoasRetornaExcluidosFunc(nomeExemplo in varchar,pessoasNaoExcluidas out sys_refcursor) return sys_refcursor is
  pessoasExcluidas sys_refcursor;
begin 
   open pessoasNaoExcluidas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where not nome like nomeExemplo || '%';

   open pessoasExcluidas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where nome like nomeExemplo || '%';

   delete from pessoa where nome like nomeExemplo || '%';
   
   return pessoasExcluidas;
end excPessoasRetornaExcluidosFunc;

Create or replace procedure excPessoasRetornaExcluidosProc(nomeExemplo in varchar, pessoasExcluidas out sys_refcursor, pessoasNaoExcluidas out sys_refcursor) as
begin
   open pessoasNaoExcluidas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where not nome like nomeExemplo || '%';

   open pessoasExcluidas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where nome like nomeExemplo || '%';

   delete from pessoa where nome like nomeExemplo || '%';
end excPessoasRetornaExcluidosProc;

Create or replace function qtdPessoas return number is
  qtd number;
begin 
   select count(*) into qtd from pessoa;
   return qtd;
end qtdPessoas;
