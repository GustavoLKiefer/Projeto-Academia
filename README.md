![Academia](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwallpaperaccess.com%2Ffull%2F2968249.jpg&f=1&nofb=1&ipt=dccb4cd55f7ed9a990e08cf13a798cbe28d52f2c3ccd67b0659723f377fbc89b)

# 💪 Projeto academia

O sistema segue uma abordagem modular, com separação clara entre interface, regras de negócio e acesso a dados. Sendo também, uma aplicação Java com um menu principal com opções para gerenciar alunos e treinos, com interface de linha de comando (CLI), conexão com banco de dados MySQL e Operações CRUD completas. Desenvolvido como parte do trabalho acadêmico A3, para a disciplina de Programação de solução computacionais.

---

# 🌐 Como utilizar

**Para garantir a funcionalidade, certifique-se de ter o JDK e o Java instalados**

## Requisitos para funcionamento (em Windows)

Por ser um programa simples é necessário fazer mínimas alterações no código e baixar alguns aplicativos. Tudo será explicado em baixo

- Wampserver: https://sourceforge.net/projects/wampserver/

Serve para criar uma conexão local. Lembre-se de baixar os requisitos dele também!


- MySQL Workbench: https://dev.mysql.com/downloads/workbench/

Usado para criar o banco de dados

O link leva direto para a versão de Windows então é importante garantir que esse seja seu OS, se não for o caso, troque para o OS utilizado

Para rodar o código será necessário ter uma IDE. Ao lado está uma recomendação para ser utilizada, pode usar a que preferir: https://www.eclipse.org/downloads/packages/
(baixe a versão Eclipse IDE for Java Developers mais recente)

- Para caso de falta de Visual C++ da Microsoft, os downloads estão aqui: https://learn.microsoft.com/en-us/cpp/windows/latest-supported-vc-redist?view=msvc-170

Verifique quais faltam e baixe eles 

### Possível erro com o Wampserver

Para o caso do Wampserver permanecer **amarelo(ou laranja)** ao invés de verde você precisará executar um passo a passo antes de continuar

- Clique com o botão direito no Wampserver quando ele estiver em segundo plano
- Vá para a seção "Tools"
- Dentro da parte "Port used by MySQL" clique em "Use a port other than 3306"
- Mude a porta para 3308
- Abra o arquivo Conexao.java em Projeto-Academia\ProjetoAcademia\code\demo\src\main\java\util
- Na linha 25, logo após localhost mude o valor "3306" coloque "3308"
- Se ocorrer como planejado deverá estar funcionando agora

## Passo a passo para funcionar

- Vá para o arquivo "banco_de_dados.sql" que existe no github
- Copie todo o texto no arquivo
- Abra o Wampserver
- Verifique nos aplicativos em segundo plano se ele está verde
- Abra o MySQL Workbench
- Entre no servidor local
- Copie o código e vá executando cada parte dele (cada bolinha azul indicada no programa é um comando diferente. Para executar use CTRL + Enter enquanto uma parte é selecionada)
- Agora execute o arquivo Main.java localizado em ProjetoAcademia/code/demo/src/main/java/aplicacao/
- Se tudo ocorrer como previsto o código irá rodar

## Dentro do CLI

**Para começar vale destacar que se você acabou de instalar tudo isso pela primeira vez você não terá uma senha, portanto poderá deixar vazio**

- Insira sua senha quando for pedido, o programa irá te informar se algum erro ocorrer
- Usando os números do teclado você irá se locomover pelos menus
- As dependências do código estão listadas no arquivo pom.xml

## Erros comuns e tratamentos

- Código de erro 1045 -> Confirme se inseriu sua senha corretamente
- Código de erro 1049 -> Verifique se criou o banco de dados corretamente, as vezes pode ter esquecido de rodar alguma parte no MySQL Workbench
- Código de erro 1146 -> Verifique se criou a tabela igual no arquivo .sql
- Código de erro 1366 -> Valor incorreto para a coluna (errou o tipo de dado)
- Código de erro 2003 -> Confirme se o código .java na pasta util está com a porta correta
- CPF Inválido: A conta do CPF não funcionou, isso se deve ao CPF ser inválido com os parâmetros definidos para números verificadores pelo Governo Federal

---

# 🔹Geral

## ⚙️ Como funciona? 

Geral
- Menu Principal: Interface inicial com opções para acessar os módulos de Alunos ou Treinos
- Módulo de Alunos: Permite cadastrar, listar, editar, excluir e buscar alunos
- Módulo de Treinos: Permite cadastrar e gerenciar treinos associados a alunos

## Componentes Principais

1. Estrutura de Pacotes

 - Aplicacao: Contém a classe Main com a lógica principal do programa.
 - DAO: Classes de acesso a dados (AlunoDAO e TreinoDAO)
 - Model: Classes que representam as entidades do sistema (Aluno e Treino)
 - Util: Classe utilitária para conexão com o banco de dados
   
2. Funcionalidades

Para Alunos:

  - Cadastro com nome, CPF, data de nascimento, telefone e e-mail
  - Listagem de todos os alunos cadastrados
  - Edição de informações dos alunos
  - Exclusão de alunos
  - Busca por ID ou nome

Para Treinos:

  - Cadastro de treinos associados a alunos
  - Especificação de tipo de treino, descrição, duração e data de início

3. Fluxo do Programa

 - Inicia na classe Main, que estabelece conexão com o banco de dados
 - Exibe o menu principal com opções para Alunos ou Treinos
 - Cada módulo possui seu próprio menu com operações específicas
 - Todas as operações são persistidas no banco de dados MySQL

---

## 🛠️ Tecnologias

- Java (versão 8+)
- MySQL (Driver JDBC)
- Padrão DAO (Data Access Object)
- Live share (Extensão)
  
---

## 🧠 Desafios enfrentados

- Buscar conhecimento sobre banco de dados e Java. 
- Conexão com banco de dados.
- Programação mais avançada em Java.
- Organização no GitHub.
  
---

## 📚 O que aprendemos?

- Integração com banco de dados.
- Uso de MySQL
- Conhecimento aprofundado em JDBC
- Aprimoramos o conhecimento em Java.
- Manuseio de IDEs e bancos de dados.

---

 - Fonte dos erros: https://dev.mysql.com/doc/mysql-errors/8.0/en/server-error-reference.html
