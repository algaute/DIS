/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lab4tech;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lab4tech.config.ApplicationTestConfig;

/**
 * Abstract integration test to populate the database with dummy data.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = { "application.properties","application.test.properties" })
@SpringApplicationConfiguration(classes = ApplicationTestConfig.class)
@Transactional
public abstract class AbstractIntegrationTest {

}
