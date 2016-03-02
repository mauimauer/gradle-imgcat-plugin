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

import at.maui.gradle.plugin.imgcat.giphy.GiphyResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImgcatTask extends DefaultTask {

    private static final String GIPHY_API_BASE_URL = "http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC";

    @TaskAction
    public void imgcat() {
        ImgcatExtension extension = getProject().getExtensions().findByType(ImgcatExtension.class);
        if (extension == null) {
            extension = new ImgcatExtension();
        }

        if(extension.getSource().equals(ImgcatExtension.SOURCE_GIPHY)) {

            try {
                URL giphyUrl = null;
                if (extension.getValue() == null) {
                    giphyUrl = new URL(GIPHY_API_BASE_URL);
                } else {
                    giphyUrl = new URL(GIPHY_API_BASE_URL + "&tag=" + extension.getValue());
                }


                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create();

                GiphyResponse giphyResponse = gson.fromJson(new String(Utils.fetchUrl(giphyUrl)), GiphyResponse.class);
                System.out.println(Imgcat.output("giphy.gif", true,
                        Utils.fetchUrl(new URL(giphyResponse.getData().getImageUrl()))));
                System.out.println("Powered By Giphy (http://www.giphy.com)");

            } catch(Exception ex) {
                System.out.println("Could'nt imgcat random giphy image");
            }
        } else if (extension.getSource().equals(ImgcatExtension.SOURCE_FILE)) {
            try {
                File localFile = new File(extension.getValue());

                System.out.println(Imgcat.output(localFile.getName(), true,
                        Utils.fetchFile(localFile)));
            } catch (IOException e) {
                System.out.println("Could'nt imgcat local file at " + extension.getValue());
            }
        } else if (extension.getSource().equals(ImgcatExtension.SOURCE_REMOTE)) {
            try {
                System.out.println(Imgcat.output("remote.gif", true,
                        Utils.fetchUrl(new URL(extension.getValue()))));
            } catch (IOException e) {
                System.out.println("Could'nt imgcat remote with URL " + extension.getValue());
            }
        }
    }
}
