pipeline {
    agent any
    stages {
        stage('Checkout SCM') {
            sh echo 'Hello world'
        }

    }
}