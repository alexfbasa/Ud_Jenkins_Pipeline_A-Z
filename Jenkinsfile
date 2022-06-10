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
                sleep(5)
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
