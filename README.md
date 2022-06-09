# learning_jenkins
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