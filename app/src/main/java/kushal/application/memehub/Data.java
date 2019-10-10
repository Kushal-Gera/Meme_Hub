package kushal.application.memehub;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("memes")
    private List<MemesItem> memes;

    public void setMemes(List<MemesItem> memes) {
        this.memes = memes;
    }

    List<MemesItem> getMemes() {
        return memes;
    }


}