pipeline {
    agent any
    stages {
        stage('Checkout SCM') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/alexfbasa/pact-backend.git']]])
                sh 'ls -la'
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONNAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('docker_sonar') {
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.host.url=http://sonar:9000 -Dsonar.login=6284aea55a28f72b4b8833a9dfe72b0cf53467fa -Dsonar.java.binaries=target -Dsonar.projectKey=DeployBack"
                }
            }
        }
        stage('Quality Gate') {
            steps {
                sleep(25)
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('DeployBack'){
            steps {
                deploy adapters: [tomcat8(credentialsId: 'login_tomcat', path: '', url: 'http://tomcat:80/')], contextPath: 'tasks-backend-0.0.2-SNAPSHOT', war: 'target/tasks-backend-0.0.2-SNAPSHOT.war'
            }
        }
        stage('DeployFron'){
            steps {
                dir('front-end'){
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/alexfbasa/tasks-frontend.git']]])
                    sh 'ls -la'
                }

                deploy adapters: [tomcat8(credentialsId: 'login_tomcat', path: '', url: 'http://tomcat:80/')], contextPath: 'tasks-backend-0.0.2-SNAPSHOT', war: 'target/tasks-backend-0.0.2-SNAPSHOT.war'
            }
        }
    }
}
