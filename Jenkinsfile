pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                 docker {
                     image 'gradle:8.13.0-jdk21'
                     reuseNode true
                 }
            }
            steps {
            sh '''
            ls -la
            gradle --version
            java --version
            ./gradlew assembleDebug
            echo 'finish build'
            ls -la
            '''
            }
        }
    }
}