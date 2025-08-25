// CODE_CHANGES = getGitChanges()
// All env vars - http://cj08:8080/env-vars.html/

pipeline {
    agent any

    tools {
        maven 'Maven'   // name of tool, under 'manage' -> 'configure tools'
    }

    environment {
        NEW_VERSION = '1.3.0'
        // SERVER_CREDENTIALS = credentials('MDE101')   
    }

    parameters {
        // string(name: 'VERSION', defaultValue: '', description: 'version to deploy to PROD')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {

        stage("build") {

            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {

                echo 'building application ...'
                echo "building new version ${NEW_VERSION}"
                // sh "mvn install"
            }
        }

        stage("test") {

            when {
                expression {
                    params.executeTests
                }
            }
            steps {

                echo 'testing application ...'
                
            }
        }

        stage("deploy") {

            steps {

                echo 'deploying application ...'
                echo "deploying version ${params.VERSION}"
                // withCredentials([
                //     usernamePassword(credentials: 'MDE101', usernameVariable: USER, passwordVariable: PWD)
                // ]) {
                //     echo "deploying version ${params.VERSION} by ${USER}"
                // }
                
            }
        }

    }
}