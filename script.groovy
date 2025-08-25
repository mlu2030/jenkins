def buildApp() {
    echo 'building application ...'
    // sh "mvn install"

}

def testApp() {
    echo "testing new version ${NEW_VERSION}"

}

def deployApp() {
    echo 'deploying application ...'
    echo "deploying version ${params.VERSION}"
}

return this