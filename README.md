Especificação:

Deverá desenvolver um software de acordo ao seu tema utilizando a linguagem Java, especificamente a plataforma JEE (Java Enterprise Edition).

Segundo Sommerville, software corresponde ao programa desenvolvido, dados de configuração e toda a sua documentação.

O Projeto será Orientado pelo professor Andre Portugal.

- O software deve ser desenvolvido utilizando os seguintes frameworks e/ou tecnologias:
	- JSF Primefaces hibernate spring security (Se possível - Opcional)
	- Jasper Report (Se possível - Opcional)
	- Maven
	- html 5
	- css

- O software deverá inserir, alterar, excluir e consultar dados em banco de dados(Mysql).

- Cada equipe deve usar alguma tecnologia de versionamento como GitHub ou SVN.

- Os artefatos a serem entregues são:

- Parte Escrita
	- Modelo do Software
	- Protótipo utilizando a ferramenta Pencil
	- Diagrama de Implantação
	- Diagrama de Componentes

- Implementação no Netbeans ou outra IDE.

	- É importante salientar que a documentação do software deverá apresentar os conceitos listados acima e inclusive apontar para as referências bibliográficas Utilizadas.
	- Na segunda unidade, o projeto deverá ser apresentado por cada equipe utilizando slides e a não realização dos mesmos, acarretará penalidades as equipes.
	- Para a disciplina Desenvolvimento de Aplicação os pesos do PI serão: 
		- Apresentação – 2,0
		- Projeto – 5,5
		- Documentação – 2,5

A ordem de apresentação segue de acordo ao numero da equipe, exemplo: Equipe 1, Equipe 2,..

Prazos a serem cumpridos

	Primeira Unidade (23/09/2021) – Entrega do protótipo e os diagramas e o caminho do versionamento do projeto. 
	Segunda Unidade (02/12/2021) – Entrega do Projeto e Apresentação

Observação: Não esperem o assunto ser dado para iniciar o projeto.
  
  Como orientação vocês devem estudar:

	a) Arquitetura de Sistemas (Especificamente Client-Server e Multi-Tier)
	b) Padrão MVC 
	c) Servidores de Aplicação (Especificamente TomCat e Glassfish) 
	d) JSF, JSTL e Primefaces 
	e) Hibernate 
	f) Jasper Report 
	g) Spring Security

Requisitos do Sistema

Todas as equipes devem possuir uma classe chamada usuário que terá 5 atributos (Nome, Cargo, Login, Senha e Email) .

Sistema de Cobrança

Deve existir as seguintes classes :

	- Divida
	- Pagamento
	- Cliente

Atributos das classes

	Divida
		codigo – int
		credor – Pessoa
		dataAtualizacao – Date
		valorDivida – Decimal
		devedor – Pessoa
	Pagamento
		idpag - int
		divida – Divida
		dataPagamento – Date
		valorPago – Decimal
	Pessoa
		idCliente - int
		nomeCliente – String
		endereco - String
		uf – String
		telefone – String
		documento – String
		e-mail - String

	Obs: 
	Não pode registrar o pagamento de uma divida inexistente ou paga
	Não pode registrar o pagamento de uma divida inferior ao valor da divida
	Caso a data seja maior que a ultima atualização da divida o sistema deve atualizar automaticamente o valor a ser pago : 
		Multa – 2%
		Juros – 0,35% ao dia
	A Pessoa e a divida deve existir para gravar o pagamento
	As Pessoas (credor e Devedor) deve existir para gravar a divida
	A pessoa credor deve ser diferente da pessoa devedor em uma divida

	O usuário poderá:
	Cadastrar, consultar e excluir as Dividas
	Cadastrar, consultar e excluir os Pagamento
	Cadastrar, consultar e excluir as Pessoas

	Só poderá excluir uma divida se não existir pagamento
	Só poderá excluir uma pessoa se não existir dividas associadas a mesma

	Cada arquivo será identificado pelo id de cada instancia

	Deve existir uma tela para consultar o faturamento dado um período específico.
	Deve existir uma tela para consultar as Dividas ainda não pagas
	Deve existir uma tela para consultar as Dividas de uma pessoa pelo seu documento
