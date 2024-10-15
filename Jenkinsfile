@Library('global-library@main') _

pipeline {
    agent any
    tools{
        maven 'maven-3.9.4'
        // dependencyCheck 'OWASP-Dependency-Check'
        // tool: 'Dependency-Check CLI'
    }
    parameters {
        choice(
            name: 'envSelected',
            choices: ['dev', 'prod', 'qa'],
            description: 'Please choose en environment where you want to run?'
        )
    }
    stages {
        
        stage("Checkout"){
            steps {
                // script{
                //     scm.checkout('main','spring-cred','false','https://github.com/aayushave/spring-cred.git')
                // }
                // git branch: 'main' , changelog: false, credentialsId: 'spring-cred', poll: 'false', url: 'https://github.com/aayushave/spring-cred.git'
            }
                
        }
            
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Load and use functions from the script within this block
                    // sonarAnalysisWindows.sonarAnalysis("./","http://localhost:9000/","sqp_7aedf3441ebf9bc7c64e5ad74a9c650eec9922c7","sonar","sonar-cred","http://localhost:5432/","postgres","postgres")
                    sonarAnalysisWindows.sonarAnalysis("./backend/","http://localhost:9000/","sqp_3935282b41f0497cf5dde1dc6fd945aa389d08ff","callisto-dev","callisto-dev","http://localhost:5432/","postgres","postgres")
                }
            }
        }
        
        stage('Maven Build') {
            steps {
                script {
                    // sh "pwd"
                    // buildWinMaven.buildJarFromWinDirectory("./backend")
                    mavenWindows.buildFromDirectory("./backend/")
                }
            }
        }
        
        // stage('Maven Test') {
        //     steps {
        //         script {
        //             // sh "pwd"
        //             // buildWinMaven.buildJarFromWinDirectory("./backend")
        //             testMaven.testFromWinDirectory("./backend/")
        //         }
        //     }
        // }

        stage('Security Dependency Check') {
            steps {
                script {
                    owaspDependencyCheckWindows.checkDependency("OWASP-Data")
                    }
            }
        }
        
        stage('Docker Build Image 1') {
            steps {
                script {
                    dockerWindows.buildImage("./backend/services/authentication-service/","192.168.34.62","8082","authentication-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
                stage('Docker Build Image 2') {
            steps {
                script {
                    dockerWindows.buildImage("./backend/services/incident-service/","192.168.34.62","8082","incident-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
                stage('Docker Build Image 3') {
            steps {
                script {
                    dockerWindows.buildImage("./backend/services/global-service/","192.168.34.62","8082","global-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
                stage('Docker Build Image 4') {
            steps {
                script {
                    dockerWindows.buildImage("./backend/services/activity-service/","192.168.34.62","8082","activity-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
                stage('Docker Build Image 5') {
            steps {
                script {
                    dockerWindows.buildImage("./backend/services/ticket-service/","192.168.34.62","8082","ticket-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
        // stage('Workspace Cleanup') {
        //     steps {
        //         script {
        // //             // Load and use functions from the script within this block
        // //             sonarAnalysis.sonarWinAnalysis("./","http://localhost:9000/","sqp_7aedf3441ebf9bc7c64e5ad74a9c650eec9922c7","sonar","sonar-cred","http://localhost:5432/","postgres","postgres")
        //         cleanWs disableDeferredWipeout: true, deleteDirs: true
        //         }
        //     }
        // }

        stage('Docker Push Image 1') {
            steps {
                script{
                    dockerWindows.pushImage("nexus-repository","192.168.34.62","8082","authentication-service","0.0.1-SNAPSHOT")
                }
            }
        }
                stage('Docker Push Image 2') {
            steps {
                script{
                    dockerWindows.pushImage("nexus-repository","192.168.34.62","8082","incident-service","0.0.1-SNAPSHOT")
                }
            }
        }
                stage('Docker Push Image 3') {
            steps {
                script{
                    dockerWindows.pushImage("nexus-repository","192.168.34.62","8082","global-service","0.0.1-SNAPSHOT")
                }
            }
        }
                stage('Docker Push Image 4') {
            steps {
                script{
                    dockerWindows.pushImage("nexus-repository","192.168.34.62","8082","activity-service","0.0.1-SNAPSHOT")
                }
            }
        }
                stage('Docker Push Image 5') {
            steps {
                script{
                    dockerWindows.pushImage("nexus-repository","192.168.34.62","8082","ticket-service","0.0.1-SNAPSHOT")
                }
            }
        }
        
        // stage('Run Script'){
        //     steps{
        //         script{
        //             runScript.batScript("start.bat",env.envSelected)
        //         }
        //     }
        // }
        
        // stage("Kubernetes Apply"){
        //     steps{
        //         script{
        //             env.KUBECONFIG = "./Config"
        //             // kubectlWindows.apply("./namespace.yaml")
        //             kubectlWindows.apply("./",env.envSelected)
        //             // kubectlWindows.apply("./postgres-service.yaml",env.envSelected)
        //             // kubectlWindows.apply("./spring-service.yaml",env.envSelected)
        //         }
        //     }
        // }
    }
    
}

