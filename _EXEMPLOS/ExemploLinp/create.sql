Create or replace procedure listarPessoasPorIniciaisNome(nomeExemplo in varchar, pessoas out sys_refcursor) as
begin
   open pessoas for
   select nome, cpf, bairro as "endereco.bairro", 
          				 	rua as "endereco.rua", numero as "endereco.numero", 
          				 	numeroCep as "endereco.cep.numero"
   from pessoa where nome like 'j' || '%';
end listarPessoasPorIniciaisNome;