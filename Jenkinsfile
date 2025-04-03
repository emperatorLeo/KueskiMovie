pipeline {
    agent {
        docker { image 'cimg/android:2025.04.1' }
    }
    environment {
     DIR = "https://github.com/emperatorLeo/KueskiMovie"
    }
    stages {
     stage('Checkout'){
        steps {
          sh 'git clone https://github.com/emperatorLeo/KueskiMovie.git'
        }
      }

     stage('Setup'){
        steps {
            //dir(DIR){
                  sh '''
                  pwd
                  chmod +x ./gradlew
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
}