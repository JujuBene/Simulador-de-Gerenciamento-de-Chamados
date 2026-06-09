<p align="center">
<img 
    src="./assets/Capa.png"
    width="600"
/>

</p>

# Simulador de Suporte Técnico de Informática


 > ℹ️ **NOTE:** Este documento foi estruturado a partir do projeto “Simulador de Suporte Técnico de Informática”, desenvolvido na disciplina de Estruturas de Dados e Análise de Algoritmos, com o objetivo de aplicar na prática diferentes estruturas de dados em um cenário corporativo de gerenciamento de chamados.

Projeto desenvolvido para simular um sistema de suporte técnico capaz de cadastrar usuários, registrar chamados, organizar atendimentos e armazenar históricos, utilizando Fila, Pilha, Lista Ligada e Árvore Binária de forma integrada.

## 💻 Tecnologias utilizadas no projeto

- Java
- Java Swing
- Estruturas de Dados
- Programação Orientada a Objetos (POO)
- JTable
- JFrame
- JOptionPane


## ✨ Como foi feito ?

<b>Desenvolvimento do sistema</b>

O projeto foi desenvolvido para representar um ambiente real de suporte técnico corporativo, permitindo controlar todo o ciclo de vida de um chamado, desde sua abertura até sua conclusão.

Cada chamado possui:
- ID único
- Nome do usuário
- Descrição do problema
- Categoria
- Prioridade



<b>Aplicação das Estruturas de Dados</b>

📋 Fila (Queue)

Utilizada para organizar os chamados aguardando atendimento.

Funcionamento:
- O primeiro chamado aberto será o primeiro atendido.
- Segue o conceito FIFO (First In, First Out).


📚 Pilha (Stack)

Utilizada para armazenar o histórico dos chamados atendidos.

Funcionamento:
- Após o atendimento, o chamado é removido da fila.
- O registro é armazenado na pilha.
- Segue o conceito LIFO (Last In, First Out).


🔗 Lista Ligada (Linked List)

Utilizada para armazenar usuários e chamados cadastrados.

Benefícios:
- Crescimento dinâmico
- Inserções eficientes
- Melhor organização dos registros


🌳 Árvore Binária

Utilizada para busca rápida de chamados através do ID.

Benefícios:
- Pesquisa eficiente
- Organização hierárquica dos dados
- Melhor desempenho em consultas



<b>Interface Gráfica</b>

A aplicação possui uma interface desenvolvida em Java Swing para facilitar a interação do usuário.
Componentes utilizados:
- JFrame
- JTable
- JButton
- JOptionPane

A interface permite visualizar:
- Usuários cadastrados
- Chamados em aberto
- Prioridades
- Histórico de atendimentos
- Resultados de buscas


## 🛠️ Instruções de execução

- 🤖 1. Cadastro de Usuários
Permite registrar novos usuários no sistema.
- 🤖 2. Abertura de Chamados
Criação de solicitações de suporte técnico.
- 🤖 3. Atendimento de Chamados
Processamento dos chamados seguindo a ordem da fila.
- 🤖 4. Consulta de Histórico
Visualização dos chamados já concluídos.
- 🤖 5. Busca por Código
Localização rápida de chamados através da árvore binária.
- 🤖 6. Gerenciamento de Prioridades
Controle e organização das solicitações registradas.


## 🔄 Fluxo de execução

1️⃣ Cadastro do usuário → Lista Ligada
2️⃣ Abertura do chamado → Fila + Árvore Binária
3️⃣ Atendimento do chamado → Remoção da Fila
4️⃣ Encerramento → Registro na Pilha
5️⃣ Consulta → Busca pela Árvore Binária


## 📌 Considerações finais

Este projeto permitiu aplicar de forma prática os conceitos fundamentais de Estruturas de Dados e Análise de Algoritmos, demonstrando como diferentes estruturas podem trabalhar em conjunto para solucionar problemas reais.
A integração entre Fila, Pilha, Lista Ligada e Árvore Binária tornou o sistema eficiente, organizado e alinhado às necessidades de um ambiente de suporte técnico, proporcionando uma experiência completa de gerenciamento de chamados.

## 👨‍💻 Expert

<p>
    <p>&nbsp&nbsp&nbspJuliana Benedetti<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://github.com/JujuBene">
        GitHub
    </a>
    &nbsp;|&nbsp;
    <a 
        href="https://www.linkedin.com/in/juliana-magiero-benedetti/">
        LinkedIn
    </a>
   
</p>

<p>
    <p>&nbsp&nbsp&nbspNatália Brediks<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://www.linkedin.com/in/natalia-brediks-miltus-marques/">
        LinkedIn
    </a>
</p>

<p>
    <p>&nbsp&nbsp&nbspMariana Cardoso<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://www.linkedin.com/in/marianacbrand%C3%A3o/">
        LinkedIn
    </a>
</p>

<p>
    <p>&nbsp&nbsp&nbspRuan Luz<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://www.linkedin.com/in/ruanviniciusluz/">
        LinkedIn
    </a>
</p>

<p>
    <p>&nbsp&nbsp&nbspCaio Camargo<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://www.linkedin.com/in/caio-camargo-049777313/">
        LinkedIn
    </a>
</p>
<br/><br/>
<p>

---
# Simulador-de-Gerenciamento-de-Chamados
