pipeline {
    agent any
    stages {
        stage ('Checkout SCM') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/alexfbasa/pact-backend.git']]])
                sh 'ls -la'
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests'){
            steps{
                sh 'mvn test'
            }
        }
        stage ('Sonar Analysis'){
            environment {
                scannerHome = tool 'SONNAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('docker_sonar'){
                    sh "${scannerHome}/bin/sonar-scanner -Dsonar.host.url=http://sonar:9000 -Dsonar.login=c65aba3088ec858364d3d1d2ee7d649387980e20 -Dsonar.java.binaries=target -Dsonar.projectKey=DeployBack"
                }
            }
        }
    }
}
