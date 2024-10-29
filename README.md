

# Caixa Eletrônico

O **Caixa Eletrônico** é uma aplicação Java com interface gráfica que simula um sistema de caixa eletrônico. O aplicativo permite autenticação de usuários e realiza operações de consulta de saldo, depósito e saque.

## Funcionalidade

A aplicação é dividida em duas telas principais:

1. **Tela de Autenticação**: O usuário deve inserir o número da agência, conta e senha para acessar a tela principal.
2. **Tela Principal**: Após a autenticação, o usuário pode consultar o saldo, realizar depósitos e saques.

## Estrutura do Código

### Pacote `caixaeletronico`

A aplicação é organizada no pacote `caixaeletronico`, que contém duas classes principais: `CaixaEletronicoGUI` e `TelaPrincipalGUI`.

### Classe `CaixaEletronicoGUI`

- **Herança**: Estende `JFrame`, permitindo a criação de uma janela GUI.
- **Componentes**:
  - `JTextField agenciaField`: Campo para inserir o número da agência.
  - `JTextField contaField`: Campo para inserir o número da conta.
  - `JPasswordField senhaField`: Campo para inserir a senha eletrônica.
  - `JButton loginButton`: Botão para realizar o login.

#### Construtor

No construtor da classe:

- Define o título da janela, tamanho, posição, e layout.
- Adiciona componentes de interface, como labels, campos de texto e o botão de login.
- Configura a ação do botão de login para chamar o método `autenticar()`.

#### Método `autenticar()`

Este método verifica as credenciais inseridas pelo usuário. Caso a autenticação seja bem-sucedida, ele abre a `TelaPrincipalGUI` e fecha a tela de autenticação. Caso contrário, exibe uma mensagem de erro.

#### Método `main`

O método `main` inicializa a tela de autenticação.

### Classe `TelaPrincipalGUI`

- **Herança**: Também estende `JFrame`, permitindo a criação da janela principal após a autenticação.
- **Componentes**:
  - `double saldo`: Variável para armazenar o saldo atual.
  - `JTextField valorField`: Campo para entrada de valores para depósito ou saque.
  - `JTextArea areaSaldo`: Área de texto para exibir o saldo.

#### Construtor

Configura a interface da tela principal:

- Define o título, tamanho, posição e layout da janela.
- Adiciona botões para consultar saldo, depósito e saque, bem como a área de texto para exibir o saldo.

#### Métodos

- **`consultarSaldo()`**: Exibe o saldo atual na `areaSaldo`.
- **`realizarDeposito()`**: Lê o valor inserido e realiza o depósito, se o valor for maior ou igual a R$ 20.
- **`realizarSaque()`**: Lê o valor inserido e realiza o saque, se o valor estiver entre R$ 10 e o saldo disponível.

#### Método `main`

O método `main` inicializa a tela principal do caixa eletrônico.

## Como Usar

1. Ao iniciar a aplicação, a tela de autenticação será exibida.
2. Insira o número da agência, conta e senha para fazer login.
3. Na tela principal, utilize os botões para consultar saldo, depositar ou sacar.
4. Insira um valor no campo apropriado para depósitos e saques.

## Dependências

- Java SE 8 ou superior

---

Sinta-se à vontade para fazer ajustes ou adicionar mais informações, se necessário!
