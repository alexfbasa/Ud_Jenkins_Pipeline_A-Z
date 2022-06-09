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
                sh "${scannerHome}/bin/-Dsonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://-Dsonar:9000 -Dsonar.login=6284aea55a28f72b4b8833a9dfe72b0cf53467fa -Dsonar.java.binaries=target"
            }
        }
    }
}
