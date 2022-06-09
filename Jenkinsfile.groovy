pipeline {
    agent any
    stages {
        stage ('Checkout SCM') {
            steps {
                sh echo 'Hello world'
            }
        }

    }
}