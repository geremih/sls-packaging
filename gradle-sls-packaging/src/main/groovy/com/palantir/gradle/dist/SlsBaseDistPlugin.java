/*
 * (c) Copyright 2019 Palantir Technologies Inc. All rights reserved.
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

package com.palantir.gradle.dist;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SlsBaseDistPlugin implements Plugin<Project> {

    /**
     * The name of the outgoing configuration. This will include the SLS artifact being published, and if running on
     * Gradle 5.3+, it will also include the SLS product dependencies.
     */
    public static final String SLS_CONFIGURATION_NAME = "sls";

    @Override
    public final void apply(Project project) {
        project.getConfigurations().create(SLS_CONFIGURATION_NAME);

        if (SlsDistPublicationPlugin.canApply()) {
            project.getPluginManager().apply(SlsDistPublicationPlugin.class);
        }
    }
}