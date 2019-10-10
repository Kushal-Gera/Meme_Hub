package kushal.application.memehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        String title = getIntent().getStringExtra("title");

        big_text.setText(title.toString());
        Glide.with(this).load(url).placeholder(R.drawable.placeholder).fitCenter().into(big_image);

        big_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

            }
        });


    }
}
