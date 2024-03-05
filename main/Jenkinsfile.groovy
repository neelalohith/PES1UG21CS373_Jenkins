pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Compile the .cpp file using a shell script
                    sh 'g++ -o output PES1UG21CS373-1.cpp'
                }
            }
        }
        
        stage('Test') {
            steps {
                script {
                    // Print output of .cpp file using a shell script
                    sh './output'
                }
            }
        }
        
        stage('Deploy') {
            steps {
                // Example deployment steps, replace with actual deployment steps
                echo 'Deploying...'
                sh 'ssh user@server "service restart"'
            }
        }
    }
    
    post {
        always {
            // Display "pipeline failed" in case of any errors within the pipeline
            catchError {
                echo 'Pipeline succeeded'
            }
        }
    }
}