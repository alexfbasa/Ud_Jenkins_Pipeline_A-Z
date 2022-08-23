# Course Alura - Devops: Jenkins Pipeline As Code: All you need to know A - Z
## Recursos 
Todos os recursos para esse curso esta na pasta resources

## Virtual Machines 
Todos os testes foram feitos no ambiente do VirtualBox, rodando uma maquina virtual Centos7
https://www.osboxes.org/centos/
Username: osboxes
Password: osboxes.org
Root Account Password: osboxes.org
Guest Tools: Open-VM-Tools Installed

## Jenkins em container
1 - Criar o Dockerfile
2 - Criar o docker-compose.yml
3 - Buld a imagem 
4 - Alterar permissao jenkins_home - Pior dos casos 777 para a pasta jenkins_home
https://www.digitalocean.com/community/tutorials/how-to-automate-jenkins-setup-with-docker-and-jenkins-configuration-as-code

## Docker e Dockercompose 
https://serverspace.io/support/help/how-to-install-docker-on-centos-8/
## Plugins

Deploy to container
Maven integration

### Configurar Deploy Tomcat

- Na criacao da pipeline definir DNS do container
- Diretorio do war
- User e senha

## This repository is about my jenkins studies

## Configurando o Maven para criar o pacote

```commandline
clean package
```

## Configurando Sonar no Jenkins

Pegar o Token no Sonar, usuario admin senha admin por padrao

Na pipeline, adicione um passo de build - essa informacao vem do Sonar, quando voce esta configurando
o Token - remova o D dos comando = Dsonar... para sonar. Adicione tambem sonar.java.binaries=target
informe a pasta, nesse caso foi target

```commandline
sonar.projectKey=DeployBack
sonar.host.url=http://sonar:9000
sonar.login=${TOKEN}
sonar.java.binaries=target
```

## Configurar o Quality Gate

Clicar em Quality Gates e criar um novo profile, adicionar esse profile para o projeto. Podemos checar
a cobertura de codigo
Para adicionar ao projeto, dentro do projeto clique em administrar depois associe o profile ao projeto

Adicione mais um passo no Jenkins caso nao passar na qualidade o projeto nao compila

![quality_gate_jenkins.png](/images/quality_gate_jenkins.png)

## Rodando Aplicacao NodeJS

NodeJs eh uma tecnologia para eecutar codigo em JavaScript do navegador.
Com ele podemos construir aplicações web em geral, desde web sites até APIs e microsserviços.
Isso é possível graças a união do ambiente de execução de JavaScript fornecido pelo próprio Node.js e o motor
de interpretação e execução de JavaScript presente no Google Chrome, chamado de V8.

- Instale o Plugin no Jenkins NodeJS
- Copie o Git repositoty da aplicacao em NodeJS {docker-demo};
- Crie um Freestyle project
- Configure o repositorio Git
- BUILD - execute shell $npm install
- Manage Jenkins - Global Tools --> NodeJS --> Defina um nome: nodejs - Install Automatically 
- Na config da Pipeline marque - Provide Node & rpm bin/folder to PATH e escolha nodejs
- O projeto sera buildadao e salvo em jenkins_home/workspace/nodejs_example_app/

## Publicando Aplicacao NodeJS em Docker

https://betterprogramming.pub/about-var-run-docker-sock-3bfd276e12fd

Vamos adicionar a funcionalidade para o Docker-Jenkins rodar container.
Jenkins container precisar acessar o docker socket rodando na maquina virtual
- Instale o plugin CloudBees Docker Build and publish plugin no Jenkins
- Modifique o arquivo Dockerfile do Jenkins adicionando, download do docker e outras entrandas
- build a imagem

## Criando uma conta para salvar imagens do em Docker
https://docs.quay.io/solution/getting-started.html
Faca o commit e push da imagem direto se voce ja tiver conta 
1 - acesse https://quay.io e crie a conta
2 - https://quay.io/tutorial/
3 - Criar uma conta e senha no Jenkins Server para acessar esse repositorio
4 - quay.io voce acessa o comando de pull da imagem