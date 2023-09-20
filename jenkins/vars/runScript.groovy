def shScript(scriptName, envType=""){
  sh "${scriptName} ${envType}"
}

def batScript(scriptName, envType=""){
  bat "${scriptName} ${envType}"
}
