# Café Expresso

Sistema de autoatendimento para cafeteria desenvolvido como projeto acadêmico.

## Sobre o projeto

O Café Expresso é um sistema de autoatendimento pensado para uma cafeteria de pequeno porte. A ideia é permitir que o próprio cliente monte seu pedido em um totem digital, realize o pagamento e acompanhe o andamento, sem precisar enfrentar filas.

O objetivo principal é tornar o atendimento mais rápido, organizado e com menos chances de erro.

## Objetivo

* Agilizar o processo de pedidos
* Reduzir filas no atendimento
* Diminuir erros nos pedidos
* Organizar o fluxo entre cliente e atendente

## Funcionalidades

O sistema deverá permitir:

* Cadastro de produtos com nome e preço
* Adição de múltiplos itens a um pedido
* Cálculo automático do valor total
* Controle de status do pedido:

  * Pendente
  * Pago
  * Em preparo
  * Finalizado

## Estrutura do sistema

O projeto será organizado em três classes principais:

* Produto: representará os itens do cardápio, contendo nome e preço
* ItemPedido: irá relacionar um produto com a quantidade e calcular o subtotal
* Pedido: será responsável por gerenciar os itens, calcular o valor total e controlar o status do pedido

## Fluxo do sistema

O funcionamento deverá seguir a seguinte sequência:

1. O cliente escolhe os produtos
2. O sistema calcula automaticamente o valor total
3. O pagamento é realizado
4. O pedido é enviado para preparo
5. O pedido é finalizado e entregue

O sistema deverá garantir que as etapas sejam seguidas na ordem correta.

## Tecnologias utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Git e GitHub

## Integrantes

* Márcio Aparecido Cirqueira de Souza
* Marcos André Cirqueira de Souza
* Polo: Brumado

## Observação

Este projeto está em desenvolvimento e será expandido ao longo da disciplina.
