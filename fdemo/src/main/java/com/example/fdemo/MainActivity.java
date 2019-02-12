package com.example.fdemo;


import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;

import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


public class MainActivity extends AppCompatActivity {

    private Uri uri;
    private SimpleDraweeView draweeView;
    private SimpleDraweeView draweeView2;
    private SimpleDraweeView draweeView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uri = Uri.parse("https://09imgmini.eastday.com/mobile/20190212/2019021212_16355587f5e84871b59d645cdc7fdccd_9894_wmk.jpg");
        draweeView = findViewById(R.id.img);
        draweeView2 = findViewById(R.id.img2);
        draweeView3 = findViewById(R.id.img3);

    }


    public void yuan(View view) {
        draweeView.setVisibility(View.VISIBLE);
        draweeView2.setVisibility(View.GONE);
        draweeView3.setVisibility(View.GONE);
        draweeView.setImageURI(uri);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20f);
        roundingParams.setBorderColor(Color.RED);
        draweeView.getHierarchy().setRoundingParams(roundingParams);
        draweeView.setImageURI(uri);

    }

    public void circle(View view) {
        draweeView.setVisibility(View.VISIBLE);
        draweeView2.setVisibility(View.GONE);
        draweeView3.setVisibility(View.GONE);
        draweeView.setImageURI(uri);
        final RoundingParams roundingParams = RoundingParams.fromCornersRadius(20f);
        roundingParams.setBorderColor(Color.RED);
        draweeView.getHierarchy().setRoundingParams(roundingParams);
        draweeView.setImageURI(uri);
    }

   public void jianjin(View view) {

        draweeView.setVisibility(View.GONE);
       draweeView2.setVisibility(View.GONE);
       draweeView3.setVisibility(View.VISIBLE);
       draweeView3.setImageURI(uri);
         ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                 .setProgressiveRenderingEnabled(true)
                 .build();
         DraweeController controller = Fresco.newDraweeControllerBuilder()
                 .setImageRequest(request)
                 .setOldController(draweeView3.getController())
                 .build();
         draweeView3.setController(controller);
    }
}
