pipeline {
    agent {
         docker {
             image 'gradle:8.13.0-jdk21'
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
            apt-get update
            apt-get install -y --no-install-recommends \
            libncurses5 \
            libstdc++6 \
            zlib1g \
            libz-dev \
            libncurses-dev \
            lib32stdc++6 \
            lib32z1
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