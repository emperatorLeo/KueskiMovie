pipeline {
    agent {
         docker {
             image 'gradle:8.13.0-jdk21'
             reuseNode true
             //args '-v $HOME/.gradle:/home/gradle/.gradle -v $ANDROID_HOME:/android/sdk'
             args '/Users/leonardosantana/.gradle:/home/gradle/.gradle -v /Users/leonardosantana/Library/Android/sdk'
            }
    }

    environment {
            ANDROID_HOME = '/Users/leonardosantana/Library/Android/sdk'
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