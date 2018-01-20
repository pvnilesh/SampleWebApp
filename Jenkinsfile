pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'cd "$(dirname "$(find . -type f -name pom.xml | head -1)")" && mvn -B -DskipTests clean package' 
            }
        }
    }
}