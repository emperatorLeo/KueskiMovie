pipeline {
    agent {
         docker {
            // image 'gradle:8.13.0-jdk21'
            image 'openjdk:21-slim'
             args '-v $HOME/.gradle:/home/gradle/.gradle -v /Users/leonardosantana/Library/Android/sdk:/android/sdk -w /app --entrypoint='
             customWorkspace '/app'
            }
    }

    environment {
            ANDROID_HOME = "/android/sdk"
        }

    stages {
        stage('Build') {
            steps {
            sh '''
            apt-get update
            apt-get install -y --no-install-recommends \
            git \
            libncurses5 \
            libstdc++6 \
            zlib1g \
            libz-dev \
            libncurses-dev \
            lib32stdc++6 \
            lib32z1
            ls -la
            git --version
            java --version
            ./gradlew assembleDebug
            echo 'finish build'
            ls -la
            '''
            }
        }
    }
}