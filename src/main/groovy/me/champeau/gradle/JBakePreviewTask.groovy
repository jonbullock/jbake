/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.champeau.gradle

import org.gradle.api.internal.AbstractTask
import org.gradle.api.logging.LogLevel
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import org.jbake.launcher.JettyServer

class JBakePreviewTask extends AbstractTask {

    @InputDirectory File input = new File("$project.buildDir/jbake")

    @Input String port = "8820"

    JBakePreviewTask() {
    	group = 'jbake'
    	description = 'Starts up a Jetty container to preview your JBake site locally.'
    }

    @TaskAction
    void jbakePreview() {
        logging.level = LogLevel.INFO
        JettyServer.run( input.absolutePath, port )
    }
}
