pipeline {
    agent any
    parameters {
            choice(name: 'port', choices: ['50001', '50002', '50003', '50004', '50005', '50006', '50007', '50008', '50009', '50010'], description: 'Port')
        }
        tools{
            maven 'apache-maven-3.6.3'
        }
    stages {
        stage('PreWork') {
            steps {
                script {
                    echo env.JOB_NAME
                    try{
                        sh 'pkill -f $JOB_NAME.jar'
                      //  sh 'ps axf | grep $JOB_NAME.jar | grep -v grep | awk "{print "kill -9 " $1}" | sh'
                        sh 'rm -rf *'
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
                            dir("${env.WORKSPACE}/SortAlgorithms/target"){
                                try{
                                    sh 'mv *.jar $JOB_NAME.jar'
                                }catch(Exception e){
                                    echo e.toString()
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

                             sh 'nohup java -Dserver.port=$port -jar ${JOB_NAME}.jar --server.port=$port &'

                        }
                    }
                }
            }
        }

                stage('Verify'){
                    steps{
                        sh "sleep 30"
                            script{
                                int status = sh(script: "curl -sLI -w '%{http_code}' localhost:$params.port/test -o /dev/null", returnStdout: true)
                                if (status != 200 && status != 201) {error("Returned status code = $status when calling $url")}
                                echo status.toString()
                                }
                    }
                }
    }
}
