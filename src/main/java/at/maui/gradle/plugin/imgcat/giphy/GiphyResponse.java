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

package at.maui.gradle.plugin.imgcat.giphy;

public class GiphyResponse {
    private GiphyData data;
    private GiphyMeta meta;

    public GiphyData getData() {
        return data;
    }

    public GiphyMeta getMeta() {
        return meta;
    }

    public class GiphyData {
        private String type, id, url, imageOriginalUrl, imageUrl;

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public String getImageOriginalUrl() {
            return imageOriginalUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

    public class GiphyMeta {
        private int status;
        private String msg;

        public int getStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }
    }
}
