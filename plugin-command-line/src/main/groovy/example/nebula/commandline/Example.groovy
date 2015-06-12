package example.nebula.commandline

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class Example extends DefaultTask {
  String message

  @TaskAction
  void printMessage() {
    println getMessage() // need to use property getter method to allow for the late binding  
  }
}
