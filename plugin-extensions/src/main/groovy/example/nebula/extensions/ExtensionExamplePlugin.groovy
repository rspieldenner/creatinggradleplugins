package example.nebula.extensions

import org.gradle.api.Plugin
import org.gradle.api.Project

class ExtensionExamplePlugin implements Plugin<Project> {
  @Override
  void apply(Project project) {
    def myExtension = project.extensions.create('myexample', ExampleExtension)
    def exampleTask = project.tasks.create('example', Example)

    exampleTask.conventionMapping.with {
      message = { myExtension.message } // replace task property with a closure
    }
  }
}
