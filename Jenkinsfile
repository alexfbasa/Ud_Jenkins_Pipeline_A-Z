pipeline {
    agent any
    stages {
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
    }
}
