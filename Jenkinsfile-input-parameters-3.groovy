def firstName = null
def secondName = null
pipeline {
    agent none
    stages {
        stage('input') {
            steps {
                script {
                    firstName = input(
                            message1: 'What is your first name?',
                            parameters1: [string(defaultValue: 'Dave', name: 'FIRST_NAME', trim: true)],
                            message2: 'What is your second name?',
                            parameters2: [string(defaultValue: 'Basa', name: 'SECOND_NAME', trim: true)],
                            ok: 'Submit',

                    )
                }

                stage('output') {
                    agent any
                    steps {
                        script {
                            echo "Good Morning, $firstName $secondName"
                        }
                        sh '''
                          hostname
                          cat /etc/*-release
                        '''
                    }
                }
            }
        }
    }
}