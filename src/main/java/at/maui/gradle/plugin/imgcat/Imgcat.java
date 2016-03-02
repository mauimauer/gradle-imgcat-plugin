/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package at.maui.gradle.plugin.imgcat;

import java.util.Base64;

public class Imgcat {
    public static String output(String name, boolean inline, byte[] image) {
        StringBuilder sb = new StringBuilder();
        sb.append("\033]");
        sb.append("1337;File=");
        sb.append("name=");
        sb.append(Base64.getEncoder().encodeToString(name.getBytes()));
        sb.append(";");
        sb.append("size=");
        sb.append(image.length);
        sb.append(";inline=");
        sb.append(inline ? "1" : "0");
        sb.append(":");
        sb.append(Base64.getEncoder().encodeToString(image));
        sb.appendCodePoint(7);
        return sb.toString();
    }
}
