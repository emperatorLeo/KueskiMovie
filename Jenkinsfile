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
            mkdir -p /var/lib/apt/list/partial
            apt-get update
            apt-get install -y --no-install-recommends \
            sudo \
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