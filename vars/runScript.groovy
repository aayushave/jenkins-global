def shScript(scriptName, envType=""){
  sh "${scriptName}.sh ${envType}"
}

def batScript(scriptName, envType=""){
  bat "${scriptName}.sh ${envType}"
}
