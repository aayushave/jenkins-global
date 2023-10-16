/**
 * Delete all files in the Jenkins workspace directory.
 *
 * This function deletes all files and directories within the current Jenkins workspace.
 * Use with caution, as it permanently removes workspace contents.
 */
def deleteAll(){
  // Delete all files and directories in the Jenkins workspace.
  // CAUTION: This action is irreversible and will remove workspace contents.
  cleanWs disableDeferredWipeout: true, deleteDirs: true
}
