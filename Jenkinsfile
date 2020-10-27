pipeline {
    agent any

    stages {
        stage('PreWork') {
            steps {
                script {
                    echo env.JOB_NAME
                    try{
                        sh 'rm * -r '
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

        stage('Run'){
            steps{
                script{
                    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                        dir("${env.WORKSPACE}/SortAlgorithms/target"){

                             sh "mv *.jar sorters.jar"
                             sh "atd"
                             sh 'echo "java -Dserver.port=50001 -jar sorters.jar --server.port=50001 \\&" | at now + 1 min'

                        }
                    }
                }
            }
        }

                stage('Verify'){
                    steps{
                        sh "sleep 90"
                            script{
                                int status = sh(script: "curl -sLI -w '%{http_code}' localhost:50001/test -o /dev/null", returnStdout: true)
                                if (status != 200 && status != 201) {error("Returned status code = $status when calling $url")}
                                echo status.toString()
                                }
                    }
                }
    }
}
