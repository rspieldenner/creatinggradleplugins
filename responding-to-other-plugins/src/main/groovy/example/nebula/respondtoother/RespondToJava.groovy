package example.nebula.respondtoother

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy

class RespondToJava implements Plugin<Project> {
  @Override
  void apply(Project project) {
    // 1. lets try a naive copy just expecting the right things to be in place
    project.tasks.create('copyCompileLibs', Copy) {
      from project.configurations.compile
      into "${project.buildDir}/myCompileClasspath"
    }
  }
}
