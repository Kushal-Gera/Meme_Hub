package kushal.application.memehub;

import com.google.gson.annotations.SerializedName;

public class Memes {

    @SerializedName("data")
    private Data data;

    @SerializedName("success")
    private boolean success;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return
                "Memes{" +
                        "data = '" + data + '\'' +
                        ",success = '" + success + '\'' +
                        "}";
    }
}