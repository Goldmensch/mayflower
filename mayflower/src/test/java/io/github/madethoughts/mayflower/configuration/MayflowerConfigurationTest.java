/*
 * Copyright 2023 original authors
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

package io.github.madethoughts.mayflower.configuration;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import plugin.TestPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class MayflowerConfigurationTest {
    public static final Path RESOURCES_ROOT = Path.of("src", "test", "resources").toAbsolutePath();

    protected ServerMock server;
    protected TestPlugin plugin;
    protected Path config;

    @BeforeEach
    public void setUp() throws IOException {
        server = MockBukkit.mock();
        createConfig();
        plugin = MockBukkit.load(TestPlugin.class);
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }

    protected void createConfig() throws IOException {
        config = Path.of(server.getPluginManager().getParentTemporaryDirectory().getAbsolutePath(),
                "MayflowerTestPlugin-0.1", "config.yml"
        );

        Files.createDirectories(config.getParent());

        Files.copy(templateConfig(), config);
    }

    protected abstract Path templateConfig();
}
