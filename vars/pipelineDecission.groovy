#!groovy

// this file is to decide which pipeline we want to call among all the shared-librery pipelines
// Here, we are calling the configMap one, for which we created a def file in 'Jenkinsfile' under backend-jenkins-eks

// declaring a function
def decidePipeline(Map configMap) {
    type = configMap.get("type")
    switch(type) {
        case "nodejsEKS":
            nodejsEKS(configMap)
            break
        case "nodejsVM":
            nodejsVM(configMap)
            break
        default:
            error: "type is not matched" 
            break   
    }       
}