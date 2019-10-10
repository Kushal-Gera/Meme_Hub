package kushal.application.memehub;

import com.google.gson.annotations.SerializedName;

public class MemesItem {

    @SerializedName("name")
    private String name;

    @SerializedName("width")
    private int width;

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private int height;

    @SerializedName("box_count")
    private int boxCount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }

    public int getBoxCount() {
        return boxCount;
    }

    @Override
    public String toString() {
        return
                "MemesItem{" +
                        "name = '" + name + '\'' +
                        ",width = '" + width + '\'' +
                        ",id = '" + id + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        ",box_count = '" + boxCount + '\'' +
                        "}";
    }
}