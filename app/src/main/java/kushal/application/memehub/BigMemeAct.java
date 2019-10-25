package kushal.application.memehub;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;

public class BigMemeAct extends AppCompatActivity {

    ImageView big_image;
    Toolbar toolbar;
    TextView big_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_meme);

        big_image = findViewById(R.id.big_image);
        big_text = findViewById(R.id.big_text);
        toolbar = findViewById(R.id.toolbar2);

        final String url = getIntent().getStringExtra("image_url");
        final String title = getIntent().getStringExtra("title");

        big_text.setText(title.toString());
        Glide.with(this).load(url).placeholder(R.drawable.placeholder).fitCenter().into(big_image);

        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(BigMemeAct.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(BigMemeAct.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1234);
                }
                else {
                    DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                    request.setTitle("Downloading Image: " + title);
                    request.setDescription("Downloading an image file, please wait.");
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, "Images");

                    downloadManager.enqueue(request);
                    Toast.makeText(BigMemeAct.this, "downloading...", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
