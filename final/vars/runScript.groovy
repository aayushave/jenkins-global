/**
 * Execute a shell script.
 *
 * @param scriptName Name of the shell script to execute.
 * @param param (Optional) Additional parameters or options for the script.
 */
def shScript(scriptName, param=""){
  sh "${scriptName} ${param}"
}

/**
 * Execute a batch script.
 *
 * @param scriptName Name of the batch script to execute.
 * @param param (Optional) Additional parameters or options for the script.
 */
def batScript(scriptName, param=""){
  bat "${scriptName} ${param}"
}
