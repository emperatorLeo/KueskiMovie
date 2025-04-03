pipeline {
    agent {
        docker {
        image 'cimg/android:2025.04.1'
        args '-v $HOME/.gradle:/home/gradle/.gradle -v /Users/leonardosantana/Library/Android/sdk:/android/sdk -w /app'
        }
    }
    environment {
     //DIR = "https://github.com/emperatorLeo/KueskiMovie"
     ANDROID_HOME = "/android/sdk"
    }
    stages {
     stage('Checkout'){
     agent {
       label 'any'
     }
        steps {
          sh'''
          whoami
          git clone https://github.com/emperatorLeo/KueskiMovie.git
          '''
          checkout scm
        }
      }

     stage('Setup'){
        steps {
            //dir(DIR){
                  sh '''
                  pwd
                  chmod +x ./gradlew
                  ./gradlew detekt --auto-correct
                  ./gradlew check
                  '''
            //    }
            }
        }

     stage('Build') {
        steps{
          //dir(DIR) {
            sh './gradlew build'
           //sh '/var/jenkins_home/workspace/learn-jenkins-app/gradlew build'
        //  }
        }
     }

     stage('Run tests') {
                 steps {
                //     dir(DIR) {
                         sh './gradlew test'
              //   }
             }
        }
    }

    post {
            always {
                cleanWs()
            }
        }
}