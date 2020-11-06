pipeline {
    agent any
        tools{
            maven 'apache-maven-3.6.3'
        }
    stages {
        stage('PreWork') {
            steps {
                script {
                    echo env.JOB_NAME
                    try{
                        sh 'rm -r *'
                        sh 'pkill -f sorters'
                    }catch(Exception e){
                        echo e.toString()
                    }

                }
            }
        }
        stage('Get Code') {
            steps {

                sh 'git clone --single-branch --branch dev https://github.com/dklocek/SortAlgorithms.git'

            }
        }

        stage('Build'){
            steps {
                 dir("${env.WORKSPACE}/SortAlgorithms"){
                    sh "mvn package -DskipTests -X"

                }
            }
        }

        stage('Prepare'){
                    steps{
                        script{
                            withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                                dir("${env.WORKSPACE}/SortAlgorithms/target"){
                                   try{
                                     sh "mv *.jar sorters.jar"
                                     sh "atd"
                                   }catch(Exception e){
                                        echo e.toString()
                                     }

                                }
                            }
                        }
                    }
                }

        stage('Run'){
            steps{
                script{
                    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                        dir("${env.WORKSPACE}/SortAlgorithms/target"){

                             sh 'echo "java -Dserver.port=50001 -jar sorters.jar --server.port=50010 \\&" | at now + 1 min'

                        }
                    }
                }
            }
        }

                stage('Verify'){
                    steps{
                        sh "sleep 90"
                            script{
                                int status = sh(script: "curl -sLI -w '%{http_code}' localhost:50010/test -o /dev/null", returnStdout: true)
                                if (status != 200 && status != 201) {error("Returned status code = $status when calling $url")}
                                echo status.toString()
                                }
                    }
                }
    }
}
