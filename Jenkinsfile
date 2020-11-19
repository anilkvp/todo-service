pipeline {
    environment {
        registry = "anilkvp/todo-service"
        registryCredential = 'Docker-Hub'
        dockerImage = ''
    }
    agent any
    stages {
        stage("Check out project") {
            steps {
                echo "connecting to git"
                git url:"https://github.com/anilkvp/todo-service.git", branch:"main"
            }
        }
        stage("Compile and Package") {
            steps {
                sh "mvn clean package"
            }
        }
        stage("Build docker image ") {
            steps {
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage("Push image to registry") {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:latest"
            }
        }
    }
}