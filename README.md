###ConnectedIn

##Sobre

O projeto consiste na criação de uma rede social profissional, onde de um lado termos empresas e do outro pessoas (profissionais). 
Essa rede ira conectar empresas com profissionais. Terá espaço para o perfil do usuário (tanto p pessoas como para as empresas). 

O objetivo da aplicação ConnectedIn (versão 1.0) é ajudar profissionais e empresas se conectarem e assim auxiliar nas contratações. 
A aplicação tem por objetivo ajudar profissionais e e empresas neste momento que estamos passando (elevado número do desemprego)
A aplicação vem para auxiliar o profissional a encontrar a empresa e a vaga certa para ele. 
E para a empresa, encontrar o profissional certo para a vaga certa.

A API possibilita a criação de uma conta com nome e email - infos básicas de contato.
Dentro da conta é possível criar um documento com data, título e corpo. 
Para profissionais a ideia é disponibilizar seu CV. Fornecer informações de trabalhos, estudos e aprendizados.
Para as empresas a ideia é disponibilizar ofertas de trabalho. Fornecer descrição da vaga/programa e outras informações relacionadas.
Dentro do documento (tanto da empresa como do profissional) é possível criar comentários. Gerar interação entre as partes.

##A API está na versão 1.0 - Agosto/2020. 
Criada em linguagem Java e o framework Spring Boot.
Banco de dados: Mongodb.

##Seguem as principais operações do serviço (CRUD) já disponíveis na versão 1.0.

#User - Conta
Retorna todos Usuários
GET - http://localhost:8080/users

Retorna o Usuário com o Id buscado
GET {id} - http://localhost:8080/users/id

Cria Usuário
POST - http://localhost:8080/users

Apaga o Usuário com o Id buscado
Delete {id} - http://localhost:8080/users/id

Altera o Usuário com o Id buscado
PUT {id} - http://localhost:8080/users/id

Retorna o Usuário com id buscado e todos documentos (Files) criado por ele
GET {id}/files - http://localhost:8080/users/id/files	

#File – Arquivos criado pelo Usuário

Retorna os documentos criados por um Usuário pelo Id dele
GET {id} - http://localhost:8080/files/id

Retorna uma pesquisa dos documentos com filtro. O filtro é feito pelo Título pesquisado
GET {/serachtitle} - http://localhost:8080/files/serchtitle

Cria um novo documento, File, com o ID do Usuário que criou.
POST {User_ID} - http://localhost:8080/files/id

##Conteudo Desenvolvido por Guilherme Ferrini - 2020.
 