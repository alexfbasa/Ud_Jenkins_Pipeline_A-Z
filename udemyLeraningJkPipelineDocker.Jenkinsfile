@Library("pipeline-shared-lib@master") _

node {
    def mvnHome

    stage('Checkout') {
        git 'https://github.com/wardiaene/jave-demo.git'

        mvnHome = tools 'M3'
    }
    stage('Build') {
        if (isUnix) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
            println "Compiled by Linux"
        } else {
            bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            println "Compiled by Windows"
        }
    }
    stage('Results'){
        junit '**/target/surefire-reports/TEST-*.xml'
        archive '/target/*.jar'
    }
}
