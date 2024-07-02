# Agrix - Fase B

Bem-vindo ao projeto Agrix - Fase B! Este projeto é uma extensão da Fase A, com novas funcionalidades. Abaixo, detalho as etapas que foram realizadas com sucesso para atender aos requisitos desta fase.

## Especificações do Projeto

### 🗄️ Descrição do Banco de Dados

Na Fase B, o banco de dados foi ampliado. A estrutura atualizada inclui as tabelas `farm`, `crop`, `fertilizer` e `crop_fertilizer` com os relacionamentos necessários para suportar as novas funcionalidades.

![Modelo de tabelas](images/agrix-tabelas-fase-b.png)

### 🏛️ Arquitetura da Aplicação

A aplicação foi estruturada utilizando o ecossistema Spring (Spring Boot, Spring Web, Spring Data, etc.), proporcionando flexibilidade e manutenção eficiente. As melhores práticas e padrões de projeto foram seguidos para garantir a qualidade do código.

## Detalhes do Projeto

### 1. Ajuste da Rota POST /farms/{farmId}/crops para Utilizar Datas

<details>
    <summary>📍🌐🛠️ Detalhes da Rota:</summary><br />

A rota POST /farms/{farmId}/crops foi ajustada para incluir os campos `plantedDate` e `harvestDate`, utilizando o tipo `LocalDate` para manipulação de datas no formato ISO (YYYY-MM-DD).

Exemplo de requisição:

```json
{
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08",
  "farmId": 1
}
```

</details>

### 2. Ajuste da Rota GET /farms/{farmId}/crops para Utilizar Datas

<details>
    <summary>📍🌐🛠️ Detalhes da Rota:</summary><br />
A rota GET /farms/{farmId}/crops foi ajustada para incluir os novos campos com datas na resposta.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "plantedDate": "2022-12-05",
    "harvestDate": "2023-06-08",
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  }
]
```

</details>

### 3. Ajuste da Rota GET /crops para Utilizar Datas

<details>
    <summary>📍🌐🛠️ Detalhes da Rota:</summary><br />
A rota GET /crops foi ajustada para retornar todas as plantações cadastradas com os novos campos de datas.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "plantedDate": "2023-05-22",
    "harvestDate": "2024-01-10",
    "farmId": 2
  }
]
```

</details>

### 4. Ajuste da Rota GET /crops/{id} para Utilizar Datas

<details>
    <summary>📍🌐🛠️ Detalhes da Rota:</summary><br />
A rota GET /crops/{id} foi ajustada para retornar os dados da plantação com os novos campos de datas.

Exemplo de resposta:

```json
{
  "id": 3,
  "name": "Tomate",
  "plantedArea": 1.9,
  "plantedDate": "2023-05-22",
  "harvestDate": "2024-01-10",
  "farmId": 2
}
```

</details>

### 5. Criação da Rota GET /crops/search para Busca de Plantações

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />

A rota GET /crops/search foi criada para buscar plantações a partir da data de colheita.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "plantedDate": "2023-05-22",
    "harvestDate": "2024-01-10",
    "farmId": 2
  }
]
```

</details>

### 6. Criação da Rota POST /fertilizers

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />
A rota POST /fertilizers foi criada para permitir a criação de um novo fertilizante.

Exemplo de requisição:

```json
{
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```

</details>

### 7. Criação da Rota GET /fertilizers

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />
A rota GET /fertilizers foi criada para listar todos os fertilizantes cadastrados.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Compostagem",
    "brand": "Feita em casa",
    "composition": "Restos de alimentos"
  },
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```

</details>

### 8. Criação da Rota GET /fertilizers/{id}

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />
A rota GET /fertilizers/{id} foi criada para retornar as informações de um fertilizante específico.

Exemplo de resposta:

```json
{
  "id": 3,
  "name": "Adubo",
  "brand": "Feito pelas vaquinhas",
  "composition": "Esterco"
}
```

</details>

### 9. Criação da Rota POST /crops/{cropId}/fertilizers/{fertilizerId}

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />
A rota POST /crops/{cropId}/fertilizers/{fertilizerId} foi criada para associar uma plantação com um fertilizante.

Exemplo de resposta:

```text
Fertilizante e plantação associados com sucesso!
```

</details>

### 10. Criação da Rota GET /crops/{cropId}/fertilizers

<details>
    <summary>📍🌐 Detalhes da Rota:</summary><br />

A rota GET /crops/{cropId}/fertilizers foi criada para listar os fertilizantes associados a uma plantação.

Exemplo de resposta:

```json
[
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```

</details>

## Conclusão

Todos os requisitos da Fase B foram atendidos com sucesso, garantindo a expansão das funcionalidades do Agrix e mantendo a qualidade e integridade do projeto. O projeto está pronto para ser utilizado, oferecendo uma experiência robusta e eficiente para os usuários.
