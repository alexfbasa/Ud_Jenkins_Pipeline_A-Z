pipeline {
    agent any
    stages {
        stage ('Checkout SCM') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/alexfbasa/pact-backend.git']]])
                sh 'ls -la'
                sh 'mvn clean package'
            }
        }
        stage ('Build DEV'){
            steps{
                sh 'echo Hello world -- MEIO'
            }
        }
        stage ('FIM PROD'){
            steps{
                sh 'echo Hello world -- PROD'
            }
        }
    }
}