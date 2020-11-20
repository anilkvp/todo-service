pipeline {
    environment {
        registry = "todo-service"
        registryCredential = 'azure-cloud-registry'
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
                    docker.withRegistry( 'https://coldstonereg.azurecr.io', registryCredential ) {
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