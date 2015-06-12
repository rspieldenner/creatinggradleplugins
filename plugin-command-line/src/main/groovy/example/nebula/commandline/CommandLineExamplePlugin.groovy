package example.nebula.commandline

import org.gradle.api.Plugin
import org.gradle.api.Project

class CommandLineExamplePlugin implements Plugin<Project> {
  @Override
  void apply(Project project) {
    def myExtension = project.extensions.create('myexample', ExampleExtension)
    def exampleTask = project.tasks.create('example', Example)

    exampleTask.conventionMapping.with {
      message = { // replace task property with a closure, check to see if a property was set on the command line
        if (project.hasProperty('myexample.message')) {
          project.property('myexample.message') // return command line property if set
        } else {
          myExtension.message
        }
      }
    }
  }
}
