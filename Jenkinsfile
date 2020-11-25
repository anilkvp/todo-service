pipeline {
    environment {
        registry = "coldstone.azurecr.io/todo-service"
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
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage("Push image to registry") {
            steps {
                script {
                    docker.withRegistry( 'https://coldstone.azurecr.io', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}