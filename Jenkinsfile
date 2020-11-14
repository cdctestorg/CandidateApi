pipeline {
    agent any
   
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble docker'
            }
        }
        stage('Test'){
            steps {
                sh './gradlew test'
            }
        }
    }
}
