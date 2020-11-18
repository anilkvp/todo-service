pipeline {
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
    }
}