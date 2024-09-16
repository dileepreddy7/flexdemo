/*
 * SonarQube Java Properties Analyzer
 * Copyright (C) 2015-2017 David RACODON
 * david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.jproperties.visitors;

import org.sonar.plugins.jproperties.api.tree.PropertiesTree;
import org.sonar.plugins.jproperties.api.visitors.TreeVisitorContext;

import java.io.File;

public class JavaPropertiesVisitorContext implements TreeVisitorContext {

  private final PropertiesTree tree;
  private final File file;

  public JavaPropertiesVisitorContext(PropertiesTree tree, File file) {
    this.tree = tree;
    this.file = file;
  }

  @Override
  public PropertiesTree getTopTree() {
    return tree;
  }

  @Override
  public File getFile() {
    return file;
  }

}
