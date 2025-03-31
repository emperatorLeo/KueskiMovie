pipeline {
    agent {
         docker {
             image 'gradle:8.13.0-jdk21'
             args '-v $HOME/.gradle:/home/gradle/.gradle -v $ANDROID_HOME:/android/sdk'
            }
    }

    environment {
            ANDROID_HOME = '/android/sdk'
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