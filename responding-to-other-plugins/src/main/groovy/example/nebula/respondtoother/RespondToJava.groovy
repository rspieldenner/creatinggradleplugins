package example.nebula.respondtoother

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.Copy

class RespondToJava implements Plugin<Project> {
  @Override
  void apply(Project project) {
    // 1. lets try a naive copy just expecting the right things to be in place
    /*project.tasks.create('copyCompileLibs', Copy) {
      from project.configurations.compile
      into "${project.buildDir}/myCompileClasspath"
    }*/

    // 2. next check if the java plugin has been applied so the compile configuration is in place
    /*if (project.plugins.hasPlugin(JavaPlugin)) {
      project.tasks.create('copyCompileLibs', Copy) {
        from project.configurations.compile
        into "${project.buildDir}/myCompileClasspath"
      }
    }*/

    // 3. use plugins.withType to respond to the java plugin in which ever order they are applied
    project.plugins.withType(JavaPlugin) {
      project.tasks.create('copyCompileLibs', Copy) {
        from project.configurations.compile
        into "${project.buildDir}/myCompileClasspath"
      }
    }
  }
}
