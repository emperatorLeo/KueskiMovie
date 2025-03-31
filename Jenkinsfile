pipeline {
    agent {
         docker {
             image 'amd64/gradle:8.13.0-jdk21'
             args '-v $HOME/.gradle:/home/gradle/.gradle'
            }
    }

    environment {
            ANDROID_HOME = "/Users/leonardosantana/Library/Android/sdk"
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