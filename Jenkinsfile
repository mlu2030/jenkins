// CODE_CHANGES = getGitChanges()
// All env vars - http://cj08:8080/env-vars.html/

def gv

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

        stage("init") {

            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build") {

            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("test") {

            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {

            steps {
                script {
                    gv.deployApp()
                }
            }
        }

    }
}