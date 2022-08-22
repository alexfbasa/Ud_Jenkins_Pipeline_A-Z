/*
https://www.jenkins.io/doc/book/pipeline/syntax/
Options
 */
pipeline {
    agent {
        docker {
            image 'ubuntu:latest'
        }
    }
    options {
        newContainerPerStage()

    }
    stages {
        stage('Build') {
            steps {
                sh '/cat /etc/lsb-release'
            }
        }
        stage('Deploy'){
            echo 'Hello-World'
        }
    }
}
// Comentario