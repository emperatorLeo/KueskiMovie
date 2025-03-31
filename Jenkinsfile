pipeline {
    agent {
         docker {
             image 'gradle:8.13.0-jdk21'
             reuseNode true
             //args '-v $HOME/.gradle:/home/gradle/.gradle -v $ANDROID_HOME:/android/sdk'
             args '/users/leonardosantana/.gradle:/home/gradle/.gradle -v /users/leonardosantana/Library/Android/sdk'
            }
    }

    environment {
            ANDROID_HOME = '/users/leonardosantana/library/android/sdk'
        }

    stages {
        stage('Build') {
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