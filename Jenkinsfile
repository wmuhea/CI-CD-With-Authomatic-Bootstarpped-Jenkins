pipeline {
    agent any
    triggers {
            pollSCM '* * * * *'
    }
    stages {
            stage('Build') {
                steps {
                    sh './gradlew assemble'
                }
            }
            stage('Test') {
                  steps {
                     sh './gradlew test'
                  }
            }
            stage('Build Docker Image') {
                steps{
                    sh './gradlew docker'

                }
            }
            stage('Push Docker Image') {
            /* we need to login to the dockerhub to push the image
            after building it, for that we will use environment here */
                environment {
                    DOCKER_HUB_LOGIN=credentials('docker-hub')
                }
                steps {
                    sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                    sh './gradlew dockerPush'
                } */
            }
    }
}
